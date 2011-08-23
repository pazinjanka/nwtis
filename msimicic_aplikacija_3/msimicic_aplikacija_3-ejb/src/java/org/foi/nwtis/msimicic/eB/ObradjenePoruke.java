/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "OBRADJENE_PORUKE")
@NamedQueries({
    @NamedQuery(name = "ObradjenePoruke.findAll", query = "SELECT o FROM ObradjenePoruke o"),
    @NamedQuery(name = "ObradjenePoruke.findByObradjenaPorukaId", query = "SELECT o FROM ObradjenePoruke o WHERE o.obradjenaPorukaId = :obradjenaPorukaId"),
    @NamedQuery(name = "ObradjenePoruke.findByPrimatelj", query = "SELECT o FROM ObradjenePoruke o WHERE o.primatelj = :primatelj"),
    @NamedQuery(name = "ObradjenePoruke.findByPosiljatelj", query = "SELECT o FROM ObradjenePoruke o WHERE o.posiljatelj = :posiljatelj"),
    @NamedQuery(name = "ObradjenePoruke.findByDatum", query = "SELECT o FROM ObradjenePoruke o WHERE o.datum = :datum"),
    @NamedQuery(name = "ObradjenePoruke.findByNaslov", query = "SELECT o FROM ObradjenePoruke o WHERE o.naslov = :naslov"),
    @NamedQuery(name = "ObradjenePoruke.findBySadrzaj", query = "SELECT o FROM ObradjenePoruke o WHERE o.sadrzaj = :sadrzaj"),
    @NamedQuery(name = "ObradjenePoruke.findByVrsta", query = "SELECT o FROM ObradjenePoruke o WHERE o.vrsta = :vrsta"),
    @NamedQuery(name = "ObradjenePoruke.findByIspravna", query = "SELECT o FROM ObradjenePoruke o WHERE o.ispravna = :ispravna")})
public class ObradjenePoruke implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OBRADJENA_PORUKA_ID")
    private Integer obradjenaPorukaId;
    @Column(name = "PRIMATELJ")
    private String primatelj;
    @Basic(optional = false)
    @Column(name = "POSILJATELJ")
    private String posiljatelj;
    @Basic(optional = false)
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "NASLOV")
    private String naslov;
    @Basic(optional = false)
    @Column(name = "SADRZAJ")
    private String sadrzaj;
    @Basic(optional = false)
    @Column(name = "VRSTA")
    private String vrsta;
    @Column(name = "ISPRAVNA")
    private Character ispravna;

    public ObradjenePoruke() {
    }

    public ObradjenePoruke(Integer obradjenaPorukaId) {
        this.obradjenaPorukaId = obradjenaPorukaId;
    }

    public ObradjenePoruke(Integer obradjenaPorukaId, String posiljatelj, Date datum, String naslov, String sadrzaj, String vrsta) {
        this.obradjenaPorukaId = obradjenaPorukaId;
        this.posiljatelj = posiljatelj;
        this.datum = datum;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
        this.vrsta = vrsta;
    }

    public Integer getObradjenaPorukaId() {
        return obradjenaPorukaId;
    }

    public void setObradjenaPorukaId(Integer obradjenaPorukaId) {
        this.obradjenaPorukaId = obradjenaPorukaId;
    }

    public String getPrimatelj() {
        return primatelj;
    }

    public void setPrimatelj(String primatelj) {
        this.primatelj = primatelj;
    }

    public String getPosiljatelj() {
        return posiljatelj;
    }

    public void setPosiljatelj(String posiljatelj) {
        this.posiljatelj = posiljatelj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public Character getIspravna() {
        return ispravna;
    }

    public void setIspravna(Character ispravna) {
        this.ispravna = ispravna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obradjenaPorukaId != null ? obradjenaPorukaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObradjenePoruke)) {
            return false;
        }
        ObradjenePoruke other = (ObradjenePoruke) object;
        if ((this.obradjenaPorukaId == null && other.obradjenaPorukaId != null) || (this.obradjenaPorukaId != null && !this.obradjenaPorukaId.equals(other.obradjenaPorukaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.ObradjenePoruke[obradjenaPorukaId=" + obradjenaPorukaId + "]";
    }

}
