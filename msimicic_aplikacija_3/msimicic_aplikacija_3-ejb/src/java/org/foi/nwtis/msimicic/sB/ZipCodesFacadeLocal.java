/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.ZipCodes;

/**
 *
 * @author Martina
 */
@Local
public interface ZipCodesFacadeLocal {

    void create(ZipCodes zipCodes);

    void edit(ZipCodes zipCodes);

    void remove(ZipCodes zipCodes);

    ZipCodes find(Object id);

    List<ZipCodes> findAll();

    List<ZipCodes> findRange(int[] range);

    int count();

}
