/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.posta;

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
    Pattern pattern = Pattern.compile("'(\\w*\\d*)'|([a-zA-Z]{1,})");
    Pattern datumPattern = Pattern.compile("'(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})'");
    String prijavljen;
    
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
                sendMail();
                getData();
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

            int nwtis = 0;
            int krive = 0;
            
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
            java.util.Date today1 = new java.util.Date();
            java.sql.Date datum1 = new java.sql.Date(today1.getTime());
            folder.open(Folder.READ_WRITE);
            // </editor-fold>  
            
            Integer procitane = folder.getMessageCount();
            Message[] poruke = folder.getMessages();
            Flags f = new Flags();
            
            f.add(Flags.Flag.DELETED);
            folder.setFlags(poruke, f, true);

            System.out.println("Broj poruka je " + procitane);
            if (poruke.length > 0) {
		for (int i = 0; i < poruke.length; i++) {
                    System.out.println("Poruka broj: " + i);
                    Message response = poruke[i].reply(false);
                    response.setHeader("Content-Type", "text/plain; charset=\"utf-8\"");
                    try {
			if (poruke[i].getSubject().equals("NWTiS") && poruke[i].isMimeType("text/plain")) {
			Address[] adrese = poruke[i].getFrom();
			String content = (String) poruke[i].getContent();
			String[] polje = content.split(";", 2);
                        
                        Matcher matcher = pattern.matcher(polje[0]);
                        //System.out.println("Prvi dio: "+polje[0]);
                        while(matcher.find()){
                            // <editor-fold defaultstate="collapsed" desc="sko je user prva naredba">
                            if (matcher.group(2).equals("user"))
                            {
                                // <editor-fold defaultstate="collapsed" desc="prijava korisnika">
                                int a = 0;
                                while (matcher.find()){
                                    String str = matcher.group(1);
                                    parametri[a] = str;
                                    a++;
                                    //System.out.println(matcher.group(1));
                                }
                                parametri[a] = adrese[0].toString();
                                if (funkcije.user(parametri)) {
                                    prijavljen = parametri[0];
                                }
                                parametri[0] = null;
                                parametri[1] = null;
                                parametri[2] = null;
                                // </editor-fold>

                                Matcher matcher2 = pattern.matcher(polje[1]);
                                //System.out.println("Drugi dio: "+polje[1]);
                                while(matcher2.find()){
                                   if (matcher2.group(2).equals("data")){
                                       int b = 0;
                                       while (matcher2.find()){
                                            parametri[b] = matcher2.group(1).toString();
                                            b++;
                                       }
                                            Matcher matcher3 = datumPattern.matcher(polje[1]);
                                            int c = 0;
                                            while (matcher3.find()){
                                                datumi[c] = matcher3.group(1).toString();
                                                c++;
                                            }
                                       // <editor-fold defaultstate="collapsed" desc="data();">
                                       if (parametri[0] == null && parametri[1] == null && datumi[0] == null && datumi[1] == null) {
                                           parametri[0] = prijavljen;
                                           response.setContent(funkcije.data(parametri), "text/plain; charset=\"utf-8\"");
                                           funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "2" , '1');
                                           prijavljen = null;
                                           parametri[0] = null;
                                       } 
                                            // </editor-fold>
                                       // <editor-fold defaultstate="collapsed" desc="data(datum, datum);">

                                       else if(datumi[0] != null && datumi[1] != null) {
                                                parametri[0] = prijavljen;
                                                funkcije.dataSaDatumima(datumi, parametri);
                                                response.setContent("Vaš zahtjev za slanjem podataka je uspješno spremljen. Podaci će biti slani od "+datumi[0]+" do "+datumi[1]+". ", "text/plain; charset=\"utf-8\"");
                                                //System.out.println("Sa datumima");
                                                funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "4" , '1');
                                                prijavljen = null;
                                                parametri[0] = null;
                                                datumi[0] = null;
                                                datumi[0] = null;
                                            }
                                       // </editor-fold>
                                       // <editor-fold defaultstate="collapsed" desc="data(kod, dana);">
                                       else if(parametri[0] != null && parametri[1] != null) {
                                            parametri[2] = prijavljen;
                                            response.setContent(funkcije.dataParametri(parametri), "text/plain; charset=\"utf-8\"");
                                            //System.out.println("date()");
                                            funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "3" , '1');
                                            prijavljen = null;
                                            parametri[0] = null;
                                            parametri[1] = null;
                                            parametri[2] = null;
                                       }
                                       // </editor-fold>
                                    }
                                   // <editor-fold defaultstate="collapsed" desc="forecast();">
                                    else if (matcher2.group(2).equals("forecast")) {
                                        int c = 0;
                                       while (matcher2.find()){
                                            parametri[c] = matcher2.group(1).toString();
                                            c++;
                                       }
                                        parametri[2] = prijavljen;
                                        System.out.println("forecast");
                                        if (funkcije.forecast(parametri)){
                                            response.setContent("Pretplata je aktivirana!", "text/plain; charset=\"utf-8\"");
                                        }
                                        funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "5" , '1');
                                        prijavljen = null;
                                        parametri[0] = null;
                                        parametri[1] = null;
                                    }
                                   // </editor-fold>
                                   // <editor-fold defaultstate="collapsed" desc="stopForecast();">
                                     else if (matcher2.group(2).equals("stopforecast")) {
                                        int c = 0;
                                        while (matcher2.find()){
                                            parametri[c] = matcher2.group(1).toString();
                                            c++;
                                        }
                                        parametri[1] = prijavljen;
                                        response.setContent(funkcije.stopForecast(parametri), "text/plain; charset=\"utf-8\"");
                                        funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "6" , '1');
                                        System.out.println("stopFprecast");
                                        prijavljen = null;
                                        parametri[0] = null;
                                     }
                                   // </editor-fold>
                                }
                            }
                             // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="sko je newUser prva naredba">
                            // <editor-fold defaultstate="collapsed" desc="newUser();">
                            else if (matcher.group(2).equals("newUser")){
                                int a = 0;
                                while (matcher.find()){
                                  parametri[a] = matcher.group(1);
                                  //System.out.println(matcher.group(1));
                                  a++;
                                }
                                funkcije.newUser(parametri[0], parametri[1], parametri[2], parametri[3], adrese[0].toString());
                                response.setContent("Zahtjev zaprimljen i izvršen. Korisnik "+parametri[1]+" "+parametri[2]+" sa korisničkim imenom "+parametri[1]+" uspješno kreiran! ", "text/plain; charset=\"utf-8\"");
                                funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(), poruke[i].getFrom()[0].toString(), poruke[i].getSubject(), poruke[i].getContent().toString(), "0" , '1');
                                parametri[0] = null;
                                parametri[1] = null;
                                parametri[2] = null;
                                parametri[3] = null;
                            }
                            // </editor-fold>
                            // </editor-fold>
                        }
                        nwtis++;
		} else if (!poruke[i].getSubject().substring(0, 3).equals("Re:")) {
                    response.setContent("Naslov mora biti NWTiS i poruka u text/plain", "text/plain; charset=\"utf-8\"");
                    funkcije.pohraniObradjenuPoruku(poruke[i].getRecipients(Message.RecipientType.TO)[0].toString(),
                            poruke[i].getFrom()[0].toString(),
                            poruke[i].getSubject(),
                            poruke[i].getContent().toString(),
                            "-1" , '0');
                    krive++;
                    }
                } catch (Exception e) {
                    response.setContent("A tko će ga znat..."+ e, "text/html");
                }
                Transport.send(response);
            }
        }
        folder.close(true);
        java.util.Date today2 = new java.util.Date();
        java.sql.Date datum2 = new java.sql.Date(today2.getTime());
        Integer ispravne = procitane - krive;
        funkcije.dnevnik(datum1, datum2, procitane, nwtis, ispravne);
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
                    code = randomGenerator.nextInt(100000);
                    content = "newUser('"+code+"', 'Pero" + code +"', 'Kos" + code +"', '" + code +"');";
                    break;
                case 1:
                    subject = "NWTiS";
                    content = login + ";data()";
                    break;
                case 2:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 1000;
                    content = login +";data('60876', '7')";
                    break;
                case 3:
                    subject = "NWTiS";
                    content = login +";data('2010-02-01 00:00:00',  '2010-02-01 08:00:00');";
                    break;
                case 4:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 1000;
                    content = login +";forecast('60876', '5');";
                    break;
                case 5:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 1000;
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