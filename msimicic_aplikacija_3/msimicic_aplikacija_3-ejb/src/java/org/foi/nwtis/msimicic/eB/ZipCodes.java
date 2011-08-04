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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "ZIP_CODES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZipCodes.findAll", query = "SELECT z FROM ZipCodes z"),
    @NamedQuery(name = "ZipCodes.findByZip", query = "SELECT z FROM ZipCodes z WHERE z.zip = :zip"),
    @NamedQuery(name = "ZipCodes.findByLatitude", query = "SELECT z FROM ZipCodes z WHERE z.latitude = :latitude"),
    @NamedQuery(name = "ZipCodes.findByLongitude", query = "SELECT z FROM ZipCodes z WHERE z.longitude = :longitude"),
    @NamedQuery(name = "ZipCodes.findByZipClass", query = "SELECT z FROM ZipCodes z WHERE z.zipClass = :zipClass")})
public class ZipCodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private Integer zip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ZIP_CLASS")
    private String zipClass;
    @JoinColumns({
        @JoinColumn(name = "STATE", referencedColumnName = "STATE"),
        @JoinColumn(name = "COUNTY", referencedColumnName = "COUNTY"),
        @JoinColumn(name = "CITY", referencedColumnName = "CITY")})
    @ManyToOne(optional = false)
    private Cities cities;

    public ZipCodes() {
    }

    public ZipCodes(Integer zip) {
        this.zip = zip;
    }

    public ZipCodes(Integer zip, double latitude, double longitude, String zipClass) {
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zipClass = zipClass;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getZipClass() {
        return zipClass;
    }

    public void setZipClass(String zipClass) {
        this.zipClass = zipClass;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
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
        if (!(object instanceof ZipCodes)) {
            return false;
        }
        ZipCodes other = (ZipCodes) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.msimicic.eB.ZipCodes[ zip=" + zip + " ]";
    }
    
}
