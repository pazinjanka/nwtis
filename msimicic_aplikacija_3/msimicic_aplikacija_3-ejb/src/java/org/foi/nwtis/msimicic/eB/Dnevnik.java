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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "DNEVNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnevnik.findAll", query = "SELECT d FROM Dnevnik d"),
    @NamedQuery(name = "Dnevnik.findByDnevnikId", query = "SELECT d FROM Dnevnik d WHERE d.dnevnikId = :dnevnikId"),
    @NamedQuery(name = "Dnevnik.findByDatumod", query = "SELECT d FROM Dnevnik d WHERE d.datumod = :datumod"),
    @NamedQuery(name = "Dnevnik.findByDatumdo", query = "SELECT d FROM Dnevnik d WHERE d.datumdo = :datumdo"),
    @NamedQuery(name = "Dnevnik.findByBrojprocitanih", query = "SELECT d FROM Dnevnik d WHERE d.brojprocitanih = :brojprocitanih"),
    @NamedQuery(name = "Dnevnik.findByBrojnwtis", query = "SELECT d FROM Dnevnik d WHERE d.brojnwtis = :brojnwtis"),
    @NamedQuery(name = "Dnevnik.findByBrojispravnih", query = "SELECT d FROM Dnevnik d WHERE d.brojispravnih = :brojispravnih")})
public class Dnevnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNEVNIK_ID")
    private Integer dnevnikId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATUMOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATUMDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BROJPROCITANIH")
    private int brojprocitanih;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BROJNWTIS")
    private int brojnwtis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BROJISPRAVNIH")
    private int brojispravnih;

    public Dnevnik() {
    }

    public Dnevnik(Integer dnevnikId) {
        this.dnevnikId = dnevnikId;
    }

    public Dnevnik(Integer dnevnikId, Date datumod, Date datumdo, int brojprocitanih, int brojnwtis, int brojispravnih) {
        this.dnevnikId = dnevnikId;
        this.datumod = datumod;
        this.datumdo = datumdo;
        this.brojprocitanih = brojprocitanih;
        this.brojnwtis = brojnwtis;
        this.brojispravnih = brojispravnih;
    }

    public Integer getDnevnikId() {
        return dnevnikId;
    }

    public void setDnevnikId(Integer dnevnikId) {
        this.dnevnikId = dnevnikId;
    }

    public Date getDatumod() {
        return datumod;
    }

    public void setDatumod(Date datumod) {
        this.datumod = datumod;
    }

    public Date getDatumdo() {
        return datumdo;
    }

    public void setDatumdo(Date datumdo) {
        this.datumdo = datumdo;
    }

    public int getBrojprocitanih() {
        return brojprocitanih;
    }

    public void setBrojprocitanih(int brojprocitanih) {
        this.brojprocitanih = brojprocitanih;
    }

    public int getBrojnwtis() {
        return brojnwtis;
    }

    public void setBrojnwtis(int brojnwtis) {
        this.brojnwtis = brojnwtis;
    }

    public int getBrojispravnih() {
        return brojispravnih;
    }

    public void setBrojispravnih(int brojispravnih) {
        this.brojispravnih = brojispravnih;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnevnikId != null ? dnevnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnevnik)) {
            return false;
        }
        Dnevnik other = (Dnevnik) object;
        if ((this.dnevnikId == null && other.dnevnikId != null) || (this.dnevnikId != null && !this.dnevnikId.equals(other.dnevnikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Dnevnik[ dnevnikId=" + dnevnikId + " ]";
    }
    
}
