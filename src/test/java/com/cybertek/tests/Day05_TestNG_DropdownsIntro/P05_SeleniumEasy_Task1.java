package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*
TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
 */
public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
     // WebElement successMessage = driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
                if (!successMessage.isDisplayed()){
                    System.out.println("Verification PASSED");
                } else {
                    System.out.println("Verification FAILED");
                }

        successCheckbox.click();

        if (successMessage.isDisplayed()){
            System.out.println("Verification PASSED");
        } else {
            System.out.println("Verification FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
