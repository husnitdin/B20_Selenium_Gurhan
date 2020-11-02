package com.cybertek.tests.Day11_UtilsReview_Actions;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class ContextClick {

    @Test
    public void context_click(){

        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        Actions action = new Actions(Driver.getDriver());

        //2. Right click to the box.
        action.contextClick(box).perform();

        //3. Alert will open.
        BrowserUtils.wait(2);
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();
    }
}
