package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Approver_Setting_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Approver_Setting_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSettingsButton() {
        common.isElementDisplayed(driver, SettingsButton);
        common.click(driver , SettingsButton);
        common.pause(2);
        common.log("Step :: Click on setting icon on dashboard.");
    }

    public void clickOnChangePasswordButton() {
        common.isElementDisplayed(driver, ChangePasswordButton);
        common.click(driver , ChangePasswordButton);
        common.pause(2);
        common.log("Step :: Click on change password on security page.");
    }

    public void editProfileDetails(String name, String designation, String otp) {

        common.isElementDisplayed(driver, NameField);
        common.clear(driver , NameField);
        common.sendKeys(driver , NameField , name);
        common.log("Step :: Enter full name in personal details page ::" + name + ".");

        common.isElementDisplayed(driver, DesignationField);
        common.clear(driver , DesignationField);
        common.sendKeys(driver , DesignationField , designation);
        common.log("Step :: Enter designation in personal details page ::" + designation + ".");

        common.isElementDisplayed(driver, MobileField);
        String mobileNumber = Common.generateRandomNumberString(10);
      //  driver.findElement(By.xpath(MobileField)).clear();
        common.clear(driver , MobileField);
      //  driver.findElement(By.xpath(MobileField)).sendKeys(mobileNumber);
        common.sendKeys(driver , MobileField , mobileNumber);
        common.log("Step :: Enter Mobile number in personal details page :: " + mobileNumber + ".");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveChangesButton)));

        common.isElementDisplayed(driver, SaveChangesButton);
       // driver.findElement(By.xpath(SaveChangesButton)).click();
        common.click(driver , SaveChangesButton);
        common.log("Step :: Click on save changes button.");

        this.retriveAlert();

        common.isElementDisplayed(driver, OTPField);
      //  driver.findElement(By.xpath(OTPField)).sendKeys(otp);
        common.sendKeys(driver , OTPField , otp);
        common.log("Step :: Enter 6 digit OTP :: " + otp + ".");

        common.isElementDisplayed(driver, SaveDetailsButton);
       // driver.findElement(By.xpath(SaveDetailsButton)).click();
        common.click(driver , SaveDetailsButton);
        common.log("Step :: Click on save details button.");


    }

    public void goToSecurityMenuAndClickOnChangePasswordButton() {
        common.isElementDisplayed(driver, SecurityMenuButton);
//        driver.findElement(By.xpath(SecurityMenuButton)).click();
        common.click(driver , SecurityMenuButton);
        common.log("Step :: Click on security menu.");
        common.isElementDisplayed(driver, ChangePasswordButton);
//        driver.findElement(By.xpath(ChangePasswordButton)).click();
        common.click(driver , ChangePasswordButton);
        common.log("Step :: Click on Change Password on security page.");

    }

    public void goToSecurityMenuAndClickOnDeactivateAccountButton() {

        common.isElementDisplayed(driver, SecurityMenuButton);
       // driver.findElement(By.xpath(SecurityMenuButton)).click();
        common.click(driver , SecurityMenuButton);
        common.log("Step :: Click on security menu");

        common.isElementDisplayed(driver, DeactivateAccountButton);
      //  driver.findElement(By.xpath(DeactivateAccountButton)).click();
        common.click(driver , DeactivateAccountButton);
        common.log("Step :: Click on Deactivate Account on security page");

        common.isElementDisplayed(driver, deactivateAccountPopUp);
        String deactivatePopup = driver.findElement(By.xpath(deactivateAccountPopUp)).getText();
        Assert.assertEquals(deactivatePopup, "Deactivate Account");
        common.log("Step :: Verify pop-up is open :: " + deactivatePopup);

        common.isElementDisplayed(driver, ReasonField);
       // driver.findElement(By.xpath(ReasonField)).sendKeys("Deactivate Approver request");
        common.sendKeys(driver , ReasonField , "Deactivate Approver request");
        common.log("Step :: Enter reason");

        common.isElementDisplayed(driver, SubmitButton);
       // driver.findElement(By.xpath(SubmitButton)).isEnabled();
        common.isEnabled(driver , SubmitButton);
       // driver.findElement(By.xpath(SubmitButton)).click();
        common.click(driver , SubmitButton);
        common.log("Step :: Click on submit button.");
        this.retriveAlert();
    }

    public void verifyRejectRequestFromComplianceOfficer() {

        common.pause(3);
        common.isElementDisplayed(driver, DashboardApprovalPending);
       // driver.findElement(By.xpath(DashboardApprovalPending)).click();
        common.click(driver , DashboardApprovalPending);
        common.log("Step :: Click on approval pending menu.");

        common.pause(3);
        common.isElementDisplayed(driver, RequestTab);
        //driver.findElement(By.xpath(RequestTab)).click();
        common.click(driver , RequestTab);
        common.log("Step :: Click on Request menu.");

        common.pause(5);
        common.isElementDisplayed(driver, RejectButton);
//        driver.findElement(By.xpath(RejectButton)).click();
        common.click(driver , RejectButton);
        common.log("Step :: Click on reject button.");

        common.pause(2);
        common.isElementDisplayed(driver, yesButton);
//        driver.findElement(By.xpath(yesButton)).click();
        common.click(driver , yesButton);
        common.log("Step :: Click on yes button.");

        common.isElementDisplayed(driver, Alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Alert)));
        String message = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message + ".");

        common.pause(2);
        common.isElementDisplayed(driver, DashboardCompleted);
       // driver.findElement(By.xpath(DashboardCompleted)).click();
        common.click(driver , DashboardCompleted);
        common.log("Step :: Click on completed menu.");

        common.pause(2);
        common.isElementDisplayed(driver, CompletedRequests);
        //driver.findElement(By.xpath(CompletedRequests)).click();
        common.click(driver , CompletedRequests);
        common.log("Step :: Click on completed request button.");

        common.pause(3);
        common.isElementDisplayed(driver, RejectedStatus);
        String requestStatus = common.getText(driver , RejectedStatus);
        common.log("Step :: Verify the rejected request status :: " + requestStatus);
    }

    public void confirmCurrentAndNewPassword(String currentPassword, String newPassword, String confirmPassword) {

        common.isElementDisplayed(driver, CurrentPasswordField);
      //  driver.findElement(By.xpath(CurrentPasswordField)).sendKeys(currentPassword);
        common.sendKeys(driver , CurrentPasswordField , currentPassword);
        common.log("Step :: Enter current password in current password input field ::" + currentPassword + ".");

        common.isElementDisplayed(driver, NewPasswordField);
       // driver.findElement(By.xpath(NewPasswordField)).sendKeys(newPassword);
        common.sendKeys(driver , NewPasswordField, newPassword);
        common.log("Step :: Enter new password in new password input field ::" + newPassword + ".");

        common.isElementDisplayed(driver, ConfirmPasswordField);
       // driver.findElement(By.xpath(ConfirmPasswordField)).sendKeys(confirmPassword);
        common.sendKeys(driver , ConfirmPasswordField , confirmPassword);
        common.log("Step :: Enter confirm password in confirm password field ::" + confirmPassword + ".");

        common.isElementDisplayed(driver, SavePasswordBButton);
        //driver.findElement(By.xpath(SavePasswordBButton)).click();
        common.click(driver , SavePasswordBButton);
        common.log("Step :: Click on save password button.");

    }


    public void retriveAlert() {
        common.isElementDisplayed(driver, Alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Alert)));
        String message = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message + ".");
    }

    public void verifyLogout() {
        common.isElementDisplayed(driver, LogoutButton);
       // driver.findElement(By.xpath(LogoutButton)).click();
        common.click(driver , LogoutButton);
        common.log("Step :: Click on logout button.");

        common.isElementDisplayed(driver, yesButton);
     //   driver.findElement(By.xpath(yesButton)).click();
        common.click(driver , yesButton);
        common.log("Step :: Click on yes button.");

        common.isElementDisplayed(driver, LoginTitle);
        String loginPage = driver.findElement(By.xpath(LoginTitle)).getText();
        common.log("Step :: Login page title :: " + loginPage + ".");
    }

    public void verifyEditProfileDetailsFromSettingMenuByApprover() throws IOException, ParseException {


    }

    public void verifyApproverChangePasswordFunctionality() throws IOException, ParseException {


    }

    public void verifyApproverLogout() {
        this.verifyLogout();
    }

    public void verifyApproverChangePasswordFunctionalityByEnteringWrongPasswordInCurrentPasswordField() throws IOException, ParseException {

    }

    public void verifyDeactivateAccountOfApproverAndRejectRequestbyCO() throws IOException, ParseException, InterruptedException, AWTException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        this.clickOnSettingsButton();
        this.goToSecurityMenuAndClickOnDeactivateAccountButton();
        this.verifyLogout();
        complianceLoginPage.enterLoginCredentials("ComplianceOfficer");
        complianceLoginPage.verifyLogin();
        this.verifyRejectRequestFromComplianceOfficer();
    }
}