/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.ejb.EJB;
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.sB.KorisniciFacade;
import org.foi.nwtis.msimicic.sB.ZahtjeviFacade;

/**
 *
 * @author Martina
 */
public class Naredba {
        @EJB
    private static KorisniciFacade korisniciFacade;
    

    public static String newUser(String kor_ime, String ime, String prezime, String lozinka, String email) {
        try {
            Korisnici korisnik = new Korisnici(kor_ime, ime, prezime, lozinka, email, 1);
            korisniciFacade.create(korisnik);
        }
        catch (Exception e) {
            return "Krorisnik nije kreiran!"+e;
        }
        return "Korisnik kreiran!";
    }
    
}
