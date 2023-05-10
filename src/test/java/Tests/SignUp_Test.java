package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.SignUp_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class SignUp_Test extends Configuration {
    //1
    @Test
    public void verifyNewUserSignUp() throws IOException, ParseException, AWTException, InterruptedException {
        SignUp_Page signUpPage = new SignUp_Page(driver);
        signUpPage.signUp();
    }
}