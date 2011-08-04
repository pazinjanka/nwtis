
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
 *         &lt;element name="GetLiveWeatherByCityCodeResult" type="{http://api.wxbug.net/}LiveWeatherData" minOccurs="0"/>
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
    "getLiveWeatherByCityCodeResult"
})
@XmlRootElement(name = "GetLiveWeatherByCityCodeResponse")
public class GetLiveWeatherByCityCodeResponse {

    @XmlElement(name = "GetLiveWeatherByCityCodeResult")
    protected LiveWeatherData getLiveWeatherByCityCodeResult;

    /**
     * Gets the value of the getLiveWeatherByCityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveWeatherData }
     *     
     */
    public LiveWeatherData getGetLiveWeatherByCityCodeResult() {
        return getLiveWeatherByCityCodeResult;
    }

    /**
     * Sets the value of the getLiveWeatherByCityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveWeatherData }
     *     
     */
    public void setGetLiveWeatherByCityCodeResult(LiveWeatherData value) {
        this.getLiveWeatherByCityCodeResult = value;
    }

}
