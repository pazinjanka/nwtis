/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.Mycities;

/**
 *
 * @author Martina
 */
@Stateless
public class MycitiesFacade extends AbstractFacade<Mycities> implements MycitiesFacadeLocal, MycitiesFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MycitiesFacade() {
        super(Mycities.class);
    }

}
