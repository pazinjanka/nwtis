/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.Putovanja;

/**
 *
 * @author Martina
 */
@Local
public interface PutovanjaFacadeLocal {

    void create(Putovanja putovanja);

    void edit(Putovanja putovanja);

    void remove(Putovanja putovanja);

    Putovanja find(Object id);

    List<Putovanja> findAll();

    List<Putovanja> findRange(int[] range);

    int count();

    public List<Putovanja> dohvatiGradoveZaKorisnika(String korisnik);

}
