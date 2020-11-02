package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.ZeroBank;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #4: Zero Bank login title verification
        1. Open Chrome browser
        2. Go to http://zero.webappsecurity.com/login.html
        3. Enter username: username
        4. Enter password: password

        5. Click to “Account Activity” link
        6. Verify title changed to:
        Expected: “Zero – Account Activity”

        7. Click to “Transfer Funds” link
        8. Verify title changed to:
        Expected: “Zero – Transfer Funds”
        9. Click to “Pay Bills” link
        10. Verify title changed to:
        Expected: “Zero - Pay Bills”
        11. Click to “My Money Map” link
        12. Verify title changed to:
        Expected: “Zero – My Money Map”
        13. Click to “Online Statements” link
        14. Verify title changed to:
        Expected: “Zero – Online Statements”
 */
public class Task04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);

        driver.findElement(By.id("account_activity_tab")).click();
        String actual = driver.getTitle();
        String expected = "Zero – Account Activity";

        if ( actual.contains(expected) ){
            System.out.println("Title Verification PASSED");
        } else {
            System.out.println("Title Verification FAILED");
        }

    }
}
