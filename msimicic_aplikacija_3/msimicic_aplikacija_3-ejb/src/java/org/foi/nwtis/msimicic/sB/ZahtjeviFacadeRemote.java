/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.sB;

import java.util.List;
import javax.ejb.Remote;
import org.foi.nwtis.msimicic.eB.Zahtjevi;

/**
 *
 * @author Martina
 */
@Remote
public interface ZahtjeviFacadeRemote {

    void create(Zahtjevi zahtjevi);

    void edit(Zahtjevi zahtjevi);

    void remove(Zahtjevi zahtjevi);

    Zahtjevi find(Object id);

    List<Zahtjevi> findAll();

    List<Zahtjevi> findRange(int[] range);

    int count();

    public Zahtjevi findByCityCodeAndUser(Integer cityCode, String korisnik);
}
