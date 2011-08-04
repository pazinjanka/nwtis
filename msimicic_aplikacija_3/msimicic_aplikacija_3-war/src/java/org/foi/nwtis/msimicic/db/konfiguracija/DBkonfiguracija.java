/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.db.konfiguracija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Martina
 */
public class DBkonfiguracija {
  protected Properties props;
  protected String server_database;
  protected String driver_database;
  protected String admin_username;
  protected String admin_password;
  protected String admin_database;
  protected String user_username;
  protected String user_password;
  protected String user_database;
  protected String smtp;
  protected String pop3;
  protected String pop3_username;
  protected String pop3_password;
  protected String interval;

  public DBkonfiguracija(String naziv) throws FileNotFoundException, IOException {
    FileInputStream fis = new FileInputStream(naziv);
    props.loadFromXML(fis);
    props.list(System.out);

    this.server_database = props.getProperty("server.database");
    this.admin_username = props.getProperty("admin.username");
    this.admin_password = props.getProperty("admin.password");
    this.admin_database = props.getProperty("admin.database");
    this.user_username = props.getProperty("user.username");
    this.user_password = props.getProperty("user.password");
    this.user_database = props.getProperty("user.database");
    this.driver_database = props.getProperty("driver.database");
    this.smtp = props.getProperty("smtp");
    this.pop3 = props.getProperty("pop3");
    this.pop3_username = props.getProperty("pop3_username");
    this.pop3_password = props.getProperty("pop3_password");
    this.interval = props.getProperty("interval");
  }

  public String getInterval() {
    return interval;
  }

  public void setInterval(String interval) {
    this.interval = interval;
  }

  public String getAdmin_database() {
    return admin_database;
  }

  public void setAdmin_database(String admin_database) {
    this.admin_database = admin_database;
  }

  public String getAdmin_password() {
    return admin_password;
  }

  public void setAdmin_password(String admin_password) {
    this.admin_password = admin_password;
  }

  public String getAdmin_username() {
    return admin_username;
  }

  public void setAdmin_username(String admin_username) {
    this.admin_username = admin_username;
  }

  public String getDriver_database() {
    return driver_database;
  }

  public void setDriver_database(String driver_database) {
    this.driver_database = driver_database;
  }

  public String getPop3() {
    return pop3;
  }

  public void setPop3(String pop3) {
    this.pop3 = pop3;
  }

  public String getPop3_password() {
    return pop3_password;
  }

  public void setPop3_password(String pop3_password) {
    this.pop3_password = pop3_password;
  }

  public String getPop3_username() {
    return pop3_username;
  }

  public void setPop3_username(String pop3_username) {
    this.pop3_username = pop3_username;
  }

  public Properties getProps() {
    return props;
  }

  public void setProps(Properties props) {
    this.props = props;
  }

  public String getServer_database() {
    return server_database;
  }

  public void setServer_database(String server_database) {
    this.server_database = server_database;
  }

  public String getSmtp() {
    return smtp;
  }

  public void setSmtp(String smtp) {
    this.smtp = smtp;
  }

  public String getUser_database() {
    return user_database;
  }

  public void setUser_database(String user_database) {
    this.user_database = user_database;
  }

  public String getUser_password() {
    return user_password;
  }

  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }

  public String getUser_username() {
    return user_username;
  }

  public void setUser_username(String user_username) {
    this.user_username = user_username;
  } 
}
