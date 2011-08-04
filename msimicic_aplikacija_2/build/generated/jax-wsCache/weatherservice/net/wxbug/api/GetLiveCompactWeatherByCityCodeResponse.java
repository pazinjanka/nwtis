
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
 *         &lt;element name="GetLiveCompactWeatherByCityCodeResult" type="{http://api.wxbug.net/}LiveCompactWeatherData" minOccurs="0"/>
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
    "getLiveCompactWeatherByCityCodeResult"
})
@XmlRootElement(name = "GetLiveCompactWeatherByCityCodeResponse")
public class GetLiveCompactWeatherByCityCodeResponse {

    @XmlElement(name = "GetLiveCompactWeatherByCityCodeResult")
    protected LiveCompactWeatherData getLiveCompactWeatherByCityCodeResult;

    /**
     * Gets the value of the getLiveCompactWeatherByCityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveCompactWeatherData }
     *     
     */
    public LiveCompactWeatherData getGetLiveCompactWeatherByCityCodeResult() {
        return getLiveCompactWeatherByCityCodeResult;
    }

    /**
     * Sets the value of the getLiveCompactWeatherByCityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveCompactWeatherData }
     *     
     */
    public void setGetLiveCompactWeatherByCityCodeResult(LiveCompactWeatherData value) {
        this.getLiveCompactWeatherByCityCodeResult = value;
    }

}
