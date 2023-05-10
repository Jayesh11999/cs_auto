package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.Compliance_Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Compliance_Login_Tests extends Configuration {

    //1
    @Test
    public void verifyLoginWithValidComplianceOfficerCredentials() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
    }

    //2
    @Test
    public void verifyLoginWithValidTeamMemberCredentials() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("TeamMember");
        co_Login.verifyLogin();
    }

    //3
    @Test
    public void verifyLoginWithValidApproverCredentials() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
    }

}