/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;

/**
 *
 * @author Martina
 */
@Remote
public interface ObradjenePorukeFacadeRemote {

    void create(ObradjenePoruke obradjenePoruke);

    void edit(ObradjenePoruke obradjenePoruke);

    void remove(ObradjenePoruke obradjenePoruke);

    ObradjenePoruke find(Object id);

    List<ObradjenePoruke> findAll();

    List<ObradjenePoruke> findRange(int[] range);

    int count();

}
