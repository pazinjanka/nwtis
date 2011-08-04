/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.eB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martina
 */
@Entity
@Table(name = "MYCITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mycities.findAll", query = "SELECT m FROM Mycities m"),
    @NamedQuery(name = "Mycities.findByZip", query = "SELECT m FROM Mycities m WHERE m.zip = :zip")})
public class Mycities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private Integer zip;

    public Mycities() {
    }

    public Mycities(Integer zip) {
        this.zip = zip;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zip != null ? zip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mycities)) {
            return false;
        }
        Mycities other = (Mycities) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.Mycities[ zip=" + zip + " ]";
    }
    
}
