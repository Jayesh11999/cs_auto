package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.Approver_Setting_Page;
import Pages.Compliance_Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Approver_Setting_Tests extends Configuration {


    //1
    @Test
    public void verifyEditProfileDetailsFromSettingMenuByApprover() throws IOException, ParseException, AWTException, InterruptedException {
        Approver_Setting_Page ap_Setting = new Approver_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
        Configuration config = new Configuration();
        ap_Setting.clickOnSettingsButton();
        ap_Setting.editProfileDetails(config.read_Test_Data("approverUpdateName"), config.read_Test_Data("approverUpdateDesignation"), config.read_Test_Data("otp"));
        ap_Setting.retriveAlert();
        ap_Setting.editProfileDetails(config.read_Test_Data("approverName"), config.read_Test_Data("approverDesignation"), config.read_Test_Data("otp"));
        ap_Setting.retriveAlert();

    }

    //2
    @Test
    public void verifyApproverChangePasswordFunctionality() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Approver_Setting_Page ap_Setting = new Approver_Setting_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
        Configuration config = new Configuration();
        ap_Setting.verifyApproverChangePasswordFunctionality();
        ap_Setting.clickOnSettingsButton();
        ap_Setting.goToSecurityMenuAndClickOnChangePasswordButton();
        ap_Setting.confirmCurrentAndNewPassword(config.read_Test_Data("currentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        ap_Setting.retriveAlert();
        ap_Setting.clickOnChangePasswordButton();
        ap_Setting.confirmCurrentAndNewPassword(config.read_Test_Data("revisedCurrentPassword"), config.read_Test_Data("revisedNewPassword"), config.read_Test_Data("revisedConfirmPassword"));
        ap_Setting.retriveAlert();

    }

    //3
    @Test
    public void verifyApproverChangePasswordFunctionalityByEnteringWrongPasswordInCurrentPasswordField() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Approver_Setting_Page ap_Setting = new Approver_Setting_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
        ap_Setting.verifyApproverChangePasswordFunctionalityByEnteringWrongPasswordInCurrentPasswordField();
        ap_Setting.clickOnSettingsButton();
        ap_Setting.goToSecurityMenuAndClickOnChangePasswordButton();
        ap_Setting.confirmCurrentAndNewPassword(read_Test_Data("invalidCurrentPassword"), read_Test_Data("newPassword"), read_Test_Data("confirmPassword"));
        ap_Setting.retriveAlert();

    }

    //4
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyApproverLogout() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Approver_Setting_Page ap_Setting = new Approver_Setting_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
        ap_Setting.verifyLogout();
    }

    //5
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyDeactivateAccountOfApproverAndRejectRequestByCO() throws IOException, ParseException, AWTException, InterruptedException {
        Approver_Setting_Page ap_Setting = new Approver_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("Approver");
        co_Login.verifyLogin();
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        ap_Setting.clickOnSettingsButton();
        ap_Setting.goToSecurityMenuAndClickOnDeactivateAccountButton();
        ap_Setting.verifyLogout();
        complianceLoginPage.enterLoginCredentials("ComplianceOfficer");
        complianceLoginPage.verifyLogin();
        ap_Setting.verifyRejectRequestFromComplianceOfficer();
    }

}