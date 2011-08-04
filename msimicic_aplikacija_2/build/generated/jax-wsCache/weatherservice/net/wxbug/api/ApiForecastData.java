
package net.wxbug.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiForecastData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApiForecastData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConditionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Icon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsNight" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Prediction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortPrediction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TempHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TempLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TempUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApiForecastData", propOrder = {
    "conditionID",
    "description",
    "icon",
    "image",
    "isNight",
    "prediction",
    "shortPrediction",
    "shortTitle",
    "tempHigh",
    "tempLow",
    "tempUnit",
    "title",
    "webUrl"
})
public class ApiForecastData {

    @XmlElement(name = "ConditionID")
    protected String conditionID;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Icon")
    protected String icon;
    @XmlElement(name = "Image")
    protected String image;
    @XmlElement(name = "IsNight")
    protected boolean isNight;
    @XmlElement(name = "Prediction")
    protected String prediction;
    @XmlElement(name = "ShortPrediction")
    protected String shortPrediction;
    @XmlElement(name = "ShortTitle")
    protected String shortTitle;
    @XmlElement(name = "TempHigh")
    protected String tempHigh;
    @XmlElement(name = "TempLow")
    protected String tempLow;
    @XmlElement(name = "TempUnit")
    protected String tempUnit;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "WebUrl")
    protected String webUrl;

    /**
     * Gets the value of the conditionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionID() {
        return conditionID;
    }

    /**
     * Sets the value of the conditionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionID(String value) {
        this.conditionID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the isNight property.
     * 
     */
    public boolean isIsNight() {
        return isNight;
    }

    /**
     * Sets the value of the isNight property.
     * 
     */
    public void setIsNight(boolean value) {
        this.isNight = value;
    }

    /**
     * Gets the value of the prediction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrediction() {
        return prediction;
    }

    /**
     * Sets the value of the prediction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrediction(String value) {
        this.prediction = value;
    }

    /**
     * Gets the value of the shortPrediction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortPrediction() {
        return shortPrediction;
    }

    /**
     * Sets the value of the shortPrediction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortPrediction(String value) {
        this.shortPrediction = value;
    }

    /**
     * Gets the value of the shortTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * Sets the value of the shortTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortTitle(String value) {
        this.shortTitle = value;
    }

    /**
     * Gets the value of the tempHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempHigh() {
        return tempHigh;
    }

    /**
     * Sets the value of the tempHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempHigh(String value) {
        this.tempHigh = value;
    }

    /**
     * Gets the value of the tempLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempLow() {
        return tempLow;
    }

    /**
     * Sets the value of the tempLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempLow(String value) {
        this.tempLow = value;
    }

    /**
     * Gets the value of the tempUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempUnit() {
        return tempUnit;
    }

    /**
     * Sets the value of the tempUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempUnit(String value) {
        this.tempUnit = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the webUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebUrl() {
        return webUrl;
    }

    /**
     * Sets the value of the webUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebUrl(String value) {
        this.webUrl = value;
    }

}
