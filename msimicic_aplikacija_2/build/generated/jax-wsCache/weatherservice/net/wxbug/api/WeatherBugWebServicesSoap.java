
package net.wxbug.api;

import java.math.BigDecimal;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-740-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "WeatherBugWebServicesSoap", targetNamespace = "http://api.wxbug.net/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WeatherBugWebServicesSoap {


    /**
     * Returns US/World locations based on US zipcode or any search string.
     * 
     * @param searchString
     * @param aCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetLocationList", action = "http://api.wxbug.net/GetLocationList")
    @WebResult(name = "GetLocationListResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLocationList", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLocationList")
    @ResponseWrapper(localName = "GetLocationListResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLocationListResponse")
    public ArrayOfAnyType getLocationList(
        @WebParam(name = "searchString", targetNamespace = "http://api.wxbug.net/")
        String searchString,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Return the location data of US/world city that is nearest to the input Lat, Long.
     * 
     * @param aCode
     * @param longitude
     * @param latitude
     * @return
     *     returns net.wxbug.api.LocationUSWorldCityData
     */
    @WebMethod(operationName = "GetUSWorldCityByLatLong", action = "http://api.wxbug.net/GetUSWorldCityByLatLong")
    @WebResult(name = "GetUSWorldCityByLatLongResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetUSWorldCityByLatLong", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetUSWorldCityByLatLong")
    @ResponseWrapper(localName = "GetUSWorldCityByLatLongResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetUSWorldCityByLatLongResponse")
    public LocationUSWorldCityData getUSWorldCityByLatLong(
        @WebParam(name = "latitude", targetNamespace = "http://api.wxbug.net/")
        BigDecimal latitude,
        @WebParam(name = "longitude", targetNamespace = "http://api.wxbug.net/")
        BigDecimal longitude,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Returns station list (US or International) based on citycode.
     * 
     * @param unitType
     * @param aCode
     * @param cityCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetStationListByCityCode", action = "http://api.wxbug.net/GetStationListByCityCode")
    @WebResult(name = "GetStationListByCityCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetStationListByCityCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetStationListByCityCode")
    @ResponseWrapper(localName = "GetStationListByCityCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetStationListByCityCodeResponse")
    public ArrayOfAnyType getStationListByCityCode(
        @WebParam(name = "cityCode", targetNamespace = "http://api.wxbug.net/")
        String cityCode,
        @WebParam(name = "unitType", targetNamespace = "http://api.wxbug.net/")
        UnitType unitType,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Returns station list based on US zipcode.
     * 
     * @param unitType
     * @param zipCode
     * @param aCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetStationListByUSZipCode", action = "http://api.wxbug.net/GetStationListByUSZipCode")
    @WebResult(name = "GetStationListByUSZipCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetStationListByUSZipCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetStationListByUSZipCode")
    @ResponseWrapper(localName = "GetStationListByUSZipCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetStationListByUSZipCodeResponse")
    public ArrayOfAnyType getStationListByUSZipCode(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "unitType", targetNamespace = "http://api.wxbug.net/")
        UnitType unitType,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Compact Weather for international cities (including US cities) based on citycode.
     * 
     * @param aCode
     * @param cityCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveCompactWeatherData
     */
    @WebMethod(operationName = "GetLiveCompactWeatherByCityCode", action = "http://api.wxbug.net/GetLiveCompactWeatherByCityCode")
    @WebResult(name = "GetLiveCompactWeatherByCityCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveCompactWeatherByCityCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByCityCode")
    @ResponseWrapper(localName = "GetLiveCompactWeatherByCityCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByCityCodeResponse")
    public LiveCompactWeatherData getLiveCompactWeatherByCityCode(
        @WebParam(name = "cityCode", targetNamespace = "http://api.wxbug.net/")
        String cityCode,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Compact Weather for US cities based on zipcode.
     * 
     * @param zipCode
     * @param aCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveCompactWeatherData
     */
    @WebMethod(operationName = "GetLiveCompactWeatherByUSZipCode", action = "http://api.wxbug.net/GetLiveCompactWeatherByUSZipCode")
    @WebResult(name = "GetLiveCompactWeatherByUSZipCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveCompactWeatherByUSZipCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByUSZipCode")
    @ResponseWrapper(localName = "GetLiveCompactWeatherByUSZipCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByUSZipCodeResponse")
    public LiveCompactWeatherData getLiveCompactWeatherByUSZipCode(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Compact Weather for US and International locations based on StationID.
     * 
     * @param stationid
     * @param aCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveCompactWeatherData
     */
    @WebMethod(operationName = "GetLiveCompactWeatherByStationID", action = "http://api.wxbug.net/GetLiveCompactWeatherByStationID")
    @WebResult(name = "GetLiveCompactWeatherByStationIDResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveCompactWeatherByStationID", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByStationID")
    @ResponseWrapper(localName = "GetLiveCompactWeatherByStationIDResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveCompactWeatherByStationIDResponse")
    public LiveCompactWeatherData getLiveCompactWeatherByStationID(
        @WebParam(name = "stationid", targetNamespace = "http://api.wxbug.net/")
        String stationid,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Weather for international cities (including US cities) based on citycode.
     * 
     * @param aCode
     * @param cityCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveWeatherData
     */
    @WebMethod(operationName = "GetLiveWeatherByCityCode", action = "http://api.wxbug.net/GetLiveWeatherByCityCode")
    @WebResult(name = "GetLiveWeatherByCityCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveWeatherByCityCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByCityCode")
    @ResponseWrapper(localName = "GetLiveWeatherByCityCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByCityCodeResponse")
    public LiveWeatherData getLiveWeatherByCityCode(
        @WebParam(name = "cityCode", targetNamespace = "http://api.wxbug.net/")
        String cityCode,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Weather for US cities based on zipcode.
     * 
     * @param zipCode
     * @param aCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveWeatherData
     */
    @WebMethod(operationName = "GetLiveWeatherByUSZipCode", action = "http://api.wxbug.net/GetLiveWeatherByUSZipCode")
    @WebResult(name = "GetLiveWeatherByUSZipCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveWeatherByUSZipCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByUSZipCode")
    @ResponseWrapper(localName = "GetLiveWeatherByUSZipCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByUSZipCodeResponse")
    public LiveWeatherData getLiveWeatherByUSZipCode(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Live Weather for US and International locations based on StationID.
     * 
     * @param stationid
     * @param aCode
     * @param unittype
     * @return
     *     returns net.wxbug.api.LiveWeatherData
     */
    @WebMethod(operationName = "GetLiveWeatherByStationID", action = "http://api.wxbug.net/GetLiveWeatherByStationID")
    @WebResult(name = "GetLiveWeatherByStationIDResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetLiveWeatherByStationID", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByStationID")
    @ResponseWrapper(localName = "GetLiveWeatherByStationIDResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetLiveWeatherByStationIDResponse")
    public LiveWeatherData getLiveWeatherByStationID(
        @WebParam(name = "stationid", targetNamespace = "http://api.wxbug.net/")
        String stationid,
        @WebParam(name = "unittype", targetNamespace = "http://api.wxbug.net/")
        UnitType unittype,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get Severe Weather Alerts based on US zipcodes.
     * 
     * @param zipCode
     * @param aCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetAlertsDataList", action = "http://api.wxbug.net/GetAlertsDataList")
    @WebResult(name = "GetAlertsDataListResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetAlertsDataList", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetAlertsDataList")
    @ResponseWrapper(localName = "GetAlertsDataListResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetAlertsDataListResponse")
    public ArrayOfAnyType getAlertsDataList(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get Alerts location details based on US zipcode.
     * 
     * @param zipCode
     * @param aCode
     * @return
     *     returns net.wxbug.api.ApiAlertIssueData
     */
    @WebMethod(operationName = "GetAlertsIssueData", action = "http://api.wxbug.net/GetAlertsIssueData")
    @WebResult(name = "GetAlertsIssueDataResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetAlertsIssueData", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetAlertsIssueData")
    @ResponseWrapper(localName = "GetAlertsIssueDataResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetAlertsIssueDataResponse")
    public ApiAlertIssueData getAlertsIssueData(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get forecast location details based on citycode.
     * 
     * @param aCode
     * @param cityCode
     * @return
     *     returns net.wxbug.api.ApiForecastIssueData
     */
    @WebMethod(operationName = "GetForecastIssueDetailsByCityCode", action = "http://api.wxbug.net/GetForecastIssueDetailsByCityCode")
    @WebResult(name = "GetForecastIssueDetailsByCityCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetForecastIssueDetailsByCityCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastIssueDetailsByCityCode")
    @ResponseWrapper(localName = "GetForecastIssueDetailsByCityCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastIssueDetailsByCityCodeResponse")
    public ApiForecastIssueData getForecastIssueDetailsByCityCode(
        @WebParam(name = "cityCode", targetNamespace = "http://api.wxbug.net/")
        String cityCode,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get forecast location details based on US zipcode.
     * 
     * @param zipCode
     * @param aCode
     * @return
     *     returns net.wxbug.api.ApiForecastIssueData
     */
    @WebMethod(operationName = "GetForecastIssueDetailsByUSZipCode", action = "http://api.wxbug.net/GetForecastIssueDetailsByUSZipCode")
    @WebResult(name = "GetForecastIssueDetailsByUSZipCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetForecastIssueDetailsByUSZipCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastIssueDetailsByUSZipCode")
    @ResponseWrapper(localName = "GetForecastIssueDetailsByUSZipCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastIssueDetailsByUSZipCodeResponse")
    public ApiForecastIssueData getForecastIssueDetailsByUSZipCode(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get forecast based on citycode.
     * 
     * @param unitType
     * @param aCode
     * @param cityCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetForecastByCityCode", action = "http://api.wxbug.net/GetForecastByCityCode")
    @WebResult(name = "GetForecastByCityCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetForecastByCityCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastByCityCode")
    @ResponseWrapper(localName = "GetForecastByCityCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastByCityCodeResponse")
    public ArrayOfAnyType getForecastByCityCode(
        @WebParam(name = "cityCode", targetNamespace = "http://api.wxbug.net/")
        String cityCode,
        @WebParam(name = "unitType", targetNamespace = "http://api.wxbug.net/")
        UnitType unitType,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

    /**
     * Get forecast based on US zipcode.
     * 
     * @param unitType
     * @param zipCode
     * @param aCode
     * @return
     *     returns net.wxbug.api.ArrayOfAnyType
     */
    @WebMethod(operationName = "GetForecastByUSZipCode", action = "http://api.wxbug.net/GetForecastByUSZipCode")
    @WebResult(name = "GetForecastByUSZipCodeResult", targetNamespace = "http://api.wxbug.net/")
    @RequestWrapper(localName = "GetForecastByUSZipCode", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastByUSZipCode")
    @ResponseWrapper(localName = "GetForecastByUSZipCodeResponse", targetNamespace = "http://api.wxbug.net/", className = "net.wxbug.api.GetForecastByUSZipCodeResponse")
    public ArrayOfAnyType getForecastByUSZipCode(
        @WebParam(name = "zipCode", targetNamespace = "http://api.wxbug.net/")
        String zipCode,
        @WebParam(name = "unitType", targetNamespace = "http://api.wxbug.net/")
        UnitType unitType,
        @WebParam(name = "ACode", targetNamespace = "http://api.wxbug.net/")
        String aCode);

}
