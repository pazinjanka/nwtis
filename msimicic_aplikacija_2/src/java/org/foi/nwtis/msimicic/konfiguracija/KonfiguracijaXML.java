/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martina
 */
public class KonfiguracijaXML extends KonfiguracijaApstraktna{
    public Properties ucitajKonfiguraciju(String datoteka) {
        try {
            this.postavke.loadFromXML(new FileInputStream(datoteka));
        } catch (IOException ex) {
            Logger.getLogger(KonfiguracijaXML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return this.postavke;
        }
    }

    public boolean spremiKonfiguraciju(String datoteka) {
        try {
            this.postavke.storeToXML(new FileOutputStream(datoteka), "konfiguracija");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(KonfiguracijaXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean spremiKonfiguraciju(String datoteka, Properties konfig) {
        try {
            konfig.storeToXML(new FileOutputStream(datoteka), "konfiguracija");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(KonfiguracijaXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
