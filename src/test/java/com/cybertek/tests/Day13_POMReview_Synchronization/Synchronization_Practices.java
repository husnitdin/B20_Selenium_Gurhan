package com.cybertek.tests.Day13_POMReview_Synchronization;
import com.cybertek.pages.DynamicLoadPage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Synchronization_Practices {
    // TC#40 : Dynamically Loaded Page Elements 7
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    //2. Wait until title is “Dynamic Title”
    //3. Assert : Message “Done” is displayed.
    //4. Assert : Image is displayed.
    //Note: Follow POM
    @Test
    public void dynamic_title(){
        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        DynamicLoadPage dynamicPage = new DynamicLoadPage();

        WebDriverWait wait  = new WebDriverWait(Driver.getDriver(), 5);
        wait.until( ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(dynamicPage.doneMessage.isDisplayed(), "done message is not displayed");
    }
}
