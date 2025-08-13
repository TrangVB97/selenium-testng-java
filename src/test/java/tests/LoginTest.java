package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPages;

import static base.BaseTest.*;
import static pages.LoginPages.*;

public class LoginTest {

    LoginPages loginPages;

    @BeforeMethod
    void setUp() {
        openBrowser("chrome");
        loginPages = new LoginPages();
        loginPages.open("https://the-internet.herokuapp.com/login");
    }

//    @Test
//    public void testValidLogin() {
//        loginPages.login("tomsmith", "SuperSecretPassword!");
//        // Verify that the user is redirected to the dashboard or home page
//    }

    @Test (dataProvider = "loginCredentials", dataProviderClass = data.LoginData.class)
    public void testLogin(String username, String password, String expectedMessage) {
        loginPages.login(username, password);
        String actualMessage = getText(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "The message does not match the expected value.");

    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
