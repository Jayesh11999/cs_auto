package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TM_Setting_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public TM_Setting_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyEditProfileDetailsFromSettingMenuByTeamMember() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.editProfileDetails(config.read_Test_Data("teamMemberUpdatedName"), config.read_Test_Data("teamMemberUpdatedDesignation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();
        approverSettingPage.editProfileDetails(config.read_Test_Data("teamMemberName"), config.read_Test_Data("teamMemberDesignation"), config.read_Test_Data("otp"));
        approverSettingPage.retriveAlert();
    }

    public void VerifyTeamMemberChangePasswordFunctionality() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("currentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
        approverSettingPage.clickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("revisedCurrentPassword"), config.read_Test_Data("revisedNewPassword"), config.read_Test_Data("revisedConfirmPassword"));
        approverSettingPage.retriveAlert();
    }

    public void verifyChangePasswordByEnteringWrongCurrentPasswordByCSOfficer() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("invalidCurrentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
    }

    public void verifyTeamMemberLogoutFunctionality() {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.verifyLogout();
    }
}