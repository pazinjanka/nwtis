/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.mb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.foi.nwtis.msimicic.sB.KorisniciFacade;

/**
 *
 * @author Martina
 */
@ManagedBean(name = "Login")
@SessionScoped
public class Login implements Serializable {
    @EJB
    KorisniciFacade korisnikFacade;

    private String kor_ime = null;
    private String lozinka = null;

    /** Creates a new instance of Login */
    public Login() {
    }

  public String getKor_ime() {
    return kor_ime;
  }

  public void setKor_ime(String kor_ime) {
    this.kor_ime = kor_ime;
  }

  public String getLozinka() {
    return lozinka;
  }

  public void setLozinka(String lozinka) {
    this.lozinka = lozinka;
  }

    public Object prijava() {
        String result = "NE";
        FacesContext fcontext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)fcontext.getExternalContext().getRequest();            
        if (korisnikFacade.find(kor_ime) != null && korisnikFacade.find(kor_ime).getLozinka().compareTo(lozinka) == 0) {
            request.getSession().setAttribute("korisnik", kor_ime);
            result = "DA";
        }       
        return result;
    }
    public Object odjava() {
        FacesContext fcontext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)fcontext.getExternalContext().getRequest();       
        request.getSession().removeAttribute("korisnik");
        return "OUT";
    }
}
