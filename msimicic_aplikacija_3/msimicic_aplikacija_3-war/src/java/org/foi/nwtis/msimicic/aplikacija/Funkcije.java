/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.msimicic.aplikacija;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.foi.nwtis.msimicic.eB.Dnevnik;
import org.foi.nwtis.msimicic.eB.Korisnici;
import org.foi.nwtis.msimicic.eB.ObradjenePoruke;
import org.foi.nwtis.msimicic.eB.PoslanePoruke;
import org.foi.nwtis.msimicic.eB.Putovanja;
import org.foi.nwtis.msimicic.eB.Zahtjevi;
import org.foi.nwtis.msimicic.meteo.ArrayOfAnyType;
import org.foi.nwtis.msimicic.meteo.LiveWeatherData;
import org.foi.nwtis.msimicic.meteo.UnitType;
import org.foi.nwtis.msimicic.meteo.WeatherBugWebServices;
import org.foi.nwtis.msimicic.meteo.WeatherBugWebServicesSoap;
import org.foi.nwtis.msimicic.sB.DnevnikFacadeRemote;
import org.foi.nwtis.msimicic.sB.KorisniciFacadeRemote;
import org.foi.nwtis.msimicic.sB.ObradjenePorukeFacadeRemote;
import org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote;
import org.foi.nwtis.msimicic.sB.PutovanjaFacadeRemote;
import org.foi.nwtis.msimicic.sB.ZahtjeviFacadeRemote;

/**
 *
 * @author Martina
 */
@Stateless
@LocalBean
public class Funkcije implements Serializable {

    KorisniciFacadeRemote kfr = getKorisniciFacadeRemote();
    PoslanePorukeFacadeRemote ppfr = getPoslanePorukeFacadeRemote();
    ObradjenePorukeFacadeRemote opfr = getObradjenePorukeFacadeRemote();
    PutovanjaFacadeRemote pfr = getPutovanjaFacadeRemote();
    ZahtjeviFacadeRemote zfr = getZahtjeviFacadeRemote();
    DnevnikFacadeRemote dfr = getDnevnikFacadeRemote();

    public Funkcije() {
    }

    public String newUser(String kor_ime, String ime, String prezime, String lozinka, String email) {
        try {
            Korisnici korisnik = new Korisnici(kor_ime, ime, prezime, lozinka, email, 1);
            kfr.create(korisnik);
        }
        catch (Exception e) {
            System.out.println("Korisnik nije kreiran!"+e);
            return "Korisnik nije kreiran, došlo je do pogreške";
        }
        return "Korisnik uspješno keriran.";
    }

        public boolean user(String [] parametri) {
            List<Korisnici> prijava;
            if (parametri[2].equalsIgnoreCase("nwtis@localhost")){
                prijava = kfr.prijavaKorisnika(parametri[0], parametri[1], "pero@foi.hr");
            } else {
                prijava= kfr.prijavaKorisnika(parametri[0], parametri[1], parametri[2]);
            }
            if (prijava.size() != 1) {
                return Boolean.FALSE;
            }
            else {
                System.out.println("Korisnik prijavljen");
                return Boolean.TRUE;
            }
    }

    public void pohraniObradjenuPoruku(String primatelj, String posiljatelj, String naslov, String sadrzaj, String vrsta, java.lang.Character ispravna){
        try {
            ObradjenePoruke op = new ObradjenePoruke();
            op.setPrimatelj(primatelj);
            op.setPosiljatelj(posiljatelj);
            java.util.Date today = new java.util.Date();
            java.sql.Date datum = new java.sql.Date(today.getTime());
            op.setDatum(datum);
            op.setNaslov(naslov);
            op.setSadrzaj(sadrzaj);
            op.setVrsta(vrsta);
            op.setIspravna(ispravna);
            opfr.create(op);
            System.out.println("Pohranjena poruka");
        }
        catch (Exception e) {
            System.out.println("Pisi kuci propalo: "+ e);
        }
    }

