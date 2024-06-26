/*
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
 * This program is written by Naoyuki Christopher Higaki.
 * Purpose: This class contains unit tests for the Login class to ensure correct functionality.
 */

package registration;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testCheckUserName_Valid() {
        Login test = new Login();
        assertTrue(test.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login test = new Login();
        assertFalse(test.checkUserName("kyle1"));
        assertFalse(test.checkUserName("kyle"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login test = new Login();
        assertTrue(test.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login test = new Login();
        assertFalse(test.checkPasswordComplexity("cheese99"));
        assertFalse(test.checkPasswordComplexity("CHEESE99"));
        assertFalse(test.checkPasswordComplexity("Chese@ke"));
    }

    @Test
    public void testRegisterUser_Valid() {
        Login test = new Login();
        String result = test.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertTrue(result.contains("Registration successful"));
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        Login test = new Login();
        String result = test.registerUser("kyle1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        Login test = new Login();
        String result = test.registerUser("kyl_1", "cheese99", "Kyle", "Smith");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    public void testLoginUser_Valid() {
        Login test = new Login();
        test.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertTrue(test.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Invalid() {
        Login test = new Login();
        test.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertFalse(test.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testReturnLoginStatus_Valid() {
        Login test = new Login();
        test.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Login successful", test.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testReturnLoginStatus_Invalid() {
        Login test = new Login();
        test.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Login unsuccessful", test.returnLoginStatus("kyl_1", "wrongpassword"));
    }
}
