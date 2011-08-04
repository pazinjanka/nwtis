/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "PUTOVANJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Putovanje.findAll", query = "SELECT p FROM Putovanje p"),
    @NamedQuery(name = "Putovanje.findByPutovanjeId", query = "SELECT p FROM Putovanje p WHERE p.putovanjeId = :putovanjeId"),
    @NamedQuery(name = "Putovanje.findByGradovi", query = "SELECT p FROM Putovanje p WHERE p.gradovi = :gradovi")})
public class Putovanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUTOVANJE_ID")
    private Integer putovanjeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GRADOVI")
    private String gradovi;
    @JoinColumn(name = "KOR_IME", referencedColumnName = "KOR_IME")
    @ManyToOne(optional = false)
    private Korisnici korIme;

    public Putovanje() {
    }

    public Putovanje(Integer putovanjeId) {
        this.putovanjeId = putovanjeId;
    }

    public Putovanje(Integer putovanjeId, String gradovi) {
        this.putovanjeId = putovanjeId;
        this.gradovi = gradovi;
    }

    public Integer getPutovanjeId() {
        return putovanjeId;
    }

    public void setPutovanjeId(Integer putovanjeId) {
        this.putovanjeId = putovanjeId;
    }

    public String getGradovi() {
        return gradovi;
    }

    public void setGradovi(String gradovi) {
        this.gradovi = gradovi;
    }

    public Korisnici getKorIme() {
        return korIme;
    }

    public void setKorIme(Korisnici korIme) {
        this.korIme = korIme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (putovanjeId != null ? putovanjeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Putovanje)) {
            return false;
        }
        Putovanje other = (Putovanje) object;
        if ((this.putovanjeId == null && other.putovanjeId != null) || (this.putovanjeId != null && !this.putovanjeId.equals(other.putovanjeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Putovanje[ putovanjeId=" + putovanjeId + " ]";
    }
    
}
