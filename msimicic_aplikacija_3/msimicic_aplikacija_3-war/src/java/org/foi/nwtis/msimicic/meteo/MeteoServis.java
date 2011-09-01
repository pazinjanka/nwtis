/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.meteo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import org.foi.nwtis.msimicic.eB.Zahtjevi;
import org.foi.nwtis.msimicic.sB.ZahtjeviFacadeRemote;

/**
 *
 * @author Martina
 */
public class MeteoServis extends Thread {
    
    private ServletContext sc;
    private int interval;


    ZahtjeviFacadeRemote zfr = getZahtjeviFacadeRemote();

    public MeteoServis() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public MeteoServis(ServletContext sc) {
        super();
        this.sc = sc;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

    private void pregledaj() {
        interval = Integer.parseInt(sc.getInitParameter("intervalJMS"));
        Poruka p = new Poruka();
        String msgText;
        Zahtjevi zahtjev;
        // <editor-fold defaultstate="collapsed" desc="weatherBug">
        String APICODE = "A6458871574";
        WeatherBugWebServices service = new WeatherBugWebServices();
        WeatherBugWebServicesSoap port = service.getWeatherBugWebServicesSoap();
        LiveWeatherData podaci;
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="zahtjevi za data(parametri);">
        List <Zahtjevi> zahtjeviDP = zfr.getZahtjeviDataParametri();
        if (zahtjeviDP != null) {
            msgText = "Postovani,\n vasa pretplata na meteoroloske podatke \n";
            Iterator iterator = zahtjeviDP.iterator();
            while (iterator.hasNext()) {
                zahtjev = (Zahtjevi) iterator.next();
                podaci = port.getLiveWeatherByCityCode(Integer.toString(zahtjev.getGradCode()), UnitType.METRIC, APICODE);
                msgText = msgText + "Grad: "+ podaci.getCity()
                        +", temperatura: "+ podaci.getTemperature()
                        +", vlaznost zraka: "+podaci.getHumidity()
                        +", tlak zraka: "+podaci.getPressure()
                        +", brzina vjetra: "+podaci.getWindSpeed()
                        +", za dan: "+podaci.getObDateTime().toString()+"\n\n";
                this.kraj(zahtjev);
            }
            msgText = msgText + "JMS servis...";
            p.setSadrzaj(msgText);
            p.setNaslov("Meteoroloski podaci, kategorija 3");
            System.out.println("Podaci datum(parametri) dohvaćeni");
        }
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="zahtjevi za data(datumi);">
        //List <Zahtjevi> zahtjeviDD = zfr.getZahtjeviDataDatumi();
        System.out.println("Podaci datum(datumi) dohvaćeni");
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="zahtjevi za forecast();">
        //List <Zahtjevi> zahtjeviF = zfr.getZahtjeviForecast();
        System.out.println("Podaci forecast dohvaćeni");
        // </editor-fold>
        try {
            posaljiZahtjev(p);
        } catch (Exception e) {
            System.out.println("Neuspješno slanje JMS poruke"+e);
        }
    }

    private Message noviZahtjev(Session session, Object messageData) throws JMSException {
        ObjectMessage msg = session.createObjectMessage();
        msg.setObject((Serializable) messageData);
        return msg;
    }

    private void posaljiZahtjev(Object messageData) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/jms/msimicic_Tvornica");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("java:comp/env/jms/msimicic_RedCekanja");
            MessageProducer mp = s.createProducer(destination);
            mp.send(noviZahtjev(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    System.out.println("Nesto po krivom u zatvaranju sesije: "+e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                pregledaj();
                Thread.sleep(interval * 1000);
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
    }

    private ZahtjeviFacadeRemote getZahtjeviFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (ZahtjeviFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/ZahtjeviFacade!org.foi.nwtis.msimicic.sB.ZahtjeviFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod ZahtjeviFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private void kraj(Zahtjevi zahtjev) {
        Integer putaPoslano = zahtjev.getPutaPoslano();
        Integer brojDana = zahtjev.getBrojDana();
        zahtjev.setBrojDana(brojDana++);
        if (putaPoslano == brojDana) zahtjev.setZavrseno("1");
        zfr.edit(zahtjev);
    }
}