/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.Mycities;

/**
 *
 * @author Martina
 */
@Remote
public interface MycitiesFacadeRemote {

    void create(Mycities mycities);

    void edit(Mycities mycities);

    void remove(Mycities mycities);

    Mycities find(Object id);

    List<Mycities> findAll();

    List<Mycities> findRange(int[] range);

    int count();

}