    public void pohraniPoslanuPoruku(String posiljatelj, Date date, String naslov, String sadrzaj) {
        try {
            PoslanePoruke pp = new PoslanePoruke();
            pp.setPosiljatelj(posiljatelj);
            pp.setDatum(date);
            pp.setNaslov(naslov);
            pp.setSadrzaj(sadrzaj);
            ppfr.create(pp);
            System.out.println("Spremljena poruka");
        }
        catch (Exception e){
            System.out.println("Poslana poruka nije pohranjena" + e);
        }
    }

    public String data(String [] parametri) {
        String response;
        try {
            List <Putovanja> putovanja = pfr.dohvatiGradoveZaKorisnika(parametri[0]);
            String APICODE = "A6458871574";
            WeatherBugWebServices service = new WeatherBugWebServices();
            WeatherBugWebServicesSoap port = service.getWeatherBugWebServicesSoap();
            LiveWeatherData podaci;
            Iterator itr = putovanja.iterator();
            response = "Vaš zahtjev za meteorološkim podacima uspješno je zaprimljen. Rezultate možete pročitati u nastavku. \n ";
            while (itr.hasNext()) {
                Putovanja p = (Putovanja) itr.next();
                podaci = port.getLiveWeatherByCityCode(p.getGradovi(), UnitType.ENGLISH, APICODE);
                response.concat("Kod grada: "+p.getGradovi()+", grad: "+podaci.getCity()+", temperatura: "+podaci.getTemperature()+", vlažnost zraka: "+podaci.getHumidity()+"\n");
        }
        return response;
        } catch (Exception e){
            System.out.println("Data() nešto je pošlo po krivom"+e);
            response = "Data() nešto je pošlo po krivom";
            return response;
        }
    }
    
    public String dataParametri(String[] parametri) {
        String response;
        try {
            String APICODE = "A6458871574";
            WeatherBugWebServices service = new WeatherBugWebServices();
            WeatherBugWebServicesSoap port = service.getWeatherBugWebServicesSoap();
            ArrayOfAnyType podaci;
            response = "Vaš zahtjev za meteorološkim podacima uspješno je zaprimljen. Rezultate možete pročitati u nastavku. \n ";
            podaci = port.getForecastByCityCode(parametri[0], UnitType.METRIC, APICODE);
            response.concat("Kod grada: "+podaci+"\n");
            Zahtjevi zahtjev = new Zahtjevi();
            zahtjev.setBrojDana(Integer.parseInt(parametri[1]));
            zahtjev.setGradCode(Integer.parseInt(parametri[0]));
            zahtjev.setNaredba("data");
            java.util.Date today = new java.util.Date();
            java.sql.Date datum = new java.sql.Date(today.getTime());
            zahtjev.setDatumZahtjeva(datum);
            Korisnici korisnik = kfr.find(parametri[2]);
            zahtjev.setKorisnici(korisnik);
            zahtjev.setPutaPoslano(1);
            zahtjev.setZavrseno("0");
            zfr.create(zahtjev);
            return response;
        } catch (Exception e){
            System.out.println("DataParametri() nešto je pošlo po krivom"+e);
            response = "DataParametri() nešto je pošlo po krivom";
            return response;
        }
    }

    public void dataSaDatumima(String[] datumi, String[] parametri) throws ParseException {
        try {
            List <Putovanja> putovanja = pfr.dohvatiGradoveZaKorisnika(parametri[0]);
            Iterator itr = putovanja.iterator();
            while (itr.hasNext()){
                Putovanja p = (Putovanja) itr.next();
                Zahtjevi zahtjev = new Zahtjevi();
                zahtjev.setGradCode(Integer.parseInt(p.getGradovi()));
                zahtjev.setNaredba("data(period)");
                java.util.Date today = new java.util.Date();
                java.sql.Date datum = new java.sql.Date(today.getTime());
                zahtjev.setDatumZahtjeva(datum);
                Korisnici korisnik = kfr.find(parametri[0]);
                zahtjev.setKorisnici(korisnik);
                zahtjev.setPutaPoslano(1);
                zahtjev.setZavrseno("0");
                DateFormat formatter ;
                Date date1;
                Date date2;
                formatter = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
                date1 = (Date)formatter.parse(datumi[0]);
                zahtjev.setDatumdo(date1);
                date2 = (Date)formatter.parse(datumi[1]);
                zahtjev.setDatumdo(date2);
                zfr.create(zahtjev);
            }
        } catch (Exception e){
            System.out.println("DataSaDatumima() nešto je pošlo po krivom"+e);
        }
    }


