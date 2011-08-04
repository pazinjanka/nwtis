/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.konfiguracija;

import java.io.File;
/**
 *
 * @author Martina
 * Ucitava opis baze koja se koristi
 */
public class KonfiguracijaBaza {
    
    protected String naziv;
    protected boolean status;
    protected String server_database;
    protected String admin_username;
    protected String admin_password;
    protected String admin_database;
    protected String user_username;
    protected String user_password;
    protected String user_database;
    protected String driver_database;
    protected Integer interval;

    public KonfiguracijaBaza(String naziv) {
        this.naziv = naziv;

        File datoteka = new File(naziv);

        if (!datoteka.exists()) {
            this.status = false;
            return;
        } else {
            Konfiguracija konfig = KonfiguracijaApstraktna.Konfiguracija(naziv);

            konfig.ucitajKonfiguraciju(naziv);
            
            this.server_database = konfig.dajPostavku("server.database");
            this.admin_username = konfig.dajPostavku("admin.username");
            this.admin_password = konfig.dajPostavku("admin.password");
            this.admin_database = konfig.dajPostavku("admin.database");
            this.user_username = konfig.dajPostavku("user.username");
            this.user_password = konfig.dajPostavku("user.password");
            this.user_database = konfig.dajPostavku("user.database");
            this.driver_database = konfig.dajPostavku("driver.database");
            this.interval = Integer.parseInt(konfig.dajPostavku("interval"));
            
            if (this.driver_database == null) {
                this.status = false;
            } else {
                this.status = true;
            }

        }

    }

    public String getAdmin_database() {
        return admin_database;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public String getDriver_database() {
        return driver_database;
    }

    public String getServer_database() {
        return server_database;
    }

    public String getUser_database() {
        return user_database;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_username() {
        return user_username;
    }

    private String dajPostavku(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Integer getInterval() {
        return interval;
    }
}
