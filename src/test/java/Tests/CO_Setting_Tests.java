package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.Approver_Setting_Page;
import Pages.CO_Setting_Page;
import Pages.Compliance_Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CO_Setting_Tests extends Configuration {


    //1
    @Test
    public void verifyEditProfileWithValidDetailsInCS() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Configuration config = new Configuration();
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.editProfileDetails(config.read_Test_Data("CO_Updated_Name"), config.read_Test_Data("CO_Updated_Designation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();
        approverSettingPage.editProfileDetails(config.read_Test_Data("CO_Name"), config.read_Test_Data("CO_Designation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();

    }

    //2
    @Test
    public void verifyAddNewCompanyFromSettingInCS() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        coSettingPage.verifyAddNewCompanyFromSettingInCS();

    }

    //3
    @Test
    public void verifyChangePasswordFromSettingByCSOfficer() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        Configuration config = new Configuration();
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("currentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
        approverSettingPage.clickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("revisedCurrentPassword"), config.read_Test_Data("revisedNewPassword"), config.read_Test_Data("revisedConfirmPassword"));
        approverSettingPage.retriveAlert();

    }

    //4
    @Test
    public void verifyAddNewMembersFromSettingByCSOfficer() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        coSettingPage.verifyAddNewMembersFromSettingByCSOfficer();

    }

    //5
    @Test
    public void verifyDeleteTheCreatedMemberFromSettingByCSOfficer() throws AWTException, IOException, ParseException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        coSettingPage.verifyDeleteTheCreatedMemberFromSettingByCSOfficer();

    }

    //6
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyChangePasswordByEnteringWrongCurrentPasswordByCSOfficer() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(read_Test_Data("invalidCurrentPassword"), read_Test_Data("newPassword"), read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();

    }

    //7
    @Test
    public void verifySignupProcessWithValidEmail() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        coSettingPage.verifyAddNewMembersFromSettingByCSOfficer();
        coSettingPage.verifySignupProcessWithValidEmail();
    }

    //8
    @Test
    public void verifyDeleteAllTaskFromTrash() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coSettingPage.verifyDeleteAllTaskFromTrash();
    }

    //9
    @Test
    public void verifyCOLogoutFunctionality() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Setting_Page coSettingPage = new CO_Setting_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.verifyLogout();
    }

}