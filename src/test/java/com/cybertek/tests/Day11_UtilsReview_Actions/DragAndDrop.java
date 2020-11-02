package com.cybertek.tests.Day11_UtilsReview_Actions;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class DragAndDrop {

    @Test
    public void drag_and_drop(){

        // 1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
         Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

         WebElement cookies = Driver.getDriver().findElement(By.xpath("//button[.='Accept Cookies']"));
         cookies.click();
         BrowserUtils.wait(3);

        // 2. Drag and drop the small circle to bigger circle.
         WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
         WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

         Actions actions = new Actions(Driver.getDriver());

        // drag and drop method accepts 2 args
        // 1. element you want to drag
        // 2. where you want to put it
         actions.dragAndDrop(smallCircle, bigCircle).perform();

        // 3. Assert:
        //          -Text in big circle changed to: “You did great!”

        String exp = "You did great!";
        String act = bigCircle.getText();
        Assert.assertTrue(act.contains(exp), "You did great! not displayed");
      }
}

