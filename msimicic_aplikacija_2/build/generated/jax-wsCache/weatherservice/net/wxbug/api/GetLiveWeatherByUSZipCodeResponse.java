
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
 *         &lt;element name="GetLiveWeatherByUSZipCodeResult" type="{http://api.wxbug.net/}LiveWeatherData" minOccurs="0"/>
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
    "getLiveWeatherByUSZipCodeResult"
})
@XmlRootElement(name = "GetLiveWeatherByUSZipCodeResponse")
public class GetLiveWeatherByUSZipCodeResponse {

    @XmlElement(name = "GetLiveWeatherByUSZipCodeResult")
    protected LiveWeatherData getLiveWeatherByUSZipCodeResult;

    /**
     * Gets the value of the getLiveWeatherByUSZipCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveWeatherData }
     *     
     */
    public LiveWeatherData getGetLiveWeatherByUSZipCodeResult() {
        return getLiveWeatherByUSZipCodeResult;
    }

    /**
     * Sets the value of the getLiveWeatherByUSZipCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveWeatherData }
     *     
     */
    public void setGetLiveWeatherByUSZipCodeResult(LiveWeatherData value) {
        this.getLiveWeatherByUSZipCodeResult = value;
    }

}
