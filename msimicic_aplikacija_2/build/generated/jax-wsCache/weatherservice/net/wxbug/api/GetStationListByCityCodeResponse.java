
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
 *         &lt;element name="GetStationListByCityCodeResult" type="{http://api.wxbug.net/}ArrayOfAnyType" minOccurs="0"/>
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
    "getStationListByCityCodeResult"
})
@XmlRootElement(name = "GetStationListByCityCodeResponse")
public class GetStationListByCityCodeResponse {

    @XmlElement(name = "GetStationListByCityCodeResult")
    protected ArrayOfAnyType getStationListByCityCodeResult;

    /**
     * Gets the value of the getStationListByCityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public ArrayOfAnyType getGetStationListByCityCodeResult() {
        return getStationListByCityCodeResult;
    }

    /**
     * Sets the value of the getStationListByCityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public void setGetStationListByCityCodeResult(ArrayOfAnyType value) {
        this.getStationListByCityCodeResult = value;
    }

}
