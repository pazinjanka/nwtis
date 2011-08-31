/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.aplikacija;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;
import org.foi.nwtis.msimicic.sB.KorisniciFacadeRemote;
import org.foi.nwtis.msimicic.sB.ObradjenePorukeFacadeRemote;
import org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Martina
 */
@Stateless
@LocalBean
public class Funkcije implements Serializable {

    KorisniciFacadeRemote kfr = getKorisniciFacadeRemote();
    PoslanePorukeFacadeRemote ppfr = getPoslanePorukeFacadeRemote();
    ObradjenePorukeFacadeRemote opfr = getObradjenePorukeFacadeRemote();

    public Funkcije() {
    }

    public String newUser(String kor_ime, String ime, String prezime, String lozinka, String email) {
        try {
            Korisnici korisnik = new Korisnici(kor_ime, ime, prezime, lozinka, email, 1);
            kfr.create(korisnik);
        }
        catch (Exception e) {
            System.out.println("Korisnik nije kreiran!"+e);
            return "Korisnik nije kreiran, došlo je do pogreške";
        }
        return "Korisnik uspješno keriran.";
    }

        public void user(String [] parametri) {
            List<Korisnici> prijava = kfr.prijavaKorisnika(parametri[0], parametri[1], "pero@foi.hr");
            if (prijava.size() != 1) {
                //sendMail(messages[i].getFrom()[0].toString(), from, "NWTiS greska", "Neuspjesna prijava", session);
                                    //messages[i].setFlag(Flag.DELETED, true);
                                    //folder.close(true);
            }
            else {
                System.out.println("Korisnik prijavljen");
            }
    }

    public void pohraniObradjenuPoruku(String primatelj, String posiljatelj, String naslov, String sadrzaj, String vrsta, java.lang.Character ispravna){
        try {
            ObradjenePoruke op = new ObradjenePoruke();
            op.setPrimatelj(primatelj);
            op.setPosiljatelj(posiljatelj);
            java.util.Date today = new java.util.Date();
            java.sql.Date datum = new java.sql.Date(today.getTime());
            op.setDatum(datum);
            op.setNaslov(naslov);
            op.setSadrzaj(sadrzaj);
            op.setVrsta(vrsta);
            op.setIspravna(ispravna);
            opfr.create(op);
            System.out.println("Nije valjda??");
        }
        catch (Exception e) {
            System.out.println("Pisi kuci propalo: "+ e);
        }
    }

    public void pohraniPoslanuPoruku(String posiljatelj, Date date, String naslov, String sadrzaj) {
        try {
            PoslanePoruke pp = new PoslanePoruke();
            pp.setPosiljatelj(posiljatelj);
            pp.setDatum(date);
            pp.setNaslov(naslov);
            pp.setSadrzaj(sadrzaj);
            ppfr.create(pp);
            System.out.println("Spremljena poruka");
        }
        catch (Exception e){
            System.out.println("Poslana poruka nije pohranjena" + e);
        }
    }

    public void data() {

    }

    //instanciranje Facada Remote
    // <editor-fold defaultstate="collapsed" desc="instanciranje Facada Remote">
    private PoslanePorukeFacadeRemote getPoslanePorukeFacadeRemote() {
    /*
    org.foi.nwtis.msimicic.eB.PoslanePoruke actually got transformed
    (Portable)
    java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote,
    java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeLocal
    (Non-portable)
    org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote#org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote
    org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote
    */
        try {
            Context c = new InitialContext();
            return (PoslanePorukeFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod PoslanePorukeFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private KorisniciFacadeRemote getKorisniciFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (KorisniciFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/KorisniciFacade!org.foi.nwtis.msimicic.sB.KorisniciFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod KorisniciFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private ObradjenePorukeFacadeRemote getObradjenePorukeFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (ObradjenePorukeFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/ObradjenePorukeFacade!org.foi.nwtis.msimicic.sB.ObradjenePorukeFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod ObradjenePorukeFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }
    
    // </editor-fold>
}
