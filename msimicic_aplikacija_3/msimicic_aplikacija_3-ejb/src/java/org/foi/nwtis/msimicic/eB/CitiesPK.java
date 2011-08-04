/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Martina
 */
@Embeddable
public class CitiesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COUNTY")
    private String county;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CITY")
    private String city;

    public CitiesPK() {
    }

    public CitiesPK(String state, String county, String city) {
        this.state = state;
        this.county = county;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (state != null ? state.hashCode() : 0);
        hash += (county != null ? county.hashCode() : 0);
        hash += (city != null ? city.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitiesPK)) {
            return false;
        }
        CitiesPK other = (CitiesPK) object;
        if ((this.state == null && other.state != null) || (this.state != null && !this.state.equals(other.state))) {
            return false;
        }
        if ((this.county == null && other.county != null) || (this.county != null && !this.county.equals(other.county))) {
            return false;
        }
        if ((this.city == null && other.city != null) || (this.city != null && !this.city.equals(other.city))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.CitiesPK[ state=" + state + ", county=" + county + ", city=" + city + " ]";
    }
    
}
