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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "STATES")
@NamedQueries({
    @NamedQuery(name = "States.findAll", query = "SELECT s FROM States s"),
    @NamedQuery(name = "States.findByState", query = "SELECT s FROM States s WHERE s.state = :state"),
    @NamedQuery(name = "States.findByName", query = "SELECT s FROM States s WHERE s.name = :name")})
public class States implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "states")
    private Collection<Counties> countiesCollection;

    public States() {
    }

    public States(String state) {
        this.state = state;
    }

    public States(String state, String name) {
        this.state = state;
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Counties> getCountiesCollection() {
        return countiesCollection;
    }

    public void setCountiesCollection(Collection<Counties> countiesCollection) {
        this.countiesCollection = countiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (state != null ? state.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof States)) {
            return false;
        }
        States other = (States) object;
        if ((this.state == null && other.state != null) || (this.state != null && !this.state.equals(other.state))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.States[state=" + state + "]";
    }

}
