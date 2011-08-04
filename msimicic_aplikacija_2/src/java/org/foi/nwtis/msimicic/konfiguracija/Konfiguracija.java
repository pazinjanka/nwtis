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
public interface Konfiguracija {
    public Properties ucitajKonfiguraciju(String datoteka);
    public boolean spremiKonfiguraciju(String datoteka);
    public boolean spremiKonfiguraciju(String datoteka, Properties konfig);
    public String dajPostavku(String postavka);
    public boolean spremiPostavku(String postavka, String vrijednost);
    public boolean azuzirajPostavku(String postavka, String vrijednost);
    public boolean postojiPostavka(String postavka);
}
