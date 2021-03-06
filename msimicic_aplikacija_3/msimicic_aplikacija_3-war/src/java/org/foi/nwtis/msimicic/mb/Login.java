/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.sB.KorisniciFacadeLocal;

/**
 *
 * @author Martina
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login implements Serializable {
    @EJB
    KorisniciFacadeLocal korisnikFacade;

    private String kor_ime = null;
    private String lozinka = null;

    private List<Korisnici> aktivniKorisnici = new ArrayList<Korisnici>();
    
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
                System.out.println("Korisnik prijavljen!");
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext sc = (ServletContext) context.getExternalContext().getContext();
                aktivniKorisnici = (List<Korisnici>) sc.getAttribute("aktivniKorisnici");
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
