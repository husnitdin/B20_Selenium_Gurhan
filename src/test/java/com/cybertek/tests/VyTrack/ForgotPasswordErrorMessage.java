package com.cybertek.tests.VyTrack;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ForgotPasswordErrorMessage {
    // TC#36 : Vytrack forgot password page verification -> ERROR MESSAGE
    //1. Go to https://qa3.vytrack.com/user/reset-request
    //2. Enter random username
    //3. Click to request button
    //4. Verify error message is displayed
    //5. Verify error message text is as expected.
    //Expected: There is no active user with username or email address “given text”.
    // Note: Follow Page Object Model design pattern
    @Test
    public void forgot_pass_err_message(){

        Driver.getDriver().get( ConfigurationReader.getProperty("vyTrackForgotPassURL"));

        VyTrackLoginPage login = new VyTrackLoginPage();
        Faker faker = new Faker();
        String name = faker.name().username();

        login.username.sendKeys( name );
        login.requestButton.click();

        String expErrorMessage = "There is no active user with username or email address " + "\"" + name + "\".";
        String actErrorMessage = login.FPErrorMessage.getText();

        System.out.println(expErrorMessage);
        System.out.println(actErrorMessage);

        Assert.assertTrue(actErrorMessage.equalsIgnoreCase(expErrorMessage), "Error Message not matched. Verification Failed!");
    }
}
