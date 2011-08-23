/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;

/**
 *
 * @author Martina
 */
@Stateless
public class PoslanePorukeFacade extends AbstractFacade<PoslanePoruke> implements PoslanePorukeFacadeLocal, PoslanePorukeFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PoslanePorukeFacade() {
        super(PoslanePoruke.class);
    }

}
