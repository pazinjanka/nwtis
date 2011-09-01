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
import org.foi.nwtis.msimicic.eB.Putovanja;

/**
 *
 * @author Martina
 */
@Stateless
public class PutovanjaFacade extends AbstractFacade<Putovanja> implements PutovanjaFacadeLocal, PutovanjaFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PutovanjaFacade() {
        super(Putovanja.class);
    }

    @Override
    public List<Putovanja> dohvatiGradoveZaKorisnika(String korisnik) {
        Korisnici k = (Korisnici) em.createQuery("SELECT k FROM Korisnici k WHERE k.korIme = :KOR_IME").setParameter("KOR_IME", korisnik).getSingleResult();
        return em.createQuery( "SELECT p FROM  Putovanja p WHERE p.korisnici = :KORISNIK" )
        .setParameter("KORISNIK", k)
        .getResultList();
    }

}
