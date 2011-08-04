/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "KORISNICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnici.findAll", query = "SELECT k FROM Korisnici k"),
    @NamedQuery(name = "Korisnici.findByKorIme", query = "SELECT k FROM Korisnici k WHERE k.korIme = :korIme"),
    @NamedQuery(name = "Korisnici.findByIme", query = "SELECT k FROM Korisnici k WHERE k.ime = :ime"),
    @NamedQuery(name = "Korisnici.findByPrezime", query = "SELECT k FROM Korisnici k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Korisnici.findByLozinka", query = "SELECT k FROM Korisnici k WHERE k.lozinka = :lozinka"),
    @NamedQuery(name = "Korisnici.findByEmailAdresa", query = "SELECT k FROM Korisnici k WHERE k.emailAdresa = :emailAdresa"),
    @NamedQuery(name = "Korisnici.findByVrsta", query = "SELECT k FROM Korisnici k WHERE k.vrsta = :vrsta"),
    @NamedQuery(name = "Korisnici.findByDatumKreiranja", query = "SELECT k FROM Korisnici k WHERE k.datumKreiranja = :datumKreiranja"),
    @NamedQuery(name = "Korisnici.findByDatumPromjene", query = "SELECT k FROM Korisnici k WHERE k.datumPromjene = :datumPromjene")})
public class Korisnici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "KOR_IME")
    private String korIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IME")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PREZIME")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOZINKA")
    private String lozinka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL_ADRESA")
    private String emailAdresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRSTA")
    private int vrsta;
    @Column(name = "DATUM_KREIRANJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumKreiranja;
    @Column(name = "DATUM_PROMJENE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumPromjene;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korIme")
    private Collection<Putovanje> putovanjeCollection;

    public Korisnici() {
    }

    public Korisnici(String korIme) {
        this.korIme = korIme;
    }

    public Korisnici(String korIme, String ime, String prezime, String lozinka, String emailAdresa, int vrsta) {
        this.korIme = korIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.emailAdresa = emailAdresa;
        this.vrsta = vrsta;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public int getVrsta() {
        return vrsta;
    }

    public void setVrsta(int vrsta) {
        this.vrsta = vrsta;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumPromjene() {
        return datumPromjene;
    }

    public void setDatumPromjene(Date datumPromjene) {
        this.datumPromjene = datumPromjene;
    }

    @XmlTransient
    public Collection<Putovanje> getPutovanjeCollection() {
        return putovanjeCollection;
    }

    public void setPutovanjeCollection(Collection<Putovanje> putovanjeCollection) {
        this.putovanjeCollection = putovanjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korIme != null ? korIme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnici)) {
            return false;
        }
        Korisnici other = (Korisnici) object;
        if ((this.korIme == null && other.korIme != null) || (this.korIme != null && !this.korIme.equals(other.korIme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Korisnici[ korIme=" + korIme + " ]";
    }
    
}
