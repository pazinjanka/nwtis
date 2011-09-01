/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.Putovanja;

/**
 *
 * @author Martina
 */
@Remote
public interface PutovanjaFacadeRemote {

    void create(Putovanja putovanja);

    void edit(Putovanja putovanja);

    void remove(Putovanja putovanja);

    Putovanja find(Object id);

    List<Putovanja> findAll();

    List<Putovanja> findRange(int[] range);

    int count();

    public List<Putovanja> dohvatiGradoveZaKorisnika(String korisnik);
}
