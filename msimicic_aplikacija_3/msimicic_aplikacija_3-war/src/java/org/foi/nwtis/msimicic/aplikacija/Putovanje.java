/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.aplikacija;

import java.util.List;


/**
 *
 * @author Martina
 */
public class Putovanje {

    private List <Integer> gradovi;

    /** Creates a new instance of Putovanje */
    public Putovanje() {
    }

    public void setGradovi (List <Integer> gradovi){
        this.gradovi = gradovi;
    }

    public List <Integer> getGradovi () {
        return this.gradovi;
    }
}
