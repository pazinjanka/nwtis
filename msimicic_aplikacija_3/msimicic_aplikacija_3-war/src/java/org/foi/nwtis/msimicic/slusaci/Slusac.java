/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.slusaci;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.foi.nwtis.msimicic.eB.Korisnici;

/**
 * Web application lifecycle listener.
 * @author Martina
 */
public class Slusac implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext context = null;
    private List<Korisnici> aktivniKorisnici = new ArrayList<Korisnici>();

    public List<Korisnici> getAktivniKorisnici() {
        return aktivniKorisnici;
    }

    public void setAktivniKorisnici(List<Korisnici> aktivniKorisnici) {
        this.aktivniKorisnici = aktivniKorisnici;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Kreiraj sesiju: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Uništi sesija: " + se.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
         if (event.getName().compareTo("korisnik") == 0) {

            aktivniKorisnici.add((Korisnici) event.getValue());
            context = event.getSession().getServletContext();
            context.setAttribute("aktivniKorisnici", aktivniKorisnici);

            System.out.println(event.getValue());

            for (int i = 0; i < aktivniKorisnici.size(); i++) {
            }
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().compareTo("korisnik") == 0) {
            aktivniKorisnici.remove((Korisnici) event.getValue());
            context.setAttribute("aktivniKorisnici", aktivniKorisnici);
            System.out.println("Sesija: " + event.getSession().getId() + ", obrisani atribut: " + event.getName());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
