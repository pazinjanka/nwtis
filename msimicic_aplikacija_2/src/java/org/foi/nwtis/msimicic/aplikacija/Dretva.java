/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.servlet.http.HttpServlet;


/**
 *
 * @author Martina
 */
public class Dretva extends HttpServlet {        
    @Override
    public void init(){
	AutoDretva dretva = new AutoDretva();
	dretva.start();
    }
}
