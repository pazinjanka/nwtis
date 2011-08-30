/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.Korisnici;

/**
 *
 * @author Martina
 */
@Stateless
public class KorisniciFacade extends AbstractFacade<Korisnici> implements KorisniciFacadeLocal, KorisniciFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KorisniciFacade() {
        super(Korisnici.class);
    }

    @Override
    public List<Korisnici> prijavaKorisnika(String korIme, String lozinka, String email) {
        return em.createQuery( "SELECT * FROM  Korisnici WHERE k.kor_ime = :KOR_IME and p.lozinka = :LOZINKA and p.email_adresa = :MAIL" )
        .setParameter("KOR_IME", korIme)
        .setParameter("LOZINKA", lozinka)
        .setParameter("EMAIL_ADRESA", email)
        .getResultList();
    }
}
