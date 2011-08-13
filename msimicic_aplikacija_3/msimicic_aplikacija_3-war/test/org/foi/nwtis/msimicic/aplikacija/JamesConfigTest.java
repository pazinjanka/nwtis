/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

/**
 *
 * @author Martina
 */
public class JamesConfigTest {
    
    public static void main(String[] args)
    throws Exception
  {
    // CREATE CLIENT INSTANCES
    MailClient nwtisClient = new MailClient("nwtis", "localhost");
    MailClient msimicicClient = new MailClient("msimicic", "localhost");
    MailClient blueClient = new MailClient("blue", "localhost");
    
    // CLEAR EVERYBODY'S INBOX
    nwtisClient.checkInbox(MailClient.CLEAR_MESSAGES);
    msimicicClient.checkInbox(MailClient.CLEAR_MESSAGES);
    blueClient.checkInbox(MailClient.CLEAR_MESSAGES);
    Thread.sleep(500); // Let the server catch up
    
    // SEND A COUPLE OF MESSAGES TO BLUE (FROM RED AND GREEN)
    nwtisClient.sendMessage(
      "blue@localhost",
      "Testing blue from red",
      "This is a test message");
    msimicicClient.sendMessage(
      "blue@localhost",
      "Testing blue from green",
      "This is a test message");
    Thread.sleep(500); // Let the server catch up
    
    // LIST MESSAGES FOR BLUE (EXPECT MESSAGES FROM RED AND GREEN)
    blueClient.checkInbox(MailClient.SHOW_AND_CLEAR);
  }
}
