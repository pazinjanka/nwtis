
package net.wxbug.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LiveWeatherData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiveWeatherData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuxTemperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuxTemperatureRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrIcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DewPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Elevation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ElevationUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeelsLike" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="GustWindSpeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindSpeedUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindDirectionString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GustWindDirectionDegrees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Humidity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HumidityUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HumidityHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HumidityLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HumidityRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InputLocationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MoonPhase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MoonPhaseImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pressure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PressureUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PressureHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PressureLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PressureRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PressureRateUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Light" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LightRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndoorTemperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndoorTemperatureRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ObDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RainMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainRateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainRateUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainToday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RainYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationIDRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationIDReturned" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StationURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sunrise" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Sunset" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureRateUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemperatureUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZoneOffset" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="WebUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WetBulb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindDirection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindDirectionAvg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindDirectionDegrees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindSpeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindSpeedAvg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "LiveWeatherData", propOrder = {
    "auxTemperature",
    "auxTemperatureRate",
    "city",
    "cityCode",
    "country",
    "currIcon",
    "currDesc",
    "dewPoint",
    "elevation",
    "elevationUnit",
    "feelsLike",
    "gustTime",
    "gustWindSpeed",
    "gustWindSpeedUnit",
    "gustWindDirectionString",
    "gustWindDirectionDegrees",
    "humidity",
    "humidityUnit",
    "humidityHigh",
    "humidityLow",
    "humidityRate",
    "inputLocationUrl",
    "moonPhase",
    "moonPhaseImage",
    "pressure",
    "pressureUnit",
    "pressureHigh",
    "pressureLow",
    "pressureRate",
    "pressureRateUnit",
    "light",
    "lightRate",
    "indoorTemperature",
    "indoorTemperatureRate",
    "latitude",
    "longitude",
    "obDate",
    "obDateTime",
    "rainMonth",
    "rainRate",
    "rainRateMax",
    "rainRateUnit",
    "rainToday",
    "rainUnit",
    "rainYear",
    "state",
    "stationIDRequested",
    "stationIDReturned",
    "stationName",
    "stationURL",
    "sunrise",
    "sunset",
    "temperature",
    "temperatureHigh",
    "temperatureLow",
    "temperatureRate",
    "temperatureRateUnit",
    "temperatureUnit",
    "timeZone",
    "timeZoneOffset",
    "webUrl",
    "wetBulb",
    "windDirection",
    "windDirectionAvg",
    "windDirectionDegrees",
    "windSpeed",
    "windSpeedAvg",
    "windSpeedUnit",
    "zipCode"
})
public class LiveWeatherData {

