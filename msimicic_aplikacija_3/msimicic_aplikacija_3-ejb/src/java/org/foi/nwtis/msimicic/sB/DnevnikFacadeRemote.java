/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.Dnevnik;

/**
 *
 * @author Martina
 */
@Remote
public interface DnevnikFacadeRemote {

    void create(Dnevnik dnevnik);

    void edit(Dnevnik dnevnik);

    void remove(Dnevnik dnevnik);

    Dnevnik find(Object id);

    List<Dnevnik> findAll();

    List<Dnevnik> findRange(int[] range);

    int count();

}
