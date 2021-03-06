/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;

/**
 *
 * @author Martina
 */
@Stateless
public class ObradjenePorukeFacade extends AbstractFacade<ObradjenePoruke> implements ObradjenePorukeFacadeLocal, ObradjenePorukeFacadeRemote {
    @PersistenceContext(unitName = "msimicic_aplikacija_3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ObradjenePorukeFacade() {
        super(ObradjenePoruke.class);
    }

}
