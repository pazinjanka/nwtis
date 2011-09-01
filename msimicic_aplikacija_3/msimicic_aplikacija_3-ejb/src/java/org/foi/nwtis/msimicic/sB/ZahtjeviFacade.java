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
import org.foi.nwtis.msimicic.eB.Zahtjevi;

/**
 *
 * @author Martina
 */
@Stateless
public class ZahtjeviFacade extends AbstractFacade<Zahtjevi> implements ZahtjeviFacadeLocal, ZahtjeviFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZahtjeviFacade() {
        super(Zahtjevi.class);
    }

    @Override
    public Zahtjevi findByCityCodeAndUser(Integer cityCode, String korisnik){
        Korisnici k = (Korisnici) em.createQuery("SELECT k FROM Korisnici k WHERE k.korIme = :KOR_IME")
                .setParameter("KOR_IME", korisnik)
                .getSingleResult();
        int c = em.createQuery("SELECT count(z.zahtjevId) FROM Zahtjevi z WHERE z.korisnici = :KORISNIK and z.gradCode = :CITY_CODE")
                .setParameter("KORISNIK", k)
                .setParameter("CITY_CODE", cityCode)
                .getFirstResult();
        if (c == 0) return null;
        else {
            return (Zahtjevi) em.createQuery("SELECT z) FROM Zahtjevi z WHERE z.korisnici = :KORISNIK and z.gradCode = :CITY_CODE and z.naredba = :NAREDBA")
                .setParameter("KORISNIK", k)
                .setParameter("NAREDBA", "forecast")
                .setParameter("CITY_CODE", cityCode)
                .getSingleResult();
        }
    }

}
