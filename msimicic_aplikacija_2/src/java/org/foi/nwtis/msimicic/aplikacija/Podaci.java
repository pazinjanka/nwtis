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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;
import org.foi.nwtis.msimicic.konfiguracija.KonfiguracijaBaza;

/**
 *
 * @author Martina
 */
public class Podaci {
    public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    // <editor-fold defaultstate="collapsed" desc="data definition">
    private String currIcon;
    private String currDesc;
    private String gustWindSpeed;
    private String gustWindSpeedUnit;
    private String gustWindDirectionString;
    private String obDate;
    private XMLGregorianCalendar obDateTime;
    private String rainToday;
    private String rainUnit;
    private String state;
    private String stationIDRequested; 
    private String stationIDReturned;
    private String stationName;
    private String temperature;
    private String temperatureUnit;
    private String timeZone;
    private Double timeZoneOffset;
    private String windDirection;
    private String windSpeed;
    private String windSpeedUnit;
    private String city;
    private String county;
    private String zip;
        // </editor-fold>        


    public Podaci(String currIcon, String currDesc, String gustWindSpeed, String gustWindSpeedUnit, 
            String gustWindDirectionString, String obDate, 
            String rainToday, String rainUnit, String state, String stationIDRequested,
            String stationIDReturned, String stationName, String temperature,
            String temperatureUnit, String timeZone, Double timeZoneOffset, String windDirection, 
            String windSpeed, String windSpeedUnit, String city, String county, String zip) {
		this.currIcon = currIcon;
		this.currDesc = currDesc;
		this.gustWindSpeed = gustWindSpeed;
		this.gustWindSpeedUnit = gustWindSpeedUnit;
		this.gustWindDirectionString = gustWindDirectionString;
		this.obDate = obDate;
		this.rainToday = rainToday;
		this.rainUnit = rainUnit;
                this.state = state;
                this.stationIDRequested = stationIDRequested;
                this.stationIDReturned = stationIDReturned;
                this.stationName = stationName;
                this.temperature = temperature;
                this.temperatureUnit = temperatureUnit;
                this.timeZone = timeZone;
                this.timeZoneOffset = timeZoneOffset;
                this.windDirection = windDirection;
                this.windSpeed = windSpeed;
                this.windSpeedUnit = windSpeedUnit;
                this.city = city;
                this.county = county;
                this.zip = zip;
	}

