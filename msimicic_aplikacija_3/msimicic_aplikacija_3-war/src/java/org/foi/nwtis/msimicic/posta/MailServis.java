/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.posta;

import java.util.Properties;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import org.foi.nwtis.msimicic.aplikacija.Funkcije;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;
import org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote;

/**
 *
 * @author Martina
 */
public class MailServis extends Thread {
    Integer interval;
    ServletContext sc;
            
    @EJB
    PoslanePorukeFacadeRemote ppf;

    public MailServis() {
    }
    /**
     * 
     * @param sc - kontekst aplikacije
     */
    public MailServis(ServletContext sc) {
	super();
        this.sc = sc;
    }

    
    /**
     * Pokretanje dretve koja spava u odredenom intervalu
     * 
     */
    @Override
    public void run() {
	super.run();
	while (true) {
            try {
		getData();
                sendMail();
		sleep(interval * 1000);
            } catch (Exception e) {
		System.out.println(e);
		return;
            }
	}
    }

    /**
     * Dohvaćanje elektorničke pošte
     *
     */
    public void getData() {
        try {
            
             // <editor-fold defaultstate="collapsed" desc="connection to folder">
            Session session;
            Store store;
            Folder folder;
            
            String pop3 = sc.getInitParameter("pop3");
            String smtpHost = sc.getInitParameter("smtp");
            String user = sc.getInitParameter("mailUser");
            String pass = sc.getInitParameter("mailPass");
            interval = Integer.parseInt(sc.getInitParameter("interval"));
            
            java.util.Properties properties = System.getProperties();
            properties.put("mail.smtp.host", smtpHost);
            session = Session.getInstance(properties, null);
            store = session.getStore("pop3");
            store.connect(pop3, user, pass);
            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            // </editor-fold>  
            
            Integer broj = folder.getMessageCount();                              
            Message[] poruke = folder.getMessages();
            Flags f = new Flags();
            
            f.add(Flags.Flag.DELETED);
            folder.setFlags(poruke, f, true);

            System.out.println("Broj poruka je " + broj);
            if (poruke.length > 0) {
		for (int i = 0; i < poruke.length; i++) {
                    Message response = poruke[i].reply(false);
                    try {
			if (poruke[i].getSubject().equals("NWTiS") && poruke[i].isMimeType("text/plain")) {
			Address[] adrese = poruke[i].getFrom();
			String content = (String) poruke[i].getContent();

			String[] polje = content.split(";", 2);
                        
			System.out.println("Content: "+ content);
                        System.out.println("Prvi dio: "+ polje[0]+ ", drugi dio: "+ polje[1]);
                        
			//System.out.println("Naredba: "+ polje[0] + polje.length);
			//for(int j =0; j<polje.length; j++) {
                        //    System.out.println("polje"+j+": "+polje[j]);
                        //}
                        if (polje[0].substring(0,7).equals("newUser") ) {
                            System.out.println("Kreiram korisnika");
                            String d = "(,)";
                            String[] elem = content.split(d);
                            Funkcije.newUser(elem[0].substring(9), elem[1], elem[2], elem[3], adrese[i].toString());
                            response.setContent(Funkcije.newUser(elem[0], elem[1], elem[2], elem[3], adrese[i].toString()), "text/html");
                            //Naredba.pohrani
                              //      spremiMail(poruke[i], polje[1], "NWTiS-Arhiva", Integer.parseInt(polje[5]));
                    } 
		} else {
                    response.setContent("Naslov mora biti NWTiS i poruka u text/plain", "text/html");
                    //Naredba.spremiMail(poruke[i], null, "NWTiS-Arhiva", 0);
		}
                } catch (Exception e) {
                    response.setContent("Poruka je iskocila. Došlo je do nepredviđene pogreške."+ e, "text/html");
                    
                }
                //Transport.send(response);
            }
        }
        folder.close(true);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    
    public void sendMail() throws MessagingException {
        String user = sc.getInitParameter("mailUser");
        String smtpHost = sc.getInitParameter("smtp");
        
        String from = user + "@" + smtpHost;
        String to = from;
        String content = null;
        String subject = null;
                
        String login = "user('pero', '123456')";
        // OPTIONS:
        //0 -- "newUser('pero', 'Pero', 'Kos', '123456')"
        //1 -- "data()"
        //2 -- "data (10451, 7)"
        //3 -- "data ('2010-02-01 00:00:00',  '2010-02-01 08:00:00');"
        //4 -- "forecast (10451, 5)"
        //5 -- "stopforecast (10451)"
        
        // <editor-fold defaultstate="collapsed" desc="generiranje sadrzaja i naslova">
        Random randomGenerator = new Random();
        int code;
        
        for (int i=0; i<5; i++){
            int randomInt = randomGenerator.nextInt(7);
            switch (randomInt) {
                case 0:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(50000);
                    content = "newUser('"+code+"', 'Pero" + code +"', 'Kos" + code +"', '" + code +"');";
                    break;
                case 1:
                    subject = "NWTiS";
                    content = login + ";data()";
                    break;
                case 2:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +";data('"+ code +"', 7)";
                    break;
                case 3:
                    subject = "NWTiS";
                    content = login +";data('2010-02-01 00:00:00',  '2010-02-01 08:00:00');";
                    break;
                case 4:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +";forecast('"+ code +"', 5);";
                    break;
                case 5:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +";stopforecast('"+ code +"');";
                    break;
                case 6:
                    subject = "Fake email";
                    content = "Fake email content...";
                    break;
            }
        // </editor-fold>
            
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", smtpHost);
        Session session = Session.getDefaultInstance(properties);
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(content);
        Transport.send(message);
        System.out.println("Message Send SuccessFully..." + content);
                  
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        
        try {
            PoslanePoruke pp = new PoslanePoruke();
            pp.setPosiljatelj(from);
            pp.setDatum(sqlToday);
            pp.setNaslov(subject);
            pp.setSadrzaj(content);
            ppf.create(pp);
            System.out.println("Spremljena poruka");
            //Funkcije.pohraniPoslanuPoruku(from, sqlToday, subject, content);
        }
        catch (Exception e) {
            System.out.println("zajeb" + e);
        }
    }
}
}