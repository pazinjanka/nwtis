/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.msimicic.aplikacija;

import javax.mail.PasswordAuthentication;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martina
 */
public class MailClientTest {
    
    public MailClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPasswordAuthentication method, of class MailClient.
     */
    @Test
    public void testGetPasswordAuthentication() {
        System.out.println("getPasswordAuthentication");
        MailClient instance = null;
        PasswordAuthentication expResult = null;
        PasswordAuthentication result = instance.getPasswordAuthentication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class MailClient.
     */
    @Test
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        String to = "";
        String subject = "";
        String content = "";
        MailClient instance = null;
        instance.sendMessage(to, subject, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkInbox method, of class MailClient.
     */
    @Test
    public void testCheckInbox() throws Exception {
        System.out.println("checkInbox");
        int mode = 0;
        MailClient instance = null;
        instance.checkInbox(mode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
