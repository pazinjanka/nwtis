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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ZAHTJEVI")
@NamedQueries({
    @NamedQuery(name = "Zahtjevi.findAll", query = "SELECT z FROM Zahtjevi z"),
    @NamedQuery(name = "Zahtjevi.findByZahtjevId", query = "SELECT z FROM Zahtjevi z WHERE z.zahtjevId = :zahtjevId"),
    @NamedQuery(name = "Zahtjevi.findByDatumZahtjeva", query = "SELECT z FROM Zahtjevi z WHERE z.datumZahtjeva = :datumZahtjeva"),
    @NamedQuery(name = "Zahtjevi.findByNaredba", query = "SELECT z FROM Zahtjevi z WHERE z.naredba = :naredba"),
    @NamedQuery(name = "Zahtjevi.findByBrojDana", query = "SELECT z FROM Zahtjevi z WHERE z.brojDana = :brojDana"),
    @NamedQuery(name = "Zahtjevi.findByPutaPoslano", query = "SELECT z FROM Zahtjevi z WHERE z.putaPoslano = :putaPoslano"),
    @NamedQuery(name = "Zahtjevi.findByZavrseno", query = "SELECT z FROM Zahtjevi z WHERE z.zavrseno = :zavrseno"),
    @NamedQuery(name = "Zahtjevi.findByGradCode", query = "SELECT z FROM Zahtjevi z WHERE z.gradCode = :gradCode"),
    @NamedQuery(name = "Zahtjevi.findByDatumod", query = "SELECT z FROM Zahtjevi z WHERE z.datumod = :datumod"),
    @NamedQuery(name = "Zahtjevi.findByDatumdo", query = "SELECT z FROM Zahtjevi z WHERE z.datumdo = :datumdo")})
public class Zahtjevi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZAHTJEV_ID")
    private Integer zahtjevId;
    @Basic(optional = false)
    @Column(name = "DATUM_ZAHTJEVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumZahtjeva;
    @Column(name = "NAREDBA")
    private String naredba;
    @Basic(optional = false)
    @Column(name = "BROJ_DANA")
    private int brojDana;
    @Column(name = "PUTA_POSLANO")
    private Integer putaPoslano;
    @Column(name = "ZAVRSENO")
    private String zavrseno;
    @Basic(optional = false)
    @Column(name = "GRAD_CODE")
    private int gradCode;
    @Column(name = "DATUMOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumod;
    @Column(name = "DATUMDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumdo;
    @JoinColumn(name = "KOR_IME", referencedColumnName = "KOR_IME")
    @ManyToOne(optional = false)
    private Korisnici korisnici;

    public Zahtjevi() {
    }

    public Zahtjevi(Integer zahtjevId) {
        this.zahtjevId = zahtjevId;
    }

    public Zahtjevi(Integer zahtjevId, Date datumZahtjeva, int brojDana, int gradCode) {
        this.zahtjevId = zahtjevId;
        this.datumZahtjeva = datumZahtjeva;
        this.brojDana = brojDana;
        this.gradCode = gradCode;
    }

    public Integer getZahtjevId() {
        return zahtjevId;
    }

    public void setZahtjevId(Integer zahtjevId) {
        this.zahtjevId = zahtjevId;
    }

    public Date getDatumZahtjeva() {
        return datumZahtjeva;
    }

    public void setDatumZahtjeva(Date datumZahtjeva) {
        this.datumZahtjeva = datumZahtjeva;
    }

    public String getNaredba() {
        return naredba;
    }

    public void setNaredba(String naredba) {
        this.naredba = naredba;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public Integer getPutaPoslano() {
        return putaPoslano;
    }

    public void setPutaPoslano(Integer putaPoslano) {
        this.putaPoslano = putaPoslano;
    }

    public String getZavrseno() {
        return zavrseno;
    }

    public void setZavrseno(String zavrseno) {
        this.zavrseno = zavrseno;
    }

    public int getGradCode() {
        return gradCode;
    }

    public void setGradCode(int gradCode) {
        this.gradCode = gradCode;
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

    public Korisnici getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
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
        return "org.foi.nwtis.msimicic.eB.Zahtjevi[zahtjevId=" + zahtjevId + "]";
    }

}
