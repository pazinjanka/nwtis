/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
/**
 *
 * @author Martina
 */
@ManagedBean
@SessionScoped
public class Lokalizacija implements Serializable{

    private static Map<String, String> jezici;
    private String odabraniJezik = "hr";

    /** Creates a new instance of Lokalizacija */
    static {
        jezici = new LinkedHashMap<String,String>();
        jezici.put("Hrvatski", "hr");
        jezici.put("English", "en");
    }

    public Map<String, String> getJezici() {
        return jezici;
    }

    public String getOdabraniJezik() {
        return odabraniJezik;
    }

    public void setOdabraniJezik(String odabraniJezik) {
        this.odabraniJezik = odabraniJezik;
    }
    
    public void promjena(ValueChangeEvent e) {
        this.odabraniJezik = e.getNewValue().toString();
    }
    
    public Object postaviLocalizaciju() {
        FacesContext context = FacesContext.getCurrentInstance();
        Object noviLocale = this.getOdabraniJezik();
        context.getApplication().setDefaultLocale(new Locale((String) noviLocale));
        return "LOGIN";
    }
}
