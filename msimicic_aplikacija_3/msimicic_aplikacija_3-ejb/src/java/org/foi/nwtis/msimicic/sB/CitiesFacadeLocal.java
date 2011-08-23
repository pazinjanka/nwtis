/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.Cities;

/**
 *
 * @author Martina
 */
@Local
public interface CitiesFacadeLocal {

    void create(Cities cities);

    void edit(Cities cities);

    void remove(Cities cities);

    Cities find(Object id);

    List<Cities> findAll();

    List<Cities> findRange(int[] range);

    int count();

}