    public boolean  forecast(String[] parametri) {
        try {
            Zahtjevi zahtjev = new Zahtjevi();
            zahtjev.setBrojDana(Integer.parseInt(parametri[1]));
            zahtjev.setGradCode(Integer.parseInt(parametri[0]));
            zahtjev.setNaredba("forecast");
            java.util.Date today = new java.util.Date();
            java.sql.Date datum = new java.sql.Date(today.getTime());
            zahtjev.setDatumZahtjeva(datum);
            Korisnici korisnik = kfr.find(parametri[2]);
            zahtjev.setKorisnici(korisnik);
            zahtjev.setPutaPoslano(0);
            zahtjev.setZavrseno("0");
            zfr.create(zahtjev);
            return Boolean.TRUE;
        } catch (Exception e){
            System.out.println("DataSaDatumima() nešto je pošlo po krivom"+e);
            return Boolean.FALSE;
        }
    }

    public String stopForecast(String[] parametri) {
        String response;
        try {
            Zahtjevi zahtjev = zfr.findByCityCodeAndUser(Integer.parseInt(parametri[0]), parametri[1]);
            if (zahtjev != null){
                zahtjev.setZavrseno("1");
                zfr.edit(zahtjev);
                System.out.println("Uspješno zaustavljeno, StopForecast");
                response = "Pretplata uspješno ukinuta. ";
            }
             else {
                System.out.println("Nema zahtjeva nema se što zaustaviti. ");
                response = "Tražena retplata ne postoji. ";
             }
        } catch (Exception e) {
            System.out.println("Stop Forecast nije uspjelo"+e);
            response = "Nije uspjelo. Razlog nepoznat.";
        }
        return response;
    }

    public void dnevnik(Date datum1, Date datum2, Integer procitane, int nwtis, Integer ispravne) {
        try {
            Dnevnik dnevnik = new Dnevnik();
            dnevnik.setDatumod(datum1);
            dnevnik.setDatumdo(datum2);
            dnevnik.setBrojprocitanih(procitane);
            dnevnik.setBrojnwtis(nwtis);
            dnevnik.setBrojispravnih(ispravne);
            dfr.create(dnevnik);
        } catch (Exception e) {
            System.out.println("Neuspješno upisivanje u dnevnik"+e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="instanciranje Facada Remote">
    private PoslanePorukeFacadeRemote getPoslanePorukeFacadeRemote() {
    /*
    org.foi.nwtis.msimicic.eB.PoslanePoruke actually got transformed
    (Portable)
    java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote,
    java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeLocal
    (Non-portable)
    org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote#org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote
    org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote
    */
        try {
            Context c = new InitialContext();
            return (PoslanePorukeFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PoslanePorukeFacade!org.foi.nwtis.msimicic.sB.PoslanePorukeFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod PoslanePorukeFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private KorisniciFacadeRemote getKorisniciFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (KorisniciFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/KorisniciFacade!org.foi.nwtis.msimicic.sB.KorisniciFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod KorisniciFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private ObradjenePorukeFacadeRemote getObradjenePorukeFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (ObradjenePorukeFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/ObradjenePorukeFacade!org.foi.nwtis.msimicic.sB.ObradjenePorukeFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod ObradjenePorukeFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private PutovanjaFacadeRemote getPutovanjaFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (PutovanjaFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/PutovanjaFacade!org.foi.nwtis.msimicic.sB.PutovanjaFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod PutovanjaFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private ZahtjeviFacadeRemote getZahtjeviFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (ZahtjeviFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/ZahtjeviFacade!org.foi.nwtis.msimicic.sB.ZahtjeviFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod ZahtjeviFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }

    private DnevnikFacadeRemote getDnevnikFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (DnevnikFacadeRemote) c.lookup("java:global/msimicic_aplikacija_3/msimicic_aplikacija_3-ejb/DnevnikFacade!org.foi.nwtis.msimicic.sB.DnevnikFacadeRemote");
        } catch (NamingException ne) {
           System.out.println("Greška kod DnevnikFacadeRemote" + ne);
            throw new RuntimeException(ne);
        }
    }
    
    // </editor-fold>
}
