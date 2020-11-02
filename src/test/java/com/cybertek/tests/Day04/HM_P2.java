package com.cybertek.tests.Day04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.

 */
public class HM_P2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElement.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement delButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if ( delButton.isDisplayed() ){
            System.out.println("Delete button is displayed. PASS!");
        } else {
            System.out.println("Delete button is not displayed. FAIL!");
        }

        try {
            //5. Click to “Delete” button.
            delButton.click();
            //6. Verify “Delete” button is NOT displayed after clicking.
            if (!delButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayed. PASS!");
            } else {
                System.out.println("Delete button is displayed. FAIL!");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementReferenceException has been thrown");
            System.out.println("It means element has been entirely removed from HTML");
            System.out.println("Verification PASSED!");
        }

    }
}
