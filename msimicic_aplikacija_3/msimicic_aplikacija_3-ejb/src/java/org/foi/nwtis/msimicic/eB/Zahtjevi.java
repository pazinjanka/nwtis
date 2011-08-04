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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "ZAHTJEVI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zahtjevi.findAll", query = "SELECT z FROM Zahtjevi z"),
    @NamedQuery(name = "Zahtjevi.findByZahtjevId", query = "SELECT z FROM Zahtjevi z WHERE z.zahtjevId = :zahtjevId"),
    @NamedQuery(name = "Zahtjevi.findByPosiljatelj", query = "SELECT z FROM Zahtjevi z WHERE z.posiljatelj = :posiljatelj"),
    @NamedQuery(name = "Zahtjevi.findByDatum", query = "SELECT z FROM Zahtjevi z WHERE z.datum = :datum"),
    @NamedQuery(name = "Zahtjevi.findByKomanda", query = "SELECT z FROM Zahtjevi z WHERE z.komanda = :komanda"),
    @NamedQuery(name = "Zahtjevi.findByVrsta", query = "SELECT z FROM Zahtjevi z WHERE z.vrsta = :vrsta"),
    @NamedQuery(name = "Zahtjevi.findBySadrzaj", query = "SELECT z FROM Zahtjevi z WHERE z.sadrzaj = :sadrzaj"),
    @NamedQuery(name = "Zahtjevi.findByIspravna", query = "SELECT z FROM Zahtjevi z WHERE z.ispravna = :ispravna")})
public class Zahtjevi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZAHTJEV_ID")
    private Integer zahtjevId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "POSILJATELJ")
    private String posiljatelj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "KOMANDA")
    private String komanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "VRSTA")
    private String vrsta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SADRZAJ")
    private String sadrzaj;
    @Column(name = "ISPRAVNA")
    private Character ispravna;

    public Zahtjevi() {
    }

    public Zahtjevi(Integer zahtjevId) {
        this.zahtjevId = zahtjevId;
    }

    public Zahtjevi(Integer zahtjevId, String posiljatelj, Date datum, String komanda, String vrsta, String sadrzaj) {
        this.zahtjevId = zahtjevId;
        this.posiljatelj = posiljatelj;
        this.datum = datum;
        this.komanda = komanda;
        this.vrsta = vrsta;
        this.sadrzaj = sadrzaj;
    }

    public Integer getZahtjevId() {
        return zahtjevId;
    }

    public void setZahtjevId(Integer zahtjevId) {
        this.zahtjevId = zahtjevId;
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

    public String getKomanda() {
        return komanda;
    }

    public void setKomanda(String komanda) {
        this.komanda = komanda;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
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
        hash += (zahtjevId != null ? zahtjevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zahtjevi)) {
            return false;
        }
        Zahtjevi other = (Zahtjevi) object;
        if ((this.zahtjevId == null && other.zahtjevId != null) || (this.zahtjevId != null && !this.zahtjevId.equals(other.zahtjevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Zahtjevi[ zahtjevId=" + zahtjevId + " ]";
    }
    
}
