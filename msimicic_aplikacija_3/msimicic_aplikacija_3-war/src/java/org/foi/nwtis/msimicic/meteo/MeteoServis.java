/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.meteo;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author Martina
 */
public class MeteoServis extends Thread {
    
    private ServletContext sc;
    @Resource(mappedName = "jms/aplikacija_3_pool_tvornica")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/aplikacija_3_tvornica")
    private Queue queue;
    private int interval;

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

    private void posaljiZahtjev(Poruka poruka) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/jms/msimicic_Tvornica");
        Destination d = (Destination) c.lookup("java:comp/env/jms/msimicic_RedCekanja");

        interval = Integer.parseInt(sc.getInitParameter("intervalJMS"));
        System.out.println("...početak slanja JMS poruke...");
        Connection connection = cf.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(d);
        ObjectMessage message = session.createObjectMessage();
        message.setObject((Serializable) poruka);
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        System.out.println("...JMS poruka poslana, veza zatvorena...");
    }

    private void noviZagtjev() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean noviZahtjev() {
        return true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                noviZahtjev();
                Thread.sleep(interval * 1000);
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
    }
}