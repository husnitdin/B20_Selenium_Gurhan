package com.cybertek.tests.VyTrack;

import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginDriverManager {
    // TC#33 : Vytrack positive login test -> Driver Manager
    //1. Go to https://qa3.vytrack.com
    //2. Enter correct username
    //3. Enter correct password
    //4. Verify title changed Expected: “Dashboard”
    //Note: Follow Page Object Model design pattern, and get your
    // credentials from configuration.properties file

    @Test
    public void posLogin_storeManager(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));
        VyTrackLoginPage login = new VyTrackLoginPage();

        login.username.sendKeys(ConfigurationReader.getProperty("vyTrackDMUsername"));
        login.password.sendKeys(ConfigurationReader.getProperty("vyTrackPassword"));
        login.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(login.loginLogo) );

        String expTitle = "Dashboard";
        String actTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actTitle.contains(expTitle), "Title not found. Verification Failed!");

    }
}
