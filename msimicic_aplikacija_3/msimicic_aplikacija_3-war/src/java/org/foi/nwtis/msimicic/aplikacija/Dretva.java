/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author Martina
 */
public class Dretva extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
	System.out.println("Dretva pokrenuta");
	AutoDretva dretva = new AutoDretva();
	dretva.start();
    }
}
