/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;

/**
 *
 * @author Martina
 */
@Local
public interface ObradjenePorukeFacadeLocal {

    void create(ObradjenePoruke obradjenePoruke);

    void edit(ObradjenePoruke obradjenePoruke);

    void remove(ObradjenePoruke obradjenePoruke);

    ObradjenePoruke find(Object id);

    List<ObradjenePoruke> findAll();

    List<ObradjenePoruke> findRange(int[] range);

    int count();

}
