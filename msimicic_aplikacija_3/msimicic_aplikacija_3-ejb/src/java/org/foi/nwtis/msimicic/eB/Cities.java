/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "CITIES")
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findByState", query = "SELECT c FROM Cities c WHERE c.citiesPK.state = :state"),
    @NamedQuery(name = "Cities.findByCounty", query = "SELECT c FROM Cities c WHERE c.citiesPK.county = :county"),
    @NamedQuery(name = "Cities.findByCity", query = "SELECT c FROM Cities c WHERE c.citiesPK.city = :city"),
    @NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")})
public class Cities implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CitiesPK citiesPK;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinColumns({
        @JoinColumn(name = "STATE", referencedColumnName = "STATE", insertable = false, updatable = false),
        @JoinColumn(name = "COUNTY", referencedColumnName = "COUNTY", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Counties counties;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cities")
    private Collection<ZipCodes> zipCodesCollection;

    public Cities() {
    }

    public Cities(CitiesPK citiesPK) {
        this.citiesPK = citiesPK;
    }

    public Cities(CitiesPK citiesPK, String name) {
        this.citiesPK = citiesPK;
        this.name = name;
    }

    public Cities(String state, String county, String city) {
        this.citiesPK = new CitiesPK(state, county, city);
    }

    public CitiesPK getCitiesPK() {
        return citiesPK;
    }

    public void setCitiesPK(CitiesPK citiesPK) {
        this.citiesPK = citiesPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counties getCounties() {
        return counties;
    }

    public void setCounties(Counties counties) {
        this.counties = counties;
    }

    public Collection<ZipCodes> getZipCodesCollection() {
        return zipCodesCollection;
    }

    public void setZipCodesCollection(Collection<ZipCodes> zipCodesCollection) {
        this.zipCodesCollection = zipCodesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citiesPK != null ? citiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.citiesPK == null && other.citiesPK != null) || (this.citiesPK != null && !this.citiesPK.equals(other.citiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Cities[citiesPK=" + citiesPK + "]";
    }

}
