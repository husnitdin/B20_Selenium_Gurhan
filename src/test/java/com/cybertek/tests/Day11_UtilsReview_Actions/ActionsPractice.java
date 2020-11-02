package com.cybertek.tests.Day11_UtilsReview_Actions;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ActionsPractice {
    // 1. Go to http://practice.cybertekschool.com/hovers
    // 2. Hover over to first image
    // 3. Assert: a. “name: user1” is displayed
    // 4. Hover over to second image
    // 5. Assert: a. “name: user2” is displayed
    // 6. Hover over to third image
    // 7. Confirm:a. “name: user3” is displayed
    @Test
    public void hover_over_test(){

       // 1. Go to http://practice.cybertekschool.com/hovers
       Driver.getDriver().get("http://practice.cybertekschool.com/hovers ");

        WebElement img1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        // 1. create an instance of action class and pass the driver instance into the constructor
       Actions actions = new Actions(Driver.getDriver());

        // 2. Use the actions object and call necessary methods
        actions.moveToElement(img1).perform();

        // 3. Do the assertions
        Assert.assertTrue(user1.isDisplayed(), "message1 not displayed");

        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed(), "message2 not displayed");

        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed(), "message3 not displayed");
    }
}


















