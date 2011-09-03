/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author Martina
 */
public class Meteo extends HttpServlet {
    @Override
    public void init(){
	MeteoServis dretva = new MeteoServis();
	dretva.start();
    }
}
