package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CO_Setting_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();


    public CO_Setting_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyAddNewMembersFromSettingByCSOfficer() {

        common.isElementDisplayed(driver, TeamMemberMenu);
        common.click(driver, TeamMemberMenu);
        common.log("Step :: Click on team member menu in setting page.");

        common.pause(3);
        common.isElementDisplayed(driver, AddNewButtonOnTeamMemberMenu);
        common.click(driver , AddNewButtonOnTeamMemberMenu);
        common.log("Step :: Click on add new button on the team member menu in setting page.");

        common.pause(2);
        common.isElementDisplayed(driver, FullNameInputField);
        String MemberFullName = Common.generateRandomChars(7);
        common.sendKeys(driver , FullNameInputField , MemberFullName);
        common.log("Step :: Enter member's full name :: " + MemberFullName + ".");

        common.isElementDisplayed(driver, SelectRoleInputField);
        common.click(driver , SelectRoleInputField);
        common.click(driver , TeamMemberRoleInDropDown);
        common.log("Step :: Select role from drop-down :: Team Member.");

        common.isElementDisplayed(driver, EmailInputField);
        String emailAddress = Common.generateRandomChars(4);
        common.sendKeys(driver , EmailInputField , "rahuld+" + emailAddress + "@perfectqaservices.com");
        common.log("Step :: Enter email id :: " + "rahuld+" + emailAddress + "@perfectqaservices.com");

        common.isElementDisplayed(driver, CO_InviteButton);
        common.click(driver , CO_InviteButton);
        common.log("Step :: Click on invite button.");

        common.isElementDisplayed(driver, Alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Alert)));
        String message = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message + ".");

        if (message.equalsIgnoreCase("The invitation has been sent through email")){
            common.pause(10);
            common.refresh(driver);
            common.pause(10);
            common.isElementDisplayed(driver, SearchIcon);
            // driver.findElement(By.xpath(SearchIcon)).click();
            common.click(driver , SearchIcon);
            common.log("Step :: Click on search icon.");

            common.isElementDisplayed(driver, CreatedUser);
            // driver.findElement(By.xpath(CreatedUser)).sendKeys(MemberFullName);
            common.sendKeys(driver , CreatedUser , MemberFullName);
            common.log("Step :: Search the created user.");

            common.pause(5);
            common.isElementVisible(driver, CreatedUserInList);
            common.isElementDisplayed(driver, CreatedUserInList);
            //String searchUser = driver.findElement(By.xpath(CreatedUserInList)).getText();
            String searchUser = common.getText(driver, CreatedUserInList);
            common.log("Step :: Verify the created user in list :: " + searchUser + ".");

            return MemberFullName;
        }
        else {
            return message;
        }
    }

    public void verifyAddNewCompanyFromSettingInCS() throws InterruptedException, IOException, ParseException {

        common.isElementDisplayed(driver, CompanyMenuOnSettingPage);
        //driver.findElement(By.xpath(CompanyMenuOnSettingPage)).click();
        common.click(driver , CompanyMenuOnSettingPage);
        common.log("Step :: Click on company menu on setting page.");

        common.pause(5);
        common.isElementDisplayed(driver, AddAnotherCompanyButton);
     //   driver.findElement(By.xpath(AddAnotherCompanyButton)).click();
        common.click(driver , AddAnotherCompanyButton);
        common.log("Step :: Click on add another company.");

        String companyName = Common.generateRandomChars(7);
        common.isElementDisplayed(driver, CompanyNameInputField);
       // driver.findElement(By.xpath(CompanyNameInputField)).sendKeys(companyName);
        common.sendKeys(driver , CompanyNameInputField , companyName);
        common.log("Step :: Enter company name :: " + companyName + ".");

        common.isElementDisplayed(driver, CompanyTypeDropdown);
       // driver.findElement(By.xpath(CompanyTypeDropdown)).click();
        common.click(driver , CompanyTypeDropdown);
        common.log("Step :: Click on company type dropdown.");

        List<WebElement> drpOption = driver.findElements(By.xpath(DropdownOptions));

        for (WebElement eachOpt : drpOption) {
            String optName = eachOpt.getText();
            if (optName.equalsIgnoreCase("Private Limited")) {
                eachOpt.click();
                common.log("Step :: Select company type :: Private Limited.");
                break;
            }
        }
        common.isElementDisplayed(driver, CountryDropdown);
        //driver.findElement(By.xpath(CountryDropdown)).click();
        common.click(driver , CountryDropdown);

        List<WebElement> drpOption1 = driver.findElements(By.xpath(DropdownOptions));

        for (WebElement eachOpt : drpOption1) {
            String optName = eachOpt.getText();
            if (optName.equalsIgnoreCase("India")) {
                eachOpt.click();
                common.log("Step :: Select country ::India.");
                break;
            }
        }

        common.isElementDisplayed(driver, PinCodeInputField);
      //  driver.findElement(By.xpath(PinCodeInputField)).sendKeys(config.read_Test_Data("pinCode"));
        common.sendKeys(driver , PinCodeInputField , config.read_Test_Data("pinCode"));
        common.log("Step :: Enter pincode : " + config.read_Test_Data("pinCode") + ".");

        common.pause(5);
        common.isElementDisplayed(driver, companyAssignButton);
     //   driver.findElement(By.xpath(companyAssignButton)).click();
        common.click(driver , companyAssignButton);
        common.log("Step:: Click on assign button.");

        common.pause(2);
        common.isElementDisplayed(driver, companyAssignToMeButton);
        //driver.findElement(By.xpath(companyAssignToMeButton)).click();
        common.click(driver , companyAssignToMeButton);
        common.log("Step:: Click on assign to me button.");

        common.isElementDisplayed(driver, AddLicenceButton);
       // driver.findElement(By.xpath(AddLicenceButton)).click();
        common.click(driver ,  AddLicenceButton);
        common.log("Step :: Click on add licenses button.");

        common.pause(2);
        common.isElementDisplayed(driver, openLicenceDropdown);
       // driver.findElement(By.xpath(openLicenceDropdown)).click();
        common.click(driver , openLicenceDropdown);
        common.log("Step :: Click on licenses dropdown.");

        common.pause(2);
        common.isElementDisplayed(driver, checkboxCDSL);
       // driver.findElement(By.xpath(checkboxCDSL)).click();
        common.click(driver , checkboxCDSL );
        common.click(driver , checkboxCDSL);
        common.log("Step :: Select CDSL license.");

        common.pause(2);
        common.isElementDisplayed(driver, checkboxNSDL);
       // driver.findElement(By.xpath(checkboxNSDL)).click();
        common.click(driver , checkboxNSDL);
        common.log("Step :: Select NSDL license.");

        common.isElementDisplayed(driver, addLicenseButton);
       // driver.findElement(By.xpath(addLicenseButton)).click();
        common.click(driver , addLicenseButton);
        common.log("Step :: Click on add license button.");

        common.isElementDisplayed(driver, createCompanyIcon);
        Assert.assertTrue(driver.findElement(By.xpath(createCompanyIcon)).isEnabled());
      //  driver.findElement(By.xpath(createCompanyIcon)).click();
        common.click(driver , createCompanyIcon);
        common.log("Step :: Click on add company button.");

        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        common.isElementDisplayed(driver, Alert);
        String message = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message + ".");

        common.isElementDisplayed(driver, "(//input[@value='" + companyName + "'])[2]");
        //driver.findElement(By.xpath("//div[@title='" + companyName + "']")).getText();
        common.getText(driver , "//div[@title='" + companyName + "']");
        common.log("Step :: Verify created company name in list :: " + companyName + ".");

        common.isElementDisplayed(driver, "//div[@title='" + companyName + "']//..//..//td[@class='deleteIconCheck']//img");
       // driver.findElement(By.xpath("//div[@title='" + companyName + "']//..//..//td[@class='deleteIconCheck']//img")).click();
        common.click(driver , "//div[@title='" + companyName + "']//..//..//td[@class='deleteIconCheck']//img");
        common.log("Step :: Click on delete icon.");

        common.isElementDisplayed(driver, companyDeleteButton);
        //driver.findElement(By.xpath(companyDeleteButton)).click();
        common.click(driver , companyDeleteButton);
        common.log("Step :: Click on delete button.");

        common.isElementDisplayed(driver, Alert);
        String message1 = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message1 + ".");

    }

    public void verifyChangePasswordFromSettingByCSOfficer() throws IOException, ParseException {

        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("currentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
        approverSettingPage.clickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("revisedCurrentPassword"), config.read_Test_Data("revisedNewPassword"), config.read_Test_Data("revisedConfirmPassword"));
        approverSettingPage.retriveAlert();

        common.pause(2);

    }

    public void verifyChangePasswordByEnteringWrongCurrentPasswordByCSOfficer() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.clickOnSettingsButton();
        approverSettingPage.goToSecurityMenuAndClickOnChangePasswordButton();
        approverSettingPage.confirmCurrentAndNewPassword(config.read_Test_Data("invalidCurrentPassword"), config.read_Test_Data("newPassword"), config.read_Test_Data("confirmPassword"));
        approverSettingPage.retriveAlert();
    }


    public void verifyDeleteTheCreatedMemberFromSettingByCSOfficer() {

        String MemberFullName1 = verifyAddNewMembersFromSettingByCSOfficer();

        common.pause(2);
        common.isElementDisplayed(driver, KebabMenu);
      //  driver.findElement(By.xpath(KebabMenu)).click();
        common.click(driver , KebabMenu);
        common.log("Step :: Click on kebab menu on the created team member.");

        common.pause(1);
        common.isElementDisplayed(driver, DeleteMemberButton);
        //driver.findElement(By.xpath(DeleteMemberButton)).click();
        common.click(driver , DeleteMemberButton);
        common.log("Step :: Click on delete member button.");

        common.isElementDisplayed(driver, DeleteRecordButton);
       // driver.findElement(By.xpath(DeleteRecordButton)).click();
        common.click(driver , DeleteRecordButton);
        common.log("Step :: Click on delete button on the 'Delete company record?' pop-up.");

        common.pause(1);
        common.isElementDisplayed(driver, Alert);
      //  String successMessage1 = driver.findElement(By.xpath(Alert)).getText();
        String successMessage1 = common.getText(driver , Alert);
        common.log("Step :: Verify the message :: " + successMessage1 + ".");

        common.pause(3);
        common.isElementDisplayed(driver, Search_Clear_Field);
  //      driver.findElement(By.xpath(Search_Clear_Field)).clear();
        common.clear(driver , Search_Clear_Field);
        common.log("Step :: Clear searched name.");


        common.isElementDisplayed(driver, CreatedUser);
       // driver.findElement(By.xpath(CreatedUser)).sendKeys(MemberFullName);
        common.sendKeys(driver , CreatedUser , MemberFullName1);
        common.log("Step :: Search the deleted user.");

        common.pause(3);
    }

    public void verifySignupProcessWithValidEmail() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        common.isElementDisplayed(driver, LogoutIcon);
      //  driver.findElement(By.xpath(LogoutIcon)).click();
        common.click(driver, LogoutIcon);
        common.log("Step :: Click on logout icon.");

        common.isElementDisplayed(driver, YesButton);
       // driver.findElement(By.xpath(YesButton)).click();
        common.click(driver, YesButton);
        common.log("Step :: Click on yes.");

        common.pause(2);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get(config.read_Test_Data("emailLoginPageUrl"));
        common.isElementDisplayed(driver, SignInLabel);

        common.pause(4);

        common.isElementDisplayed(driver, IdentifierID);
        String email = config.read_Test_Data("email");
     //   driver.findElement(By.xpath(IdentifierID)).sendKeys(email);
        common.sendKeys(driver , IdentifierID , email);
        common.log("Step :: Enter Email :: " + email);

        common.isElementDisplayed(driver, NextButton);
       // driver.findElement(By.xpath(NextButton)).click();
        common.click(driver , NextButton);
        common.log("Step :: Click on Next button");

        common.pause(2);
        common.isElementDisplayed(driver, PasswordField);
        String emailPWD = config.read_Test_Data("emailPassword");
       // driver.findElement(By.xpath(PasswordField)).sendKeys(emailPWD);
        common.sendKeys(driver , PasswordField , emailPWD);
        common.log("Step :: Enter email :: " + emailPWD + ".");

        common.pause(2);
        common.isElementDisplayed(driver, NextButtonPass);
      //  driver.findElement(By.xpath(NextButtonPass)).click();
        common.click(driver , NextButtonPass);
        common.log("Step :: Click on next button.");

        common.pause(5);
        common.isElementDisplayed(driver, InboxButton);
     //   driver.findElement(By.xpath(InboxButton)).click();
        common.click(driver ,  InboxButton);
        common.log("Step :: Click on inbox.");

        common.pause(10);
        common.isElementDisplayed(driver, RefreshButton);
      //  driver.findElement(By.xpath(RefreshButton)).click();
        common.click(driver , RefreshButton);
        common.log("Step :: Click on refresh icon.");

        common.pause(5);
        common.isElementDisplayed(driver, FirstMail);
       // driver.findElement(By.xpath(FirstMail)).click();
        common.click(driver , FirstMail);
        common.log("Step :: Click on 1st email from inbox.");

        common.pause(2);
        common.isElementDisplayed(driver, MailTitle);
     //   String mailTitle = driver.findElement(By.xpath(MailTitle)).getText();
        String mailTitle = common.getText(driver , MailTitle);
        common.log("Step :: Verify the mail title :: " + mailTitle + ".");

        common.isElementDisplayed(driver, AcceptInvitationButtonInReceivedMail);
       // driver.findElement(By.xpath(AcceptInvitationButtonInReceivedMail)).click();
        common.click(driver , AcceptInvitationButtonInReceivedMail);
        common.log("Step :: Click on accept invitation button in received mail.");
        common.pause(4);

        ArrayList<String> x = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(x.get(2));

        common.pause(4);
        String fullName = Common.generateRandomChars(7);
        common.isElementDisplayed(driver, FullNameInput);
      //  driver.findElement(By.xpath(FullNameInput)).sendKeys(fullName + " TM.");
        common.sendKeys(driver , FullNameInput , fullName + " TM.");
        common.log("Step :: Enter full name: '" + fullName + " TM'.");

        common.isElementDisplayed(driver, MobileNumberInputField);
        String mobileNumber = Common.generateRandomNumberString(10);
        //driver.findElement(By.xpath(MobileNumberInputField)).sendKeys(mobileNumber);
        common.sendKeys(driver , MobileNumberInputField , mobileNumber);
        common.log("Step :: Enter mobile number: " + mobileNumber + ".");

        common.isElementDisplayed(driver, DesignationFieldsignup);
        //driver.findElement(By.xpath(DesignationFieldsignup)).sendKeys(config.read_Test_Data("invitedUserDesignation"));
        common.sendKeys(driver , DesignationFieldsignup , config.read_Test_Data("invitedUserDesignation"));
        common.log("Step :: Enter designation in designation field.");

        common.isElementDisplayed(driver, PasswordInputField);
        //driver.findElement(By.xpath(PasswordInputField)).sendKeys(config.read_Test_Data("invitedUserPassword"));
        common.sendKeys(driver , PasswordInputField , config.read_Test_Data("invitedUserPassword"));
        common.log("Step :: Enter password in password field.");

        common.isElementDisplayed(driver, ConfirmPasswordInputField);
       // driver.findElement(By.xpath(ConfirmPasswordInputField)).sendKeys(config.read_Test_Data("invitedUserConfirmPassword"));
        common.sendKeys(driver , ConfirmPasswordInputField , config.read_Test_Data("invitedUserConfirmPassword"));
        common.log("Step :: Enter confirm password in confirm password field.");

        common.isElementDisplayed(driver, COSaveDetailsButton);
       // driver.findElement(By.xpath(COSaveDetailsButton)).click();
        common.click(driver , COSaveDetailsButton);
        common.log("Step :: Click on save details button.");

        approverSettingPage.retriveAlert();

        common.isElementDisplayed(driver, SecureNowButton);
     //   driver.findElement(By.xpath(SecureNowButton)).click();
        common.click(driver, SecureNowButton);
        common.log("Step :: Click on secure now button.");

        approverSettingPage.retriveAlert();

        common.isElementDisplayed(driver, OTPInputField);
      //  driver.findElement(By.xpath(OTPInputField)).sendKeys(config.read_Test_Data("otp"));
        common.sendKeys(driver , OTPInputField , config.read_Test_Data("otp"));
        common.log("Step :: Enter static OTP :: 334455.");


        common.isElementDisplayed(driver, VerifyButton);
      //  driver.findElement(By.xpath(VerifyButton)).click();
        common.click(driver , VerifyButton);
        common.log("Step :: Click on verify button.");

        approverSettingPage.retriveAlert();

        common.isElementDisplayed(driver, SettingsButton);
     //   driver.findElement(By.xpath(SettingsButton)).click();
        common.click(driver , SettingsButton);
        common.log("Step :: Click on settings icon.");

        common.isElementDisplayed(driver, RightInputRow);
      //  String Role = driver.findElement(By.xpath(RightInputRow)).getAttribute("value");
        String Role = common.getAttribute(driver , RightInputRow);
        common.log("Step :: Verify role :: " + Role + ".");
    }

    public void verifyDeleteAllTaskFromTrash() {
        common.pause(3);
     //   driver.findElement(By.xpath(TrashIcon)).click();
        common.click(driver , TrashIcon);
        common.isElementDisplayed(driver, TrashHeader);
        common.log("Step :: Click on trash icon.");

        for (int i = 0; i < 50; i++) {

            if (common.isDisplayed(CO_DeleteIcon)) {
            //    driver.findElement(By.xpath(CO_DeleteIcon)).click();
                common.click(driver ,  CO_DeleteIcon);
                common.log("Step :: Click on delete icon.");

                common.isElementDisplayed(driver, YesButton);
              //  driver.findElement(By.xpath(YesButton)).click();
                common.click(driver , YesButton);
                common.log("Step :: Click on yes.");
                common.pause(6);
            } else {
                common.log("NO tasks found in trash.");
                break;
            }

        }

    }

    public void verifyCOLogoutFunctionality() {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        approverSettingPage.verifyLogout();
    }
}
