package com.cybertek.tests.Day13_POMReview_Synchronization;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NegativeLoginTests {

        LoginPage loginPage = new LoginPage();

        @Test (description = "entering incorrect username")
        public void negative_login1(){
            Driver.getDriver().get(ConfigurationReader.getProperty("smartBearURL"));
            loginPage = new LoginPage();
            // Call the objects
            loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("banana"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("smartbear_password"));
            loginPage.loginButton.click();

            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "wrong username OR password");
        }

        @Test (description = "using login method for negative test")
        public void negative_login2(){

            Driver.getDriver().get(ConfigurationReader.getProperty("smartBearURL"));
            loginPage = new LoginPage();

            String username = "flsdf";
            String password = ConfigurationReader.getProperty("smartbear_password");

            loginPage.login(username, password);
            Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "wrong username OR password");
        }
}
