
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
 *         &lt;element name="cityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unittype" type="{http://api.wxbug.net/}UnitType"/>
 *         &lt;element name="ACode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cityCode",
    "unittype",
    "aCode"
})
@XmlRootElement(name = "GetLiveWeatherByCityCode")
public class GetLiveWeatherByCityCode {

    protected String cityCode;
    @XmlElement(required = true)
    protected UnitType unittype;
    @XmlElement(name = "ACode")
    protected String aCode;

    /**
     * Gets the value of the cityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Sets the value of the cityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityCode(String value) {
        this.cityCode = value;
    }

    /**
     * Gets the value of the unittype property.
     * 
     * @return
     *     possible object is
     *     {@link UnitType }
     *     
     */
    public UnitType getUnittype() {
        return unittype;
    }

    /**
     * Sets the value of the unittype property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitType }
     *     
     */
    public void setUnittype(UnitType value) {
        this.unittype = value;
    }

    /**
     * Gets the value of the aCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACode() {
        return aCode;
    }

    /**
     * Sets the value of the aCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACode(String value) {
        this.aCode = value;
    }

}
