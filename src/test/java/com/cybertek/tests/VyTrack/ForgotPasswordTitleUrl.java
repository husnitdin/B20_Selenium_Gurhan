package com.cybertek.tests.VyTrack;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ForgotPasswordTitleUrl {
    // TC#35 : Vytrack forgot password page verifications -> TITLE and URL
    //1. Go to https://qa3.vytrack.com
    //2. Click to “Forgot your password?” link
    //3. Verify title changed to expected
    //Expected: “Forgot Password”
    // 4. Verify url is as expected:
    //Expected: “https://qa3.vytrack.com/user/reset-request”
    // Note: Follow Page Object Model design pattern
    @Test
    public void forgot_pass_err_message(){

        Driver.getDriver().get( ConfigurationReader.getProperty("vyTrackURL"));
        VyTrackLoginPage login = new VyTrackLoginPage();

        login.forgotPassword.click();

        String expTitle = "Forgot Password";
        String actTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actTitle.contains(expTitle), "Titles not matched. Verification Failed!");

        String expURL = "https://qa3.vytrack.com/user/reset-request";
        String actURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actURL.contains(expURL), "URLs not matched. Verification Failed!");
    }
}
