package com.cybertek.tests.VyTrack;

import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginWrongPassword {
    // TC#30 : Vytrack negative login test Wrong Password Test
    //1. Go to https://qa3.vytrack.com
    //2. Enter correct username
    //3. Enter incorrect password
    //4. Verify error message text is as expected Expected: “Invalid user name or password.”
    //Note: Follow Page Object Model design pattern, and get your correct credentials from
    // configuration.properties file

    @Test
    public void wrongPassword(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage login = new VyTrackLoginPage();

        login.username.sendKeys(ConfigurationReader.getProperty("vyTrackSalesMUsername"));
        login.password.sendKeys(ConfigurationReader.getProperty("banana"));
        login.loginButton.click();

        String expErrorMessage = "Invalid user name or password.";
        String actErrorMessage = login.errorMessage.getText();

        Assert.assertTrue(actErrorMessage.contains(expErrorMessage), "Error message not displayed. Verification Failed");

    }
}