    // <editor-fold defaultstate="collapsed" desc="get i set">
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCountry(String county) {
		this.county = county;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getWindSpeedUnit() {
		return windSpeedUnit;
	}

	public void setWindSpeedUnit(String windSpeedUnit) {
		this.windSpeedUnit = windSpeedUnit;
	}
        
        public String getWindSpeed(){
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
        
        public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
        
        public Double getTimeZoneOffset() {
		return timeZoneOffset;
	}

	public void setTimeZoneOffset(Double timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}
        
        public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
        
        public String getTemperatureUnit() {
		return temperatureUnit;
	}

	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
        
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
                
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
                
	public String getStationIDReturned() {
		return stationIDReturned;
	}

	public void setStationIDReturned(String stationIDReturned) {
		this.stationIDReturned = stationIDReturned;
	}
                
	public String getStationIDRequested() {
		return stationIDRequested;
	}

	public void setStationIDRequested(String stationIDRequested) {
		this.stationIDRequested = stationIDRequested;
	}
        
        public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
        
	public String getRainUnit() {
		return rainUnit;
	}

	public void setRainUnit(String rainUnit) {
		this.rainUnit = rainUnit;
	}
                
	public String getRainToday() {
		return rainToday;
	}

	public void setRainToday(String rainToday) {
		this.rainToday = rainToday;
	}
        
        public XMLGregorianCalendar getObDateTime() {
		return obDateTime;
	}

	public void setObDateTime(XMLGregorianCalendar obDateTime) {
		this.obDateTime = obDateTime;
	}
        
        public String getObDate() {
		return obDate;
	}

	public void setObDate(String obDate) {
		this.obDate = obDate;
	}
        
        public String getGustWindSpeed() {
		return gustWindSpeed;
	}

	public void setGustWindSpeed(String gustWindSpeed) {
		this.gustWindSpeed = gustWindSpeed;
	}
        
        public String getGustWindSpeedUnit() {
		return gustWindSpeedUnit;
	}

	public void setGustWindSpeedUnit(String gustWindSpeedUnit) {
		this.gustWindSpeedUnit = gustWindSpeedUnit;
	}
        
        public String getGustWindDirectionString() {
		return gustWindDirectionString;
	}

	public void setGustWindDirectionString(String gustWindDirectionString) {
		this.gustWindDirectionString = gustWindDirectionString;
	}
        
        
        public String getCurrDesc() {
		return currDesc;
	}

	public void setCurrDesc(String currDesc) {
		this.currDesc = currDesc;
	}
 
         
        public String getCurrIcon() {
		return currIcon;
	}

	public void setCurrIcon(String currIcon) {
		this.currIcon = currIcon;
	}
        
        // </editor-fold>  
        
	/**
	 * Pretraživanje meteoroloških podataka po zip kodu
	 * @param zip kod koji se pretražuje
	 * @return vraća array sa podacima
	 */
	public static ArrayList getDataByZip(String zip) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                Calendar date = Calendar.getInstance();    
                String dateOd = sdf.format(date.getTime());
		ArrayList data = new ArrayList();
		ResultSet res = null;
		try{
                    String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
                    KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

                    Connection conn = null;
                    String url = konf.getServer_database();
                    String dbName = konf.getAdmin_database();
                    String driver = konf.getDriver_database();
                    String userName = konf.getAdmin_username();
                    String password = konf.getAdmin_password();

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url+dbName,userName,password);
			
                    String sql = "SELECT * FROM meteo_podaci WHERE zip='"+zip+"'";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    res = stmt.executeQuery();

                    while (res.next()) {
                        data.add(new Podaci(res.getString("currIcon"),res.getString("currDesc"), 
                                res.getString("gustWindSpeed"), res.getString("gustWindSpeedUnit"),
                                res.getString("gustWindDirectionString"), res.getString("obDate"),
                                res.getString("rainToday"), res.getString("rainUnit"), res.getString("state"),
                                res.getString("stationName"), res.getString("stationIDRequested"), res.getString("stationIDReturned"), 
                                res.getString("temperature"),res.getString("temperatureUnit"), res.getString("timeZone"), 
                                res.getDouble("timeZoneOffset"), res.getString("windDirection"), res.getString("windSpeed"),
                                res.getString("city"), res.getString("windSpeedUnit"), res.getString("county"), 
                                res.getString("county")));
                    }
                    
                    date = Calendar.getInstance();
                    String dateDo = sdf.format(date.getTime());
                    String tip = "Pretraživanje po zip kodu";
                    String sql1 = "INSERT INTO zahtjevi (tip, dateOd, dateDo) VALUES ('"+tip+"', '"+dateOd+"', '"+dateDo+"');";
                    Statement stmt1 = conn.prepareStatement(sql1);
                    stmt1.executeUpdate(sql1);
                    
                    stmt.close();
                    stmt1.close();
                    conn.close();
		} catch(Exception e){
                    System.out.println(e);
		}
                
                return data;
	}

	/**
	 * Pretraživanje meteoroloških podataka  po zip kodu u određenom vremenskom intervalu
	 * @param zip kod koji se pretražuje u bazi
	 * @param datumOd vrijeme u kojem se pretražuje
	 * @param datumDo vrijeme do kojeg se pretražuje
	 * @return vraća array sa podacima
	 */
	public static ArrayList getDataInterval(String zip, String datumOd, String datumDo) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                Calendar date = Calendar.getInstance();  
                String dateOd = sdf.format(date.getTime());
		ArrayList data = new ArrayList();
		ResultSet res = null;
		try{
                    String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
                    KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

                    Connection conn = null;
                    String url = konf.getServer_database();
                    String dbName = konf.getAdmin_database();
                    String driver = konf.getDriver_database();
                    String userName = konf.getAdmin_username();
                    String password = konf.getAdmin_password();

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url+dbName,userName,password);
			
                    String sql = "SELECT * FROM meteo_podaci WHERE zip='"+zip+"' AND time>='"+datumOd+"' AND time<='"+datumDo+"'";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    res = stmt.executeQuery();
			
