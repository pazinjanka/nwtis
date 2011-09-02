/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.meteo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
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
    Poruka p;

    ZahtjeviFacadeRemote zfr = getZahtjeviFacadeRemote();

    public MeteoServis() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public MeteoServis(ServletContext sc) {
        super();
        this.sc = sc;
    }

    /**
     * Pregledava zahtjeve iz baze podataka i salje JMS poruke za one koje treba
     * Kod slanja poziva posaljiZahtjev metodu koja dohvaća tvornicu i redcekanja
     */
    private void pregledaj() {
        interval = Integer.parseInt(sc.getInitParameter("intervalJMS"));

        String msgText;
        Zahtjevi zahtjev;
        // <editor-fold defaultstate="collapsed" desc="weatherBug">
        String APICODE = "A6458871574";
        WeatherBugWebServices service = new WeatherBugWebServices();
        WeatherBugWebServicesSoap port;
        LiveWeatherData podaci;
        // </editor-fold>

        List <Zahtjevi> zahtjeviDP = zfr.getZahtjeviData();
        if (zahtjeviDP != null) {
            msgText = "Postovani,\n vasa pretplata na meteoroloske podatke \n";
            Iterator iterator = zahtjeviDP.iterator();

            while (iterator.hasNext()) {
                zahtjev = (Zahtjevi) iterator.next();
                // <editor-fold defaultstate="collapsed" desc="zahtjevi za data() data(parametri);">
                if (zahtjev.getNaredba().equals("data") || zahtjev.getNaredba().equals("data(parametri")) {
                    p = new Poruka();
                    port = service.getWeatherBugWebServicesSoap();
                    podaci = port.getLiveWeatherByCityCode(Integer.toString(zahtjev.getGradCode()), UnitType.METRIC, APICODE);
                    msgText = msgText + "Grad: "+ podaci.getCity()
                                +", temperatura: "+ podaci.getTemperature()
                                +", vlaznost zraka: "+podaci.getHumidity()
                                +", tlak zraka: "+podaci.getPressure()
                                +", brzina vjetra: "+podaci.getWindSpeed()
                                +", za dan: "+podaci.getObDateTime().toString()+"\n\n";
                    this.kraj(zahtjev);
                    p.setKorisnik(zahtjev.getKorisnici());
                    System.out.println("Prva kategorija");
                    msgText = msgText + "JMS servis...";
                    p.setSadrzaj(msgText);
                    p.setNaslov("Meteoroloski podaci");
                }
                // </editor-fold>
                // <editor-fold defaultstate="collapsed" desc="zahtjevi za forecast();">
                else if (zahtjev.getNaredba().equals("forecast")){
                    port = service.getWeatherBugWebServicesSoap();
                    ArrayOfAnyType forecast = port.getForecastByCityCode(Integer.toString(zahtjev.getGradCode()), UnitType.METRIC, APICODE);
                    List<Object> list = forecast.getAnyType();
                    Iterator itr = list.iterator();
                    while (itr.hasNext()) {
                        ApiForecastData ap = (ApiForecastData) itr.next();
                        msgText = msgText + "Naslov: "+ ap.getTitle()
                                +", opis: "+ ap.getDescription()
                                +", temperatura (low): "+ ap.getTempLow()
                                +", temperatura (high): "+ ap.getTempHigh()
                                +", prognoza: "+ ap.getPrediction()
                                +", prognoza (short) "+ ap.getShortPrediction()
                                +", vise informacija: "+ ap.getWebUrl() +"\n\n";
                        this.kraj(zahtjev);
                        p.setKorisnik(zahtjev.getKorisnici());
                        System.out.println("Forecast kategorija");
                    }
                }
                // </editor-fold>
                else if (zahtjev.getNaredba().equals("data(period)")){
                    System.out.println("Data(perod) kategorija");
                }

                if (p != null){
                    try {
                        posaljiZahtjev(p);
                        System.out.println("Podaci poslani");
                    } catch (Exception e) {
                        System.out.println("Neuspješno slanje JMS poruke"+e);
                    }
                }
            }
        }
    }

    private Message noviZahtjev(Session session, Object messageData) throws JMSException {
        ObjectMessage msg = session.createObjectMessage();
        msg.setObject((Serializable) messageData);
        return msg;
    }


    /**
     * Posalji zahtjev salje JMS poruku, povezuje i zatvara vezu sa tvornicom i redom čekanja
     * @param messageData poruka koju je potrebno poslat
     * @throws NamingException
     * @throws JMSException
     */
    private void posaljiZahtjev(Object messageData) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/jms/msimicic_Tvornica");
        Destination destination = (Destination) c.lookup("java:comp/env/jms/msimicic_RedCekanja");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
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
        super.run();
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
        zahtjev.setPutaPoslano(putaPoslano++);
        if (putaPoslano == brojDana) zahtjev.setZavrseno(1);
        zfr.edit(zahtjev);
    }
}