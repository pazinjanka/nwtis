
package net.wxbug.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUSWorldCityByLatLongResult" type="{http://api.wxbug.net/}LocationUSWorldCityData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getUSWorldCityByLatLongResult"
})
@XmlRootElement(name = "GetUSWorldCityByLatLongResponse")
public class GetUSWorldCityByLatLongResponse {

    @XmlElement(name = "GetUSWorldCityByLatLongResult")
    protected LocationUSWorldCityData getUSWorldCityByLatLongResult;

    /**
     * Gets the value of the getUSWorldCityByLatLongResult property.
     * 
     * @return
     *     possible object is
     *     {@link LocationUSWorldCityData }
     *     
     */
    public LocationUSWorldCityData getGetUSWorldCityByLatLongResult() {
        return getUSWorldCityByLatLongResult;
    }

    /**
     * Sets the value of the getUSWorldCityByLatLongResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationUSWorldCityData }
     *     
     */
    public void setGetUSWorldCityByLatLongResult(LocationUSWorldCityData value) {
        this.getUSWorldCityByLatLongResult = value;
    }

}
