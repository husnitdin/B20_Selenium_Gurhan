package com.cybertek.tests.Day11_UtilsReview_Actions;

import com.cybertek.utilities.Driver;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest {

   @Test
    public void double_click(){

      // 1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
       Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

      // 2. Switch to iframe.
       Driver.getDriver().switchTo().frame("iframeResult");

      // 3. Double click on the text “Double-click me”
       WebElement dClick = Driver.getDriver().findElement(By.id("demo"));

       Actions actions = new Actions( Driver.getDriver() );
       actions.doubleClick(dClick).perform();

      // 4. Assert: Text “Hello world” is displayed.
      String exp = "red";
      String act = dClick.getAttribute("style");

      Assert.assertTrue(act.contains (exp), "After double click color not changed to red");
      Driver.getDriver().switchTo().defaultContent();
   }
}