                    while (res.next()) {
			data.add(new Podaci(res.getString("currIcon"),res.getString("currDesc"), 
                                res.getString("gustWindSpeed"), res.getString("gustWindSpeedUnit"),
                                res.getString("gustWindDirectionString"), res.getString("obDate"),
                                res.getString("rainToday"), res.getString("rainUnit"), res.getString("state"),
                                res.getString("stationName"), res.getString("stationIDRequested"), res.getString("stationIDReturned"), 
                                res.getString("temperature"),res.getString("temperatureUnit"), res.getString("timeZone"), 
                                res.getDouble("timeZoneOffset"), res.getString("windDirection"), res.getString("windSpeed"),
                                res.getString("city"), res.getString("windSpeedUnit"), res.getString("county"), 
                                res.getString("county")));
                    }

                    date = Calendar.getInstance();
                    String dateDo = sdf.format(date.getTime());
                    String tip = "Pretraživanje po zip kodu";
                    String sql1 = "INSERT INTO zahtjevi (tip, dateOd, dateDo) VALUES ('"+tip+"', '"+dateOd+"', '"+dateDo+"');";
                    Statement stmt1 = conn.prepareStatement(sql1);
                    stmt1.executeUpdate(sql1);
                    
                    stmt.close();
                    stmt1.close();
                    conn.close();
                    
		} catch(Exception e){
                    System.out.println(e);
		}
		return data;
	}

	/**
	 * Vraća sve meteorološke podatke iz baze
	 * @return vraća array sa podacima
	 */
	public static ArrayList getAllData() {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                Calendar date = Calendar.getInstance();   
                String dateOd = sdf.format(date.getTime());
		ArrayList data = new ArrayList();
		ResultSet res = null;
		try{
                    String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
                    KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

                    Connection conn = null;
                    String url = konf.getServer_database();
                    String dbName = konf.getAdmin_database();
                    String driver = konf.getDriver_database();
                    String userName = konf.getAdmin_username();
                    String password = konf.getAdmin_password();

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url+dbName,userName,password);
			
                    String sql = "SELECT * FROM meteo_podaci";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    res = stmt.executeQuery();
                    
                    while (res.next()) {
			data.add(new Podaci(res.getString("currIcon"),res.getString("currDesc"), 
                                res.getString("gustWindSpeed"), res.getString("gustWindSpeedUnit"),
                                res.getString("gustWindDirectionString"), res.getString("obDate"),
                                res.getString("rainToday"), res.getString("rainUnit"), res.getString("state"),
                                res.getString("stationName"), res.getString("stationIDRequested"), res.getString("stationIDReturned"), 
                                res.getString("temperature"),res.getString("temperatureUnit"), res.getString("timeZone"), 
                                res.getDouble("timeZoneOffset"), res.getString("windDirection"), res.getString("windSpeed"),
                                res.getString("city"), res.getString("windSpeedUnit"), res.getString("county"), 
                                res.getString("county")));
                    }
                    date = Calendar.getInstance();
                    String dateDo = sdf.format(date.getTime());
                    String tip = "Pretraživanje po zip kodu";
                    String sql1 = "INSERT INTO zahtjevi (tip, dateOd, dateDo) VALUES ('"+tip+"', '"+dateOd+"', '"+dateDo+"');";
                    Statement stmt1 = conn.prepareStatement(sql1);
                    stmt1.executeUpdate(sql1);
                    
                    stmt.close();
                    stmt1.close();
                    conn.close();
                } catch(Exception e){
                    System.out.println(e);
		} 
		return data;
	}

	/**
	 * Metoda za dobivanje svih zip kodova
	 * @return vraća array zip kodova
	 */
	public static ArrayList getZipCodes() {
		ArrayList data = new ArrayList();
		ResultSet res = null;
		try{
                    String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
                    KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

                    Connection conn = null;
                    String url = konf.getServer_database();
                    String dbName = konf.getAdmin_database();
                    String driver = konf.getDriver_database();
                    String userName = konf.getAdmin_username();
                    String password = konf.getAdmin_password();

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url+dbName,userName,password);
			
                    String sql = "SELECT * FROM mycities";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    res = stmt.executeQuery();

                    while (res.next()) {
                        data.add(res.getString("zip"));
                    }

		} catch(Exception e){
			System.out.println(e);
		}
		return data;
	}

        /**
         * Prilagođavanje datuma
         * @param datum
         * @return 
         */
	public static String formatDate(String date){
		Date date1 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date dateStr = formatter.parse(date);
			String formattedDate = formatter.format(dateStr);
			date1 = formatter.parse(formattedDate);
		} catch (Exception e){
                    System.out.println(e);
                }

		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date1);
	}
}
