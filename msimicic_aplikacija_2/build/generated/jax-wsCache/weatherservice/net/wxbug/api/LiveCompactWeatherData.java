
package net.wxbug.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LiveCompactWeatherData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiveCompactWeatherData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrIcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindSpeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindSpeedUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindDirectionString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InputLocationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ObDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RainToday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationIDRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationIDReturned" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZoneOffset" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="WebUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindDirection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindSpeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindSpeedUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiveCompactWeatherData", propOrder = {
    "city",
    "cityCode",
    "country",
    "currIcon",
    "currDesc",
    "gustWindSpeed",
    "gustWindSpeedUnit",
    "gustWindDirectionString",
    "inputLocationUrl",
    "latitude",
    "longitude",
    "obDate",
    "obDateTime",
    "rainToday",
    "rainUnit",
    "state",
    "stationIDRequested",
    "stationIDReturned",
    "stationName",
    "temperature",
    "temperatureUnit",
    "timeZone",
    "timeZoneOffset",
    "webUrl",
    "windDirection",
    "windSpeed",
    "windSpeedUnit",
    "zipCode"
})
public class LiveCompactWeatherData {

    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "CityCode")
    protected String cityCode;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "CurrIcon")
    protected String currIcon;
    @XmlElement(name = "CurrDesc")
    protected String currDesc;
    @XmlElement(name = "GustWindSpeed")
    protected String gustWindSpeed;
    @XmlElement(name = "GustWindSpeedUnit")
    protected String gustWindSpeedUnit;
    @XmlElement(name = "GustWindDirectionString")
    protected String gustWindDirectionString;
    @XmlElement(name = "InputLocationUrl")
    protected String inputLocationUrl;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "ObDate")
    protected String obDate;
    @XmlElement(name = "ObDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar obDateTime;
    @XmlElement(name = "RainToday")
    protected String rainToday;
    @XmlElement(name = "RainUnit")
    protected String rainUnit;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "StationIDRequested")
    protected String stationIDRequested;
    @XmlElement(name = "StationIDReturned")
    protected String stationIDReturned;
    @XmlElement(name = "StationName")
    protected String stationName;
    @XmlElement(name = "Temperature")
    protected String temperature;
    @XmlElement(name = "TemperatureUnit")
    protected String temperatureUnit;
    @XmlElement(name = "TimeZone")
    protected String timeZone;
    @XmlElement(name = "TimeZoneOffset")
    protected double timeZoneOffset;
    @XmlElement(name = "WebUrl")
    protected String webUrl;
    @XmlElement(name = "WindDirection")
    protected String windDirection;
    @XmlElement(name = "WindSpeed")
    protected String windSpeed;
    @XmlElement(name = "WindSpeedUnit")
    protected String windSpeedUnit;
    @XmlElement(name = "ZipCode")
    protected String zipCode;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

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
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the currIcon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrIcon() {
        return currIcon;
    }

    /**
     * Sets the value of the currIcon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrIcon(String value) {
        this.currIcon = value;
    }

    /**
     * Gets the value of the currDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrDesc() {
        return currDesc;
    }

    /**
     * Sets the value of the currDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrDesc(String value) {
        this.currDesc = value;
    }

    /**
     * Gets the value of the gustWindSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustWindSpeed() {
        return gustWindSpeed;
    }

    /**
     * Sets the value of the gustWindSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustWindSpeed(String value) {
        this.gustWindSpeed = value;
    }

    /**
     * Gets the value of the gustWindSpeedUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustWindSpeedUnit() {
        return gustWindSpeedUnit;
    }

    /**
     * Sets the value of the gustWindSpeedUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustWindSpeedUnit(String value) {
        this.gustWindSpeedUnit = value;
    }

    /**
     * Gets the value of the gustWindDirectionString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustWindDirectionString() {
        return gustWindDirectionString;
    }

    /**
     * Sets the value of the gustWindDirectionString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustWindDirectionString(String value) {
        this.gustWindDirectionString = value;
    }

    /**
     * Gets the value of the inputLocationUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputLocationUrl() {
        return inputLocationUrl;
    }

    /**
     * Sets the value of the inputLocationUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputLocationUrl(String value) {
        this.inputLocationUrl = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the obDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObDate() {
        return obDate;
    }

    /**
     * Sets the value of the obDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObDate(String value) {
        this.obDate = value;
    }

    /**
     * Gets the value of the obDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObDateTime() {
        return obDateTime;
    }

    /**
     * Sets the value of the obDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObDateTime(XMLGregorianCalendar value) {
        this.obDateTime = value;
    }

    /**
     * Gets the value of the rainToday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainToday() {
        return rainToday;
    }

    /**
     * Sets the value of the rainToday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainToday(String value) {
        this.rainToday = value;
    }

    /**
     * Gets the value of the rainUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainUnit() {
        return rainUnit;
    }

    /**
     * Sets the value of the rainUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainUnit(String value) {
        this.rainUnit = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the stationIDRequested property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationIDRequested() {
        return stationIDRequested;
    }

    /**
     * Sets the value of the stationIDRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationIDRequested(String value) {
        this.stationIDRequested = value;
    }

    /**
     * Gets the value of the stationIDReturned property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationIDReturned() {
        return stationIDReturned;
    }

    /**
     * Sets the value of the stationIDReturned property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationIDReturned(String value) {
        this.stationIDReturned = value;
    }

    /**
     * Gets the value of the stationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Sets the value of the stationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationName(String value) {
        this.stationName = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperature(String value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the temperatureUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    /**
     * Sets the value of the temperatureUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatureUnit(String value) {
        this.temperatureUnit = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the timeZoneOffset property.
     * 
     */
    public double getTimeZoneOffset() {
        return timeZoneOffset;
    }

    /**
     * Sets the value of the timeZoneOffset property.
     * 
     */
    public void setTimeZoneOffset(double value) {
        this.timeZoneOffset = value;
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

    /**
     * Gets the value of the windDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * Sets the value of the windDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDirection(String value) {
        this.windDirection = value;
    }

    /**
     * Gets the value of the windSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindSpeed(String value) {
        this.windSpeed = value;
    }

    /**
     * Gets the value of the windSpeedUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    /**
     * Sets the value of the windSpeedUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindSpeedUnit(String value) {
        this.windSpeedUnit = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

}
