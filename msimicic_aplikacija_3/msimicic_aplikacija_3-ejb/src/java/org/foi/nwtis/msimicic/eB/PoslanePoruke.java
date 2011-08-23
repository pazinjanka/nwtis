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
@Table(name = "POSLANE_PORUKE")
@NamedQueries({
    @NamedQuery(name = "PoslanePoruke.findAll", query = "SELECT p FROM PoslanePoruke p"),
    @NamedQuery(name = "PoslanePoruke.findByPoslanaPorukaId", query = "SELECT p FROM PoslanePoruke p WHERE p.poslanaPorukaId = :poslanaPorukaId"),
    @NamedQuery(name = "PoslanePoruke.findByPrimatelj", query = "SELECT p FROM PoslanePoruke p WHERE p.primatelj = :primatelj"),
    @NamedQuery(name = "PoslanePoruke.findByPosiljatelj", query = "SELECT p FROM PoslanePoruke p WHERE p.posiljatelj = :posiljatelj"),
    @NamedQuery(name = "PoslanePoruke.findByDatum", query = "SELECT p FROM PoslanePoruke p WHERE p.datum = :datum"),
    @NamedQuery(name = "PoslanePoruke.findByNaslov", query = "SELECT p FROM PoslanePoruke p WHERE p.naslov = :naslov"),
    @NamedQuery(name = "PoslanePoruke.findBySadrzaj", query = "SELECT p FROM PoslanePoruke p WHERE p.sadrzaj = :sadrzaj")})
public class PoslanePoruke implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "POSLANA_PORUKA_ID")
    private Integer poslanaPorukaId;
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

    public PoslanePoruke() {
    }

    public PoslanePoruke(Integer poslanaPorukaId) {
        this.poslanaPorukaId = poslanaPorukaId;
    }

    public PoslanePoruke(Integer poslanaPorukaId, String posiljatelj, Date datum, String naslov, String sadrzaj) {
        this.poslanaPorukaId = poslanaPorukaId;
        this.posiljatelj = posiljatelj;
        this.datum = datum;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
    }

    public Integer getPoslanaPorukaId() {
        return poslanaPorukaId;
    }

    public void setPoslanaPorukaId(Integer poslanaPorukaId) {
        this.poslanaPorukaId = poslanaPorukaId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poslanaPorukaId != null ? poslanaPorukaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoslanePoruke)) {
            return false;
        }
        PoslanePoruke other = (PoslanePoruke) object;
        if ((this.poslanaPorukaId == null && other.poslanaPorukaId != null) || (this.poslanaPorukaId != null && !this.poslanaPorukaId.equals(other.poslanaPorukaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.PoslanePoruke[poslanaPorukaId=" + poslanaPorukaId + "]";
    }

}
