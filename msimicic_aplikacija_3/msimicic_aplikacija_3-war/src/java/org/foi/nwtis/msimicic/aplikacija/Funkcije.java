/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.aplikacija;

import java.sql.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;
import org.foi.nwtis.msimicic.sB.KorisniciFacadeRemote;
import org.foi.nwtis.msimicic.sB.ObradjenePorukeFacadeRemote;
import org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote;

/**
 *
 * @author Martina
 */
public class Funkcije {
    @EJB
    static PoslanePorukeFacadeRemote ppf;
    static ObradjenePorukeFacadeRemote opf;
    static KorisniciFacadeRemote kf;

    public static String newUser(String kor_ime, String ime, String prezime, String lozinka, String email) {
        try {
            Korisnici korisnik = new Korisnici(kor_ime, ime, prezime, lozinka, email, 1);
            kf.create(korisnik);
        }
        catch (Exception e) {
            System.out.println("Krorisnik nije kreiran!"+e);
            return "Korisnik nije kreiran, došlo je do pogreške";
        }
        return "Korisnik uspješno keriran.";
    }

    public static void pohraniObradjenuPoruku(String primatelj, String posiljatelj, Date datum, String naslov, String sadrzaj, String vrsta, java.lang.Character ispravna){
        try {
            ObradjenePoruke op = new ObradjenePoruke();
            op.setPrimatelj(primatelj);
            op.setPosiljatelj(posiljatelj);
            op.setDatum(datum);
            op.setNaslov(naslov);
            op.setSadrzaj(sadrzaj);
            op.setVrsta(vrsta);
            op.setIspravna(ispravna);
            opf.create(op);
            System.out.println("Nije valjda??");
        }
        catch (Exception e) {
            System.out.println("Pisi kuci propalo: "+ e);
        }
    }

    public static void pohraniPoslanuPoruku(String posiljatelj, Date date, String naslov, String sadrzaj) {
        try {
            PoslanePoruke pp = new PoslanePoruke();
            pp.setPosiljatelj(posiljatelj);
            pp.setDatum(date);
            pp.setNaslov(naslov);
            pp.setSadrzaj(sadrzaj);
            ppf.create(pp);
            System.out.println("Spremljena poruka");
        }
        catch (Exception e){
            System.out.println("Poslana poruka nije pohranjena" + e);
        }
    }
}
