/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.Dnevnik;

/**
 *
 * @author Martina
 */
@Stateless
public class DnevnikFacade extends AbstractFacade<Dnevnik> implements DnevnikFacadeLocal, DnevnikFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DnevnikFacade() {
        super(Dnevnik.class);
    }

}
