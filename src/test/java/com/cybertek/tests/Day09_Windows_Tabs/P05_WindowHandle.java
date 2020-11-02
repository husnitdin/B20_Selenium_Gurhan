package com.cybertek.tests.Day09_Windows_Tabs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class P05_WindowHandle {

    //2. Create new test and make set ups
    //3. Go to : http://practice.cybertekschool.com/windows
    //4. Assert: Title is “Practice”
    //5. Click to: “Click Here” text
    //6. Switch to new Window.
    //7. Assert: Title is “New Window”
    WebDriver driver;

    @BeforeMethod
    public void setUps(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void windowHandle(){

        String actTitle = driver.getTitle();
        System.out.println("actTitle = " + actTitle);

        Assert.assertTrue(actTitle.equals("Practice"));

        WebElement clickHereText = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereText.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        // all currently opened windows
        Set<String> windowHandles = driver.getWindowHandles();

        // loop through set of windows
        // using switchTo().window() => switch to other windows
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title "+driver.getTitle());
        }

        // comparing actual with expected title
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        // closes currently opened window
        driver.close();

        // switch back to main page
        driver.switchTo().window(mainHandle);

        // closes all opened window
        driver.quit();

    }


}
