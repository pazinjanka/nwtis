/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.sB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.Putovanje;

/**
 *
 * @author Martina
 */
@Stateless
public class PutovanjeFacade extends AbstractFacade<Putovanje> {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PutovanjeFacade() {
        super(Putovanje.class);
    }
    
}
