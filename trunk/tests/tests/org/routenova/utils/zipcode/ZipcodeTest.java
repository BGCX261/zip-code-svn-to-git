/**
 * @package     tests.org.routenova.utils.zipcode
 * @version     $Id: ZipcodeTest.java 11 2007-01-21 19:40:52Z mikhail.branicki $
 * @author      Mikhail Branicki <mikhail.branicki@gmail.com>
 * @copyright   (c) 2007 RouteNova.org 
 * @license     http://www.routenova.org/License - new BSD License 
 */
package tests.org.routenova.utils.zipcode;

import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import java.sql.*;

import org.routenova.utils.zipcode.Zipcode;

/**
 * Zip code geo calculations testing
 * @author  Mikhail Branicki <mikhail.branicki@gmail.com>
 */
public class ZipcodeTest {
    private static Connection DB = null;
    private static boolean isMetric = true;
    private static String  dbSheme = "";

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZipcodeTest.class);
    }

    /**
     * Open database connection and set zipcode configuration data
     */
    @BeforeClass
    public static void PrepareAll() {

        String conn = "jdbc:postgresql://localhost/zipcode";
        
        try {
            Class.forName("org.postgresql.Driver");
            DB = DriverManager.getConnection(conn, "routenova", "routenova");
            //DB.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        isMetric = false;
        dbSheme  = "public";
    }
    
    /**
     * Zipcode search in given radius.
     */
    @Test
    public void a_zipRadius() {
          Zipcode ziptest = new Zipcode(DB, dbSheme, isMetric);
          
          assertTrue(ziptest.findRadius("33154", 5));
          assertFalse(ziptest.findRadius("wrong code", 15));
          assertTrue(ziptest.isZipcode("33154"));
          assertFalse(ziptest.isZipcode("wrong code"));
    }
    /**
     * Check for zip code.
     */
    @Test
    public void b_isZip() {
        Zipcode ziptest = new Zipcode(DB, dbSheme, isMetric);
        
        assertTrue(ziptest.isZipcode("33154"));
        assertFalse(ziptest.isZipcode("wrong code"));
    }
    /**
     * Get distance test.
     */
    @Test
    public void b_zipDistance() {
        Zipcode ziptest = new Zipcode(DB, dbSheme, isMetric);

        assertEquals(ziptest.findDistance("33154", "10095"), 1085.3940415672146);
    }

}
