/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.posta;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.mb.Login;
import org.foi.nwtis.msimicic.sB.KorisniciFacade;

/**
 *
 * @author Martina
 */
public class MailServis extends Thread {
    Integer interval;
    ServletContext sc;
    Funkcije funkcije = new Funkcije();
    String [] parametri = new String[5];
    String [] datumi = new String[5];
    Pattern pattern = Pattern.compile("'(\\w*\\d*)'|([a-zA-Z]{1,})|'(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})'");    
    
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
                        
                        Matcher matcher = pattern.matcher(polje[0]);
                        System.out.println("Prvi dio: "+polje[0]);
                        while(matcher.find()){
                            if (matcher.group(2).equals("user"))
                            {
                                // <editor-fold defaultstate="collapsed" desc="prijava korisnika">
                                int a = 0;
                                while (matcher.find()){
                                    String str = matcher.group(1);
                                    parametri[a] = str;
                                    a++;
                                    System.out.println(matcher.group(1));
                                }
                                parametri[a] = adrese[0].toString();
                                funkcije.user(parametri);
                                // </editor-fold>

                                Matcher matcher2 = pattern.matcher(polje[1]);
                                System.out.println("Drugi dio: "+polje[1]);

                                while(matcher2.find()){
                                   if (matcher2.group(2).equals("data")){
                                       int b = 1;
                                       while (matcher2.find()){
                                       parametri[b] = matcher2.group(1).toString();
                                       datumi[b] = matcher2.group(3).toString();
                                       //System.out.println(matcher.group(1));
                                       b++;
                                       }
                                        if (parametri.length>0) {
                                            switch (parametri.length) {
                                                case 0:
                                                    funkcije.data();
                                                    System.out.println("date()");
                                                    break;
                                                case 2:
                                                    System.out.println("date(2)");
                                                    break;
                                            }
                                        }
                                        else if (datumi.length>0) {
                                            System.out.println("datumi");
                                        }
                                    }
                                    else if (matcher2.group(2).equals("forecast")) {
                                        System.out.println("forecast");
                                    }
                                     else if (matcher2.group(2).equals("stopforecast")) {
                                        System.out.println("stopF");
                                     }
                                }
                            }
                            else if (matcher.group(2).equals("newUser")){
                                int a = 0;
                                while (matcher.find()){
                                  parametri[a] = matcher.group(1);
                                  //System.out.println(matcher.group(1));
                                  a++;
                                }
                                funkcije.newUser(parametri[0], parametri[1], parametri[2], parametri[3], adrese[i].toString());
                                response.setContent("Zahtjev zaprimljen i izvršen. Korisnik "+parametri[1]+" "+parametri[2]+" sa korisničkim imenom "+parametri[1]+" uspješno kreiran! ", "text/html");
                                if (poruke[i].getSubject().equals("NWTiS"))
                                    funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "0" , '1');
                                else
                                    funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "-1" , '0');
                            }
                        }
                        }
                        /*
                        if (items[0].equals("newUser(") ) {
                            System.out.println("Kreiram korisnika");
                            Pattern p = Pattern.compile("''");
                            String[] items = p.split(polje[0]);
                            String d = "(,);";
                            System.out.println("0" + items[0]);
                            System.out.println("1" + items[1]);
                            System.out.println("2" + items[2]);
                            System.out.println("3" + items[3]);
                            System.out.println("4" + items[4]);
                            //String[] elem = content.split(d);
                            //funkcije.newUser(elem[0].substring(9), elem[1], elem[2], elem[3], adrese[i].toString());
                            //response.setContent("Zahtjev zaprimljen i izvršen. Korisnik "+elem[1]+" "+elem[2]+" sa korisničkim imenom "+elem[0].substring(9)+" uspješno kreiran! ", "text/html");
                            //if (poruke[i].getSubject().equals("NWTiS"))
                            //    funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO).toString(), poruke[i].getFrom().toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "0" , '1');
                            //else
                            //    funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO).toString(), poruke[i].getFrom().toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "-1" , '0');
                        }
                        if (polje[0].substring(0,4).equals("user") ) {
                            System.out.println("Kreiram korisnika");
                            String d = "(,;)";
                            String[] elem = content.split(d);
                            System.out.println("0" + elem[0]);
                            System.out.println("1" + elem[1]);
                            System.out.println("2" + elem[2]);
                            System.out.println("3" + elem[3]);
                            System.out.println("4" + elem[4]);
                        }
                    /*
		} else {
                    response.setContent("Naslov mora biti NWTiS i poruka u text/plain", "text/html");
                    funkcije.pohraniObradjenuPoruku(java.util.Arrays.toString(poruke[i].getRecipients(Message.RecipientType.TO)),
                            java.util.Arrays.toString(poruke[i].getFrom()),
                            poruke[i].getSubject(),
                            poruke[i].getContent().toString(),
                            "-1" , '1');
		}*/
                } catch (Exception e) {
                    response.setContent("A tko će ga znat..."+ e, "text/html");
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
                    content = login +";data('"+ code +"', '7')";
                    break;
                case 3:
                    subject = "NWTiS";
                    content = login +";data('2010-02-01 00:00:00',  '2010-02-01 08:00:00');";
                    break;
                case 4:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +";forecast('"+ code +"', '5');";
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
            funkcije.pohraniPoslanuPoruku(from, sqlToday, subject, content);
        }
        catch (Exception e) {
            System.out.println("zajeb" + e);
        }
    }
}
}