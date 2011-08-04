/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.foi.nwtis.msimicic.konfiguracija.KonfiguracijaBaza;

/**
 *
 * @author Martina
 */
@WebService(serviceName = "WebServis")
public class WebServis {  
    /**
     * Lista zip kodova iz skupa MeteoPodataka
     *  
     */
    @WebMethod(operationName = "listaZipKodova")
    public Object[][] listaZipKodova() {
        String sql = "SELECT zip FROM meteo_podaci";
        Object[][] res = izvrsiUpit(sql); 
        return res;
    }
    
    /**
     * Lista zip kodova iz skupa MeteoPod
     * @param zip kod za pretrazivanje
     * @param broj redaka koje korisnik zeli
     * @return resultset sa vrijednostima pretraživanja
     */
    @WebMethod(operationName = "listaXZipRedaka")
    public Object[][] listaXZipRedaka(@WebParam(name = "brojRedaka") Integer limit, @WebParam(name = "zip") String zip){
        String sql = "SELECT * FROM meteo_podaci WHERE zip = "+ zip +" limit "+limit;
        Object[][] res = izvrsiUpit(sql); 
        return res;
    }
    
        /**
     * Lista podataka u vremenskom periodu
     * @param datum od kojeg se pretražuje
     * @param datum do kojeg se pretražuje
     * @return resultset sa vrijednostima pretraživanja
     */
    @WebMethod(operationName = "listaPodatakaInterval")
    public Object[][] listaPodatakaInterval(@WebParam(name = "datumOd") Integer datumOd, @WebParam(name = "datumDo") String datumDo){
        String sql = "SELECT * FROM meteo_podaci WHERE obDate BETWEEN "+ datumOd +" AND "+datumDo;
        Object[][] res = izvrsiUpit(sql); 
        return res;
    }
    
    public Object[][] izvrsiUpit(String sql) {
        try {
            String s = "D:\\faks\\diplomski\\IV semestar\\Dropbox\\projekt NWTIS\\msimicic_aplikacija_2\\konfiguracija.xml";
            KonfiguracijaBaza konf = new KonfiguracijaBaza(s);

            String url = konf.getServer_database();
            String dbName = konf.getAdmin_database();
            String driver = konf.getDriver_database();
            String userName = konf.getAdmin_username();
            String password = konf.getAdmin_password();
            Connection conn;
        
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
            
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            conn.close();
            stmt.close();
            
            ResultSetMetaData rsmd = res.getMetaData();
            
            res.last();
            int nR = res.getRow();
            int nC = rsmd.getColumnCount();
            res.beforeFirst();

            Object vrati[][] = new Object[nR][nC];
            
            for(int r=0; r<nR; res.next()){
                for(int c=0; c<nC; c++) {
                    vrati[r][c] = res.getObject(c);
                }
            }
            
           return vrati;
        }
           catch (Exception e) {
               System.out.println(e);
               return null;
           }
    }
}
