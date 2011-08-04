
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
 *         &lt;element name="GetLiveCompactWeatherByUSZipCodeResult" type="{http://api.wxbug.net/}LiveCompactWeatherData" minOccurs="0"/>
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
    "getLiveCompactWeatherByUSZipCodeResult"
})
@XmlRootElement(name = "GetLiveCompactWeatherByUSZipCodeResponse")
public class GetLiveCompactWeatherByUSZipCodeResponse {

    @XmlElement(name = "GetLiveCompactWeatherByUSZipCodeResult")
    protected LiveCompactWeatherData getLiveCompactWeatherByUSZipCodeResult;

    /**
     * Gets the value of the getLiveCompactWeatherByUSZipCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveCompactWeatherData }
     *     
     */
    public LiveCompactWeatherData getGetLiveCompactWeatherByUSZipCodeResult() {
        return getLiveCompactWeatherByUSZipCodeResult;
    }

    /**
     * Sets the value of the getLiveCompactWeatherByUSZipCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveCompactWeatherData }
     *     
     */
    public void setGetLiveCompactWeatherByUSZipCodeResult(LiveCompactWeatherData value) {
        this.getLiveCompactWeatherByUSZipCodeResult = value;
    }

}