    @XmlElement(name = "AuxTemperature")
    protected String auxTemperature;
    @XmlElement(name = "AuxTemperatureRate")
    protected String auxTemperatureRate;
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
    @XmlElement(name = "DewPoint")
    protected String dewPoint;
    @XmlElement(name = "Elevation")
    protected int elevation;
    @XmlElement(name = "ElevationUnit")
    protected String elevationUnit;
    @XmlElement(name = "FeelsLike")
    protected String feelsLike;
    @XmlElement(name = "GustTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar gustTime;
    @XmlElement(name = "GustWindSpeed")
    protected String gustWindSpeed;
    @XmlElement(name = "GustWindSpeedUnit")
    protected String gustWindSpeedUnit;
    @XmlElement(name = "GustWindDirectionString")
    protected String gustWindDirectionString;
    @XmlElement(name = "GustWindDirectionDegrees")
    protected String gustWindDirectionDegrees;
    @XmlElement(name = "Humidity")
    protected String humidity;
    @XmlElement(name = "HumidityUnit")
    protected String humidityUnit;
    @XmlElement(name = "HumidityHigh")
    protected String humidityHigh;
    @XmlElement(name = "HumidityLow")
    protected String humidityLow;
    @XmlElement(name = "HumidityRate")
    protected String humidityRate;
    @XmlElement(name = "InputLocationUrl")
    protected String inputLocationUrl;
    @XmlElement(name = "MoonPhase")
    protected int moonPhase;
    @XmlElement(name = "MoonPhaseImage")
    protected String moonPhaseImage;
    @XmlElement(name = "Pressure")
    protected String pressure;
    @XmlElement(name = "PressureUnit")
    protected String pressureUnit;
    @XmlElement(name = "PressureHigh")
    protected String pressureHigh;
    @XmlElement(name = "PressureLow")
    protected String pressureLow;
    @XmlElement(name = "PressureRate")
    protected String pressureRate;
    @XmlElement(name = "PressureRateUnit")
    protected String pressureRateUnit;
    @XmlElement(name = "Light")
    protected String light;
    @XmlElement(name = "LightRate")
    protected String lightRate;
    @XmlElement(name = "IndoorTemperature")
    protected String indoorTemperature;
    @XmlElement(name = "IndoorTemperatureRate")
    protected String indoorTemperatureRate;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "ObDate")
    protected String obDate;
    @XmlElement(name = "ObDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar obDateTime;
    @XmlElement(name = "RainMonth")
    protected String rainMonth;
    @XmlElement(name = "RainRate")
    protected String rainRate;
    @XmlElement(name = "RainRateMax")
    protected String rainRateMax;
    @XmlElement(name = "RainRateUnit")
    protected String rainRateUnit;
    @XmlElement(name = "RainToday")
    protected String rainToday;
    @XmlElement(name = "RainUnit")
    protected String rainUnit;
    @XmlElement(name = "RainYear")
    protected String rainYear;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "StationIDRequested")
    protected String stationIDRequested;
    @XmlElement(name = "StationIDReturned")
    protected String stationIDReturned;
    @XmlElement(name = "StationName")
    protected String stationName;
    @XmlElement(name = "StationURL")
    protected String stationURL;
    @XmlElement(name = "Sunrise", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sunrise;
    @XmlElement(name = "Sunset", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sunset;
    @XmlElement(name = "Temperature")
    protected String temperature;
    @XmlElement(name = "TemperatureHigh")
    protected String temperatureHigh;
    @XmlElement(name = "TemperatureLow")
    protected String temperatureLow;
    @XmlElement(name = "TemperatureRate")
    protected String temperatureRate;
    @XmlElement(name = "TemperatureRateUnit")
    protected String temperatureRateUnit;
    @XmlElement(name = "TemperatureUnit")
    protected String temperatureUnit;
    @XmlElement(name = "TimeZone")
    protected String timeZone;
    @XmlElement(name = "TimeZoneOffset")
    protected double timeZoneOffset;
    @XmlElement(name = "WebUrl")
    protected String webUrl;
    @XmlElement(name = "WetBulb")
    protected String wetBulb;
    @XmlElement(name = "WindDirection")
    protected String windDirection;
    @XmlElement(name = "WindDirectionAvg")
    protected String windDirectionAvg;
    @XmlElement(name = "WindDirectionDegrees")
    protected String windDirectionDegrees;
    @XmlElement(name = "WindSpeed")
    protected String windSpeed;
    @XmlElement(name = "WindSpeedAvg")
    protected String windSpeedAvg;
    @XmlElement(name = "WindSpeedUnit")
    protected String windSpeedUnit;
    @XmlElement(name = "ZipCode")
    protected String zipCode;

    /**
     * Gets the value of the auxTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuxTemperature() {
        return auxTemperature;
    }

    /**
     * Sets the value of the auxTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuxTemperature(String value) {
        this.auxTemperature = value;
    }

    /**
     * Gets the value of the auxTemperatureRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuxTemperatureRate() {
        return auxTemperatureRate;
    }

    /**
     * Sets the value of the auxTemperatureRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuxTemperatureRate(String value) {
        this.auxTemperatureRate = value;
    }

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
     * Gets the value of the dewPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDewPoint() {
        return dewPoint;
    }

    /**
     * Sets the value of the dewPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDewPoint(String value) {
        this.dewPoint = value;
    }

    /**
     * Gets the value of the elevation property.
     * 
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * Sets the value of the elevation property.
     * 
     */
    public void setElevation(int value) {
        this.elevation = value;
    }

    /**
     * Gets the value of the elevationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElevationUnit() {
        return elevationUnit;
    }

    /**
     * Sets the value of the elevationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElevationUnit(String value) {
        this.elevationUnit = value;
    }

    /**
     * Gets the value of the feelsLike property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeelsLike() {
        return feelsLike;
    }

    /**
     * Sets the value of the feelsLike property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeelsLike(String value) {
        this.feelsLike = value;
    }

    /**
     * Gets the value of the gustTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGustTime() {
        return gustTime;
    }

    /**
     * Sets the value of the gustTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGustTime(XMLGregorianCalendar value) {
        this.gustTime = value;
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
     * Gets the value of the gustWindDirectionDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustWindDirectionDegrees() {
        return gustWindDirectionDegrees;
    }

    /**
     * Sets the value of the gustWindDirectionDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustWindDirectionDegrees(String value) {
        this.gustWindDirectionDegrees = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidity(String value) {
        this.humidity = value;
    }

    /**
     * Gets the value of the humidityUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidityUnit() {
        return humidityUnit;
    }

    /**
     * Sets the value of the humidityUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidityUnit(String value) {
        this.humidityUnit = value;
    }

    /**
     * Gets the value of the humidityHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidityHigh() {
        return humidityHigh;
    }

    /**
     * Sets the value of the humidityHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidityHigh(String value) {
        this.humidityHigh = value;
    }

    /**
     * Gets the value of the humidityLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidityLow() {
        return humidityLow;
    }

    /**
     * Sets the value of the humidityLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidityLow(String value) {
        this.humidityLow = value;
    }

    /**
     * Gets the value of the humidityRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidityRate() {
        return humidityRate;
    }

    /**
     * Sets the value of the humidityRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidityRate(String value) {
        this.humidityRate = value;
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
     * Gets the value of the moonPhase property.
     * 
     */
    public int getMoonPhase() {
        return moonPhase;
    }

    /**
     * Sets the value of the moonPhase property.
     * 
     */
    public void setMoonPhase(int value) {
        this.moonPhase = value;
    }

    /**
     * Gets the value of the moonPhaseImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoonPhaseImage() {
        return moonPhaseImage;
    }

    /**
     * Sets the value of the moonPhaseImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoonPhaseImage(String value) {
        this.moonPhaseImage = value;
    }

    /**
     * Gets the value of the pressure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressure(String value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the pressureUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressureUnit() {
        return pressureUnit;
    }

    /**
     * Sets the value of the pressureUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressureUnit(String value) {
        this.pressureUnit = value;
    }

    /**
     * Gets the value of the pressureHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressureHigh() {
        return pressureHigh;
    }

    /**
     * Sets the value of the pressureHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressureHigh(String value) {
        this.pressureHigh = value;
    }

    /**
     * Gets the value of the pressureLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressureLow() {
        return pressureLow;
    }

    /**
     * Sets the value of the pressureLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressureLow(String value) {
        this.pressureLow = value;
    }

    /**
     * Gets the value of the pressureRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressureRate() {
        return pressureRate;
    }

    /**
     * Sets the value of the pressureRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressureRate(String value) {
        this.pressureRate = value;
    }

    /**
     * Gets the value of the pressureRateUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressureRateUnit() {
        return pressureRateUnit;
    }

    /**
     * Sets the value of the pressureRateUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressureRateUnit(String value) {
        this.pressureRateUnit = value;
    }

    /**
     * Gets the value of the light property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLight() {
        return light;
    }

    /**
     * Sets the value of the light property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLight(String value) {
        this.light = value;
    }

    /**
     * Gets the value of the lightRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLightRate() {
        return lightRate;
    }

    /**
     * Sets the value of the lightRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLightRate(String value) {
        this.lightRate = value;
    }

    /**
     * Gets the value of the indoorTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndoorTemperature() {
        return indoorTemperature;
    }

    /**
     * Sets the value of the indoorTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndoorTemperature(String value) {
        this.indoorTemperature = value;
    }

    /**
     * Gets the value of the indoorTemperatureRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndoorTemperatureRate() {
        return indoorTemperatureRate;
    }

    /**
     * Sets the value of the indoorTemperatureRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndoorTemperatureRate(String value) {
        this.indoorTemperatureRate = value;
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
     * Gets the value of the rainMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainMonth() {
        return rainMonth;
    }

    /**
     * Sets the value of the rainMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainMonth(String value) {
        this.rainMonth = value;
    }

    /**
     * Gets the value of the rainRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainRate() {
        return rainRate;
    }

    /**
     * Sets the value of the rainRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainRate(String value) {
        this.rainRate = value;
    }

    /**
     * Gets the value of the rainRateMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainRateMax() {
        return rainRateMax;
    }

    /**
     * Sets the value of the rainRateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainRateMax(String value) {
        this.rainRateMax = value;
    }

    /**
     * Gets the value of the rainRateUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainRateUnit() {
        return rainRateUnit;
    }

    /**
     * Sets the value of the rainRateUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainRateUnit(String value) {
        this.rainRateUnit = value;
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
     * Gets the value of the rainYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRainYear() {
        return rainYear;
    }

    /**
     * Sets the value of the rainYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRainYear(String value) {
        this.rainYear = value;
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
     * Gets the value of the stationURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationURL() {
        return stationURL;
    }

    /**
     * Sets the value of the stationURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationURL(String value) {
        this.stationURL = value;
    }

    /**
     * Gets the value of the sunrise property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSunrise() {
        return sunrise;
    }

    /**
     * Sets the value of the sunrise property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSunrise(XMLGregorianCalendar value) {
        this.sunrise = value;
    }

    /**
     * Gets the value of the sunset property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSunset() {
        return sunset;
    }

    /**
     * Sets the value of the sunset property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSunset(XMLGregorianCalendar value) {
        this.sunset = value;
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
     * Gets the value of the temperatureHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    /**
     * Sets the value of the temperatureHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatureHigh(String value) {
        this.temperatureHigh = value;
    }

    /**
     * Gets the value of the temperatureLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatureLow() {
        return temperatureLow;
    }

    /**
     * Sets the value of the temperatureLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatureLow(String value) {
        this.temperatureLow = value;
    }

    /**
     * Gets the value of the temperatureRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatureRate() {
        return temperatureRate;
    }

    /**
     * Sets the value of the temperatureRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatureRate(String value) {
        this.temperatureRate = value;
    }

    /**
     * Gets the value of the temperatureRateUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatureRateUnit() {
        return temperatureRateUnit;
    }

    /**
     * Sets the value of the temperatureRateUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatureRateUnit(String value) {
        this.temperatureRateUnit = value;
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
     * Gets the value of the wetBulb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWetBulb() {
        return wetBulb;
    }

    /**
     * Sets the value of the wetBulb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWetBulb(String value) {
        this.wetBulb = value;
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
     * Gets the value of the windDirectionAvg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDirectionAvg() {
        return windDirectionAvg;
    }

    /**
     * Sets the value of the windDirectionAvg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDirectionAvg(String value) {
        this.windDirectionAvg = value;
    }

    /**
     * Gets the value of the windDirectionDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDirectionDegrees() {
        return windDirectionDegrees;
    }

    /**
     * Sets the value of the windDirectionDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDirectionDegrees(String value) {
        this.windDirectionDegrees = value;
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
     * Gets the value of the windSpeedAvg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindSpeedAvg() {
        return windSpeedAvg;
    }

    /**
     * Sets the value of the windSpeedAvg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindSpeedAvg(String value) {
        this.windSpeedAvg = value;
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
