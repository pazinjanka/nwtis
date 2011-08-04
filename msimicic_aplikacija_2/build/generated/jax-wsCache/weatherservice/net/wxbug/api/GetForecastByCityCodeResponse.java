
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
 *         &lt;element name="GetForecastByCityCodeResult" type="{http://api.wxbug.net/}ArrayOfAnyType" minOccurs="0"/>
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
    "getForecastByCityCodeResult"
})
@XmlRootElement(name = "GetForecastByCityCodeResponse")
public class GetForecastByCityCodeResponse {

    @XmlElement(name = "GetForecastByCityCodeResult")
    protected ArrayOfAnyType getForecastByCityCodeResult;

    /**
     * Gets the value of the getForecastByCityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public ArrayOfAnyType getGetForecastByCityCodeResult() {
        return getForecastByCityCodeResult;
    }

    /**
     * Sets the value of the getForecastByCityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public void setGetForecastByCityCodeResult(ArrayOfAnyType value) {
        this.getForecastByCityCodeResult = value;
    }

}
