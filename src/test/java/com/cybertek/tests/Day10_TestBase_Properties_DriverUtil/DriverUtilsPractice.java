package com.cybertek.tests.Day10_TestBase_Properties_DriverUtil;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){
        Driver.getDriver().get("https://google.com");

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));

        String search = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(search+ Keys.ENTER);

        String exp = search;
        String act = Driver.getDriver().getTitle();

        Assert.assertTrue(act.contains(exp), "not found");

    }

}
