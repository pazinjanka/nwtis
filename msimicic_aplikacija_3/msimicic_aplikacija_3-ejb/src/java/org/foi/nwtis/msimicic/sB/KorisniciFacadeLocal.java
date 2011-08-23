/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Local;
import org.foi.nwtis.msimicic.eB.Korisnici;

/**
 *
 * @author Martina
 */
@Local
public interface KorisniciFacadeLocal {

    void create(Korisnici korisnici);

    void edit(Korisnici korisnici);

    void remove(Korisnici korisnici);

    Korisnici find(Object id);

    List<Korisnici> findAll();

    List<Korisnici> findRange(int[] range);

    int count();

}
