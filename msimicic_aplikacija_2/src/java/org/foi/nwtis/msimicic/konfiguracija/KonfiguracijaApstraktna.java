/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.konfiguracija;

import java.util.Properties;

/**
 *
 * @author Martina
 */
public abstract class KonfiguracijaApstraktna implements Konfiguracija {
    protected Properties postavke = new Properties();

    public String dajPostavku(String postavka) {
        return this.postavke.getProperty(postavka);
    }

    public boolean spremiPostavku(String postavka, String vrijednost) {
        if(this.postavke.contains(postavka)) {
            return false;
        } else {
            this.postavke.setProperty(postavka, vrijednost);
            return true;
        }
    }

    public boolean azuzirajPostavku(String postavka, String vrijednost) {
        if(! this.postavke.contains(postavka)) {
            return false;
        } else {
            this.postavke.setProperty(postavka, vrijednost);
            return true;
        }
    }

    public boolean postojiPostavka(String postavka) {
        return this.postavke.contains(postavka);
    }

    public static Konfiguracija Konfiguracija(String datoteka) {
        Konfiguracija konfig = new KonfiguracijaXML();

        return konfig;
    }
}
