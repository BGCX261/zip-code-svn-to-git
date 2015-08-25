/**
 * @package     tests.org.routenova.zipcode
 * @version     $Id: AllTests.java 11 2007-01-21 19:40:52Z mikhail.branicki $
 * @copyright   (c) 2007 RouteNova.org 
 * @license     http://www.routenova.org/License - new BSD License 
 */
package tests.org.routenova.utils.zipcode;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses( { ZipcodeTest.class })
/**
 * Route-Nova users subsytem testing
 * @author  Mikhail Branicki <mikhail.branicki@gmail.com>
 */     
public class AllTests {
    // public static class Compatibility {
    public static Test suite() {
        return new JUnit4TestAdapter(AllTests.class);
    }
    // }

}