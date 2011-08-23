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
@Table(name = "COUNTIES")
@NamedQueries({
    @NamedQuery(name = "Counties.findAll", query = "SELECT c FROM Counties c"),
    @NamedQuery(name = "Counties.findByState", query = "SELECT c FROM Counties c WHERE c.countiesPK.state = :state"),
    @NamedQuery(name = "Counties.findByCounty", query = "SELECT c FROM Counties c WHERE c.countiesPK.county = :county"),
    @NamedQuery(name = "Counties.findByName", query = "SELECT c FROM Counties c WHERE c.name = :name")})
public class Counties implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountiesPK countiesPK;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counties")
    private Collection<Cities> citiesCollection;
    @JoinColumn(name = "STATE", referencedColumnName = "STATE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private States states;

    public Counties() {
    }

    public Counties(CountiesPK countiesPK) {
        this.countiesPK = countiesPK;
    }

    public Counties(CountiesPK countiesPK, String name) {
        this.countiesPK = countiesPK;
        this.name = name;
    }

    public Counties(String state, String county) {
        this.countiesPK = new CountiesPK(state, county);
    }

    public CountiesPK getCountiesPK() {
        return countiesPK;
    }

    public void setCountiesPK(CountiesPK countiesPK) {
        this.countiesPK = countiesPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Cities> getCitiesCollection() {
        return citiesCollection;
    }

    public void setCitiesCollection(Collection<Cities> citiesCollection) {
        this.citiesCollection = citiesCollection;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countiesPK != null ? countiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Counties)) {
            return false;
        }
        Counties other = (Counties) object;
        if ((this.countiesPK == null && other.countiesPK != null) || (this.countiesPK != null && !this.countiesPK.equals(other.countiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Counties[countiesPK=" + countiesPK + "]";
    }

}
