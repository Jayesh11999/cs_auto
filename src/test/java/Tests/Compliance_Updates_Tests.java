package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.Approver_Setting_Page;
import Pages.Compliance_Login_Page;
import Pages.Compliance_Updates_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Compliance_Updates_Tests extends Configuration {

    //1
    @Test
    public void verifySearchUpdateFromUpdatesList() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Updates_Page complianceUpdatesPage = new Compliance_Updates_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceUpdatesPage.clickOnUpdatesMenu();
        complianceUpdatesPage.verifySearchUpdateFromUpdatesList();
    }

    //2
    @Test
    public void verifySelectMoreThan12Updates() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Updates_Page complianceUpdatesPage = new Compliance_Updates_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceUpdatesPage.clickOnUpdatesMenu();
        complianceUpdatesPage.verifySelectMoreThan12Updates();
        approverSettingPage.retriveAlert();
    }

    //3
    @Test
    public void verifySearchOneMonthEmailLogs() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Updates_Page complianceUpdatesPage = new Compliance_Updates_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceUpdatesPage.clickOnUpdatesMenu();
        complianceUpdatesPage.verifySearchOneMonthEmailLogs();
    }

    //4
    @Test
    public void verifySendUpdatesViaEmail() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Updates_Page complianceUpdatesPage = new Compliance_Updates_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceUpdatesPage.clickOnUpdatesMenu();
        complianceUpdatesPage.verifySendUpdatesViaEmail();

    }
}