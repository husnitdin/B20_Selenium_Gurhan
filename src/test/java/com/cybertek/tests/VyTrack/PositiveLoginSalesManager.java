package com.cybertek.tests.VyTrack;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PositiveLoginSalesManager {
    //TC#32 : Vytrack positive login test -> Sales Manager
    //1. Go to https://qa3.vytrack.com
    //2. Enter correct username
    //3. Enter correct password
    //4. Verify title changed Expected: “Dashboard”
    //Note: Follow Page Object Model design pattern, and get your correct
    // credentials from configuration.properties file
    @Test
    public void positive_login(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage login = new VyTrackLoginPage();

        login.username.sendKeys(ConfigurationReader.getProperty("vyTrackSalesMUsername"));
        login.password.sendKeys(ConfigurationReader.getProperty("vyTrackPassword"));
        login.loginButton.click();

        String expTitle = "Dashboard";
        String actTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actTitle.contains(expTitle), "Title not found, Verification Failed");

    }
}
