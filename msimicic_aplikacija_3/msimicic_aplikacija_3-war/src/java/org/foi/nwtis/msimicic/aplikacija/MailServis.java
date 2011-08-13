/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.servlet.ServletContext;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Martina
 */
public class MailServis extends Thread {
    Integer interval;
    ServletContext sc;
    String pop3;
    String smtpHost;
    String user;
    String pass;

    
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
     * Interval definiran u konfiguracija.xml
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
            Session session;
            Store store;
            Folder folder;
            
            pop3 = sc.getInitParameter("pop3");
            smtpHost = sc.getInitParameter("smtp");
            user = sc.getInitParameter("mailUser");
            pass = sc.getInitParameter("mailPass");
            interval = Integer.parseInt(sc.getInitParameter("interval"));
                        
            java.util.Properties properties = System.getProperties();
            properties.put("mail.smtp.host", smtpHost);
            session = Session.getInstance(properties, null);
            store = session.getStore("pop3");
            store.connect(pop3, user, pass);
            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
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
			String delims = "[ ()',;]+";
			String[] polje = content.split(delims);
			System.out.println("Content: "+content);
			System.out.println("Naredba: "+polje[0] + polje.length);
			for(int j =0; j<polje.length; j++) {
			System.out.println("polje"+j+": "+polje[j]);
                    }
                    if (polje[0].equals("createUser") && polje.length == 7) {
			System.out.println("Kreiram korisnika");
			response.setContent(Naredba.newUser(polje[1], adrese[0].toString(), polje[2], polje[3], polje[4]), "text/html");
			//Naredba.spremiMail(poruke[i], polje[1], "NWTiS-Arhiva", Integer.parseInt(polje[5]));
                    } 
		} else {
                    response.setContent("Naslov mora biti NWTiS i poruka u text/plain", "text/html");
                    //Naredba.spremiMail(poruke[i], null, "NWTiS-Arhiva", 0);
		}
                } catch (Exception e) {
                    response.setContent("Poruka je iskocila. Došlo je do nepredviđene pogreške.", "text/html");
                    //Naredba.spremiMail(poruke[i], null, "NWTiS-Arhiva", 0);
                }
                Transport.send(response);
            }
        }
        folder.close(true);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    
    public void sendMail() throws MessagingException, SQLException {
        String from = user + "@" + smtpHost;
        String to = from;
        String content = null;
        String subject = null;
                
        String login = "user('pero', '123456');";
        // OPTIONS:
        //0 -- "newUser('pero', 'Pero', 'Kos', '123456')"
        //1 -- "data()"
        //2 -- "data (10451, 7)"
        //3 -- "data ('2010-02-01 00:00:00',  '2010-02-01 08:00:00');"
        //4 -- "forecast (10451, 5)"
        //5 -- "stopforecast (10451)"
        
        Random randomGenerator = new Random();
        int code;
        for (int i=0; i<5; i++){
            int randomInt = randomGenerator.nextInt(6);
            switch (randomInt) {
                case 0:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(50000);
                    content = "newUser('"+code+"', 'Pero" + code +"', 'Kos" + code +"', '" + code +"');";
                    break;
                case 1:
                    subject = "NWTiS";
                    content = login + "|data();";
                    break;
                case 2:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +"|data('"+ code +"', 7);";
                    break;
                case 3:
                    subject = "NWTiS";
                    content = login +"|data('2010-02-01 00:00:00',  '2010-02-01 08:00:00');";
                    break;
                case 4:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +"|forecast('"+ code +"', 5);";
                    break;
                case 5:
                    subject = "NWTiS";
                    code = randomGenerator.nextInt(90000) + 10000;
                    content = login +"|stopforecast('"+ code +"');";
                    break;
                case 6:
                    subject = "Fake email";
                    content = "Fake email content...";
                    break;
            }
        
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
        }
        /*
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root"; 
        String userPassword = "root";
        String strQuery = null;

        try {
              Class.forName(driver).newInstance();
              conn = DriverManager.getConnection(url+dbName,username,userPassword);
              Statement st = conn.createStatement();
              strQuery = "insert into message set message='"+content+"'"; 
              int rs = st.executeUpdate(strQuery);
              System.out.println("Query Executed Successfully...");  
        } catch (Exception e) {
              System.out.println(e.getMessage());
              } finally {
              conn.close();
              }  
        }
*/
    }
}