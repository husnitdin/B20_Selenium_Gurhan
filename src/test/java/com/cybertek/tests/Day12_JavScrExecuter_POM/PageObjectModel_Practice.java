package com.cybertek.tests.Day12_JavScrExecuter_POM;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;
public class PageObjectModel_Practice {

    @Test
    public void login_to_smartBear(){

        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        loginPage.usernameInput.sendKeys("Tester");
        loginPage.passwordInput.sendKeys("test");
        loginPage.loginButton.click();

    }
}
