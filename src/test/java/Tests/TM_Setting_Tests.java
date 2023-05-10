package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.Approver_Setting_Page;
import Pages.Compliance_Login_Page;
import Pages.TM_Setting_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TM_Setting_Tests extends Configuration {

    //1
    @Test
    public void verifyEditProfileDetailsFromSettingMenuByTeamMember() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Configuration config = new Configuration();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("TeamMember");
        co_Login.verifyLogin();
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.editProfileDetails(config.read_Test_Data("teamMemberUpdatedName"), config.read_Test_Data("teamMemberUpdatedDesignation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();
        approverSettingPage.editProfileDetails(config.read_Test_Data("teamMemberName"), config.read_Test_Data("teamMemberDesignation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();
    }
    //2
    @Test
    public void VerifyTeamMemberChangePasswordFunctionality() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Configuration config = new Configuration();
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("TeamMember");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("currentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
        approverSettingPage.clickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("revisedCurrentPassword"), config.read_Test_Data("revisedNewPassword"), config.read_Test_Data("revisedConfirmPassword"));
        approverSettingPage.retriveAlert();

    }

    //3
    @Test
    public void verifyTeamMemberChangePasswordFunctionalityByEnteringWrongPasswordInCurrentPasswordField() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        Configuration config = new Configuration();
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("TeamMember");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("invalidCurrentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
    }

    //4
    @Test
    public void verifyTeamMemberLogoutFunctionality() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("TeamMember");
        co_Login.verifyLogin();
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.verifyLogout();

    }


}