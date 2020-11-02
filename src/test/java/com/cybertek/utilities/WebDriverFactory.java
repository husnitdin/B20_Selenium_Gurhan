package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
    /*
            Method name: getDriver
            Static
            Accepts String arg: browserType -> determine what browser to open
            return type WebElement
         */

    public static WebDriver getDriver(String browserType){

       if (browserType.equalsIgnoreCase("chrome")){

           WebDriverManager.chromedriver().setup();
           return new ChromeDriver();

       } else if (browserType.equalsIgnoreCase("firefox")){

           WebDriverManager.firefoxdriver().setup();
           return new FirefoxDriver();

       } else if (browserType.equalsIgnoreCase("opera")){

           WebDriverManager.operadriver().setup();
           return new OperaDriver();
       } else {
           System.err.println("Given driver not exist");
       }
        return null;
    }
}
