/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.Counties;

/**
 *
 * @author Martina
 */
@Remote
public interface CountiesFacadeRemote {

    void create(Counties counties);

    void edit(Counties counties);

    void remove(Counties counties);

    Counties find(Object id);

    List<Counties> findAll();

    List<Counties> findRange(int[] range);

    int count();

}
