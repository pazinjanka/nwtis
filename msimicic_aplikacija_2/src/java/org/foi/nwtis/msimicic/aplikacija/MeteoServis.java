/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.datatype.XMLGregorianCalendar;
import net.wxbug.api.LiveWeatherData;
import net.wxbug.api.UnitType;
import net.wxbug.api.WeatherBugWebServices;
import net.wxbug.api.WeatherBugWebServicesSoap;
import org.foi.nwtis.msimicic.konfiguracija.KonfiguracijaBaza;

/**
 *
 * @author Martina
 */
public class MeteoServis extends Thread {
    public Integer interval;
    public LiveWeatherData podaci;  

    /**
     * 
     */
    public MeteoServis() {
    	super();
    }

    /**
     * Pokretanje dretve koja spava u odredenom intervalu
     * Interval definiran u konfiguracija.xml
     */
    @Override
    public void run() {
        while (true) {
            try {
                getData();
                sleep(interval * 1000);
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
    }

    /**
     * Dohvacanje web podataka sa WeatherBug servisa i spremanje u baz
     *
     */
    public void getData() {
        String APICODE = "A6458871574";
        WeatherBugWebServices service = new WeatherBugWebServices();
        WeatherBugWebServicesSoap port = service.getWeatherBugWebServicesSoap();
        
        try {
                    String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
                    KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

                    Connection conn = null;
                    String url = konf.getServer_database();
                    String dbName = konf.getAdmin_database();
                    String driver = konf.getDriver_database();
                    String userName = konf.getAdmin_username();
                    String password = konf.getAdmin_password();
                    interval = konf.getInterval();

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url+dbName,userName,password);
                    
                    PreparedStatement stmt = conn.prepareStatement("SELECT zip FROM mycities order by rand() limit 7");
                    ResultSet result = stmt.executeQuery();
     
                    while (result.next()) {
                        Statement stmt1 = conn.createStatement();
                        String zip = result.getString(1);
                        podaci = port.getLiveWeatherByUSZipCode(zip, UnitType.METRIC, APICODE);
                        if (podaci != null) {             

                            // <editor-fold defaultstate="collapsed" desc="data definition">
                        String  currIcon = podaci.getCurrIcon();
                        String  currDesc = podaci.getCurrDesc();
                        String  gustWindSpeed = podaci.getGustWindSpeed();
                        String	gustWindSpeedUnit = podaci.getGustWindSpeedUnit();
                        String	gustWindDirectionString = podaci.getWindDirection();
                        String	obDate = podaci.getObDate();
                        XMLGregorianCalendar obDateTime = podaci.getObDateTime();
                        String	rainToday = podaci.getRainToday();
                        String	rainUnit = podaci.getRainUnit();
                        String	state = podaci.getState();
                        String	stationIDRequested = podaci.getStationIDRequested();
                        String	stationIDReturned = podaci.getStationIDReturned();
                        String	stationName = podaci.getStationName();
                        String	temperature = podaci.getTemperature();
                        String	temperatureUnit = podaci.getTemperatureUnit();
                        String	timeZone = podaci.getTimeZone();
                        Double	timeZoneOffset = podaci.getTimeZoneOffset();
                        String	windDirection = podaci.getWindDirection();
                        String	windSpeed = podaci.getWindSpeed();
                        String	windSpeedUnit = podaci.getWindSpeedUnit();
                        String	city = podaci.getCity();
                        String	county = podaci.getCountry();
        // </editor-fold>        

                            String sql = "INSERT into meteo_podaci (currIcon, currDesc, gustWindSpeed, gustWindSpeedUnit, "
                                + "gustWindDirectionString, obDate, obDateTime, rainToday, "
                                + "rainUnit, state, stationIDRequested, stationIDReturned, stationName, "
                                + "temperature, temperatureUnit, timeZone, timeZoneOffset, windDirection, "
                                + "windSpeed, windSpeedUnit, city, county, zip) values ('"+currIcon+"', '"+currDesc+"', '"+gustWindSpeed+"', '"+gustWindSpeedUnit+"', '"
                                + gustWindDirectionString+"','"+obDate+"', '"+obDateTime+"', '"+rainToday+"', '"
                                + rainUnit+"', '"+state+"', '"+stationIDRequested+"', '"+stationIDReturned+"', '"+stationName+"', '"
                                + temperature+"', '"+temperatureUnit+"', '"+timeZone+"', '"+timeZoneOffset+"', '"+windDirection+"', '"
                                + windSpeed+"', '"+windSpeedUnit+"', '"+city+"', '"+county+"', '"+zip+"');";
                            
                            stmt1.executeUpdate(sql);
                            stmt1.close();
                            System.out.println("Podaci preuzeti ");
                        }
                    }
                    conn.close();
                    stmt.close();
                } 
                catch (Exception e) {
                    System.out.println(e);
                    return;
                }
    }
    
    public LiveWeatherData getPodaci(){
        return podaci;
    }
    
    public Integer getInterval(){
        return interval;
    }
}