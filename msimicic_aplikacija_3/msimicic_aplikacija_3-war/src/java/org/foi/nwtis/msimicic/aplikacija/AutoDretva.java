/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.mail.*;
import org.foi.nwtis.msimicic.db.konfiguracija.DBkonfiguracija;

/**
 *
 * @author Martina
 */
public class AutoDretva extends Thread {
    Integer interval;

    /**
     * 
     * @param sc - kontekst aplikacije
     */
    public AutoDretva() {
	super();
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
            String naziv = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_3\\konfiguracija.xml";
            DBkonfiguracija konf = new DBkonfiguracija(naziv);
            interval = Integer.parseInt(konf.getInterval());
            
            String pop3 = konf.getPop3();
            String smtpHost = konf.getSmtp();
            String user = konf.getUser_username();
            String pass = konf.getUser_password();
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
}
