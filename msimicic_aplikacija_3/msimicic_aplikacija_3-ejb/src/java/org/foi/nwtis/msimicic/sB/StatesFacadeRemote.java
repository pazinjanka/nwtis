/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.States;

/**
 *
 * @author Martina
 */
@Remote
public interface StatesFacadeRemote {

    void create(States states);

    void edit(States states);

    void remove(States states);

    States find(Object id);

    List<States> findAll();

    List<States> findRange(int[] range);

    int count();

}
