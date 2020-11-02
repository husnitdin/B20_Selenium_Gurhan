package com.cybertek.tests.Day13_POMReview_Synchronization;
import com.cybertek.pages.DynamicLoadPage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Dynamic_load_page2 {
    // TC#41 : Dynamically Loaded Page Elements 1
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
    //2. Click to start
    //3. Wait until loading bar disappears
    //4. Assert username inputbox is displayed
    //5. Enter username: tomsmith
    //6. Enter password: incorrectpassword
    //7. Click to Submit button
    //8. Assert “Your username is invalid!” text is displayed.
    //Note: Follow POM
    @Test
    public void dynamic_title2(){
        String url = "http://practice.cybertekschool.com/dynamic_loading/1";
        Driver.getDriver().get(url);

        DynamicLoadPage dynamicLoadPage = new DynamicLoadPage();
        dynamicLoadPage.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf( dynamicLoadPage.loading ) );

        Assert.assertTrue(dynamicLoadPage.username.isDisplayed(), "username not displayed");

        dynamicLoadPage.username.sendKeys("tomsmithjon");
        dynamicLoadPage.password.sendKeys("incorrectpassword");
        dynamicLoadPage.submitButton.click();

        Assert.assertTrue(dynamicLoadPage.wrongUsername.isDisplayed(), "Wrong username error message not diplayed");
    }
}
