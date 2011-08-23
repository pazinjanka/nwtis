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

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "PUTOVANJA")
@NamedQueries({
    @NamedQuery(name = "Putovanja.findAll", query = "SELECT p FROM Putovanja p"),
    @NamedQuery(name = "Putovanja.findByPutovanjeId", query = "SELECT p FROM Putovanja p WHERE p.putovanjeId = :putovanjeId"),
    @NamedQuery(name = "Putovanja.findByGradovi", query = "SELECT p FROM Putovanja p WHERE p.gradovi = :gradovi")})
public class Putovanja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PUTOVANJE_ID")
    private Integer putovanjeId;
    @Basic(optional = false)
    @Column(name = "GRADOVI")
    private String gradovi;
    @JoinColumn(name = "KOR_IME", referencedColumnName = "KOR_IME")
    @ManyToOne(optional = false)
    private Korisnici korisnici;

    public Putovanja() {
    }

    public Putovanja(Integer putovanjeId) {
        this.putovanjeId = putovanjeId;
    }

    public Putovanja(Integer putovanjeId, String gradovi) {
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

    public Korisnici getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
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
        if (!(object instanceof Putovanja)) {
            return false;
        }
        Putovanja other = (Putovanja) object;
        if ((this.putovanjeId == null && other.putovanjeId != null) || (this.putovanjeId != null && !this.putovanjeId.equals(other.putovanjeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Putovanja[putovanjeId=" + putovanjeId + "]";
    }

}
