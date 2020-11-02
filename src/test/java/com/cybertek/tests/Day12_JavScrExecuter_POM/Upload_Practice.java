package com.cybertek.tests.Day12_JavScrExecuter_POM;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Upload_Practice {
    @Test
    public void uploading_file_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        // get the path of the file
        String path = "/Users/husnitdin/Desktop/Screen Shot 2020-10-14 at 10.29.07.png";

        // locate the web element Choose File
        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.wait(2);
        // send the path of the file to uploadInput webElement
        uploadInput.sendKeys(path);

        // locate the UPLOAD button and click
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtils.wait(2);
        uploadButton.click();
    }

}
