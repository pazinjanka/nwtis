/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;

/**
 *
 * @author Martina
 */
@Local
public interface PoslanePorukeFacadeLocal {

    void create(PoslanePoruke poslanePoruke);

    void edit(PoslanePoruke poslanePoruke);

    void remove(PoslanePoruke poslanePoruke);

    PoslanePoruke find(Object id);

    List<PoslanePoruke> findAll();

    List<PoslanePoruke> findRange(int[] range);

    int count();

}
