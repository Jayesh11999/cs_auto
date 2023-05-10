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

public class SignUp_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public SignUp_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void signUp() throws IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);

        common.isElementDisplayed(driver, companyNameOnLandingPage);
        String compName = common.getText(driver , companyNameOnLandingPage);
        common.log("Step :: Verified company branding on landing page: " + compName + ".");

        common.isElementDisplayed(driver, getStartedButton);
        common.click(driver , getStartedButton);
        common.log("Step :: Click on 'get started' button.");

        common.isElementDisplayed(driver, verifyEmailButton);
        boolean verifyButtonDisabled = common.isEnabled(driver , verifyEmailButton);
        Assert.assertFalse(verifyButtonDisabled);
        common.log("Step :: Verified before entering email, verify email button is disabled.");

        common.isElementDisplayed(driver, companyEmailInputField);
        String emailAddress = Common.generateRandomChars(4);
        common.sendKeys(driver , companyEmailInputField ,"rahuld+" + emailAddress + "@perfectqaservices.com");
        common.log("Step :: Enter email id :: " + "rahuld+" + emailAddress + "@perfectqaservices.com");

        common.isElementDisplayed(driver, verifyEmailButton);
        common.click(driver , verifyEmailButton);
        common.log("Step :: click on verify email button.");

        approverSettingPage.retriveAlert();

        common.pause(2);
        common.isElementDisplayed(driver, termsAndConditionsCheckBox);
      //  driver.findElement(By.xpath(termsAndConditionsCheckBox)).click();
        common.click(driver , termsAndConditionsCheckBox);
        common.log("Step :: Click on 'terms and conditions' checkbox.");

        common.isElementDisplayed(driver, verifyEmailButton);
       // driver.findElement(By.xpath(verifyEmailButton)).click();
        common.click(driver , verifyEmailButton);
        common.log("Step :: click on verify email button.");

        approverSettingPage.retriveAlert();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get(config.read_Test_Data("emailLoginPageUrl"));
        common.isElementDisplayed(driver, SignInLabel);

        common.pause(4);

        common.isElementDisplayed(driver, IdentifierID);
        String email = config.read_Test_Data("email");
      //  driver.findElement(By.xpath(IdentifierID)).sendKeys(email);
        common.sendKeys(driver , IdentifierID , email);
        common.log("Step :: Enter email :: " + email);

        common.isElementDisplayed(driver, NextButton);
      //  driver.findElement(By.xpath(NextButton)).click();
        common.click(driver , NextButton);
        common.log("Step :: Click on next button");

        common.pause(2);
        common.isElementDisplayed(driver, PasswordField);
        String emailPWD = config.read_Test_Data("emailPassword");
       // driver.findElement(By.xpath(PasswordField)).sendKeys(emailPWD);
        common.sendKeys(driver , PasswordField , emailPWD);
        common.log("Step :: Enter password :: " + emailPWD + ".");

        common.pause(2);
        common.isElementDisplayed(driver, NextButtonPass);
      //  driver.findElement(By.xpath(NextButtonPass)).click();
        common.click(driver , NextButtonPass);
        common.log("Step :: Click on next button.");

        common.pause(5);
        common.isElementDisplayed(driver, InboxButton);
       // driver.findElement(By.xpath(InboxButton)).click();
        common.click(driver , InboxButton);
        common.log("Step :: Click on inbox.");

        common.pause(10);
        common.isElementDisplayed(driver, RefreshButton);
       // driver.findElement(By.xpath(RefreshButton)).click();
        common.click(driver , RefreshButton);
        common.log("Step :: Click on refresh icon.");

        common.pause(5);
        common.isElementDisplayed(driver, FirstMail);
       // driver.findElement(By.xpath(FirstMail)).click();
        common.click(driver , FirstMail);
        common.log("Step :: Click on 1st email from inbox.");

        common.pause(2);
        common.isElementDisplayed(driver, MailTitle);
       // String mailTitle = driver.findElement(By.xpath(MailTitle)).getText();
        String mailTitle = common.getText(driver , MailTitle);
        common.log("Step :: Verify the mail title :: " + mailTitle + ".");

        common.isElementDisplayed(driver, getVerifyButton);
       // driver.findElement(By.xpath(getVerifyButton)).click();
        common.click(driver , getVerifyButton);
        common.log("Step :: Click on accept invitation button in received mail.");
        common.pause(4);

        ArrayList<String> x = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(x.get(2));

        common.pause(4);
        String fullName = Common.generateRandomChars(7);
        common.isElementDisplayed(driver, FullNameInput);
        //driver.findElement(By.xpath(FullNameInput)).sendKeys(fullName + " TM.");
        common.sendKeys(driver , FullNameInput , fullName + " TM.");
        common.log("Step :: Enter full name: '" + fullName + " TM'.");

        common.isElementDisplayed(driver, MobileNumberInputField);
        String mobileNumber = Common.generateRandomNumberString(10);
        //driver.findElement(By.xpath(MobileNumberInputField)).sendKeys(mobileNumber);
        common.sendKeys(driver , MobileNumberInputField , mobileNumber);
        common.log("Step :: Enter mobile number: " + mobileNumber + ".");

        common.isElementDisplayed(driver, DesignationFieldsignup);
       // driver.findElement(By.xpath(DesignationFieldsignup)).sendKeys(config.read_Test_Data("invitedUserDesignation"));
        common.sendKeys(driver , DesignationFieldsignup , config.read_Test_Data("invitedUserDesignation"));
        common.log("Step :: Enter designation in designation field.");

        common.isElementDisplayed(driver, PasswordInputField);
       // driver.findElement(By.xpath(PasswordInputField)).sendKeys(config.read_Test_Data("invitedUserPassword"));
        common.sendKeys(driver , PasswordInputField , config.read_Test_Data("invitedUserPassword"));
        common.log("Step :: Enter password in password field.");

        common.isElementDisplayed(driver, ConfirmPasswordInputField);
       // driver.findElement(By.xpath(ConfirmPasswordInputField)).sendKeys(config.read_Test_Data("invitedUserConfirmPassword"));
        common.sendKeys(driver , ConfirmPasswordInputField , config.read_Test_Data("invitedUserConfirmPassword"));
        common.log("Step :: Enter confirm password in confirm password field.");

        common.isElementDisplayed(driver, COSaveDetailsButton);
      //  driver.findElement(By.xpath(COSaveDetailsButton)).click();
        common.click(driver, COSaveDetailsButton);
        common.log("Step :: Click on save details button.");

        approverSettingPage.retriveAlert();

        try {
            common.isElementDisplayed(driver, pageTitle);
           // String companyPage = driver.findElement(By.xpath(pageTitle)).getText();
            String companyPage = common.getText(driver , pageTitle);
            common.log("Step :: Get new page title : " + companyPage + ".");

            String companyName = Common.generateRandomChars(7);

            common.isElementDisplayed(driver, companyNameInputField);
            //driver.findElement(By.xpath(companyNameInputField)).sendKeys(companyName);
            common.sendKeys(driver , companyNameInputField , companyName);
            common.log("Step :: Entered company name " + companyName + ".");

            common.isElementDisplayed(driver, signUpCompanyTypeDropdown);
            //driver.findElement(By.xpath(signUpCompanyTypeDropdown)).click();
            common.click(driver , signUpCompanyTypeDropdown);
            common.log("Step :: Click on company type dropdown.");
            common.pause(2);

            List<WebElement> drpOption = driver.findElements(By.xpath(companyTypeListInDropdown));

            for (WebElement eachOpt : drpOption) {
                String optName = eachOpt.getText();
                if (optName.equalsIgnoreCase("Private Limited")) {
                    eachOpt.click();
                    common.log("Step :: Select company type :: Private Limited.");
                    break;
                }
            }

            common.pause(3);

            common.isElementDisplayed(driver, signUpCountryDropdown);
           // driver.findElement(By.xpath(signUpCountryDropdown)).click();
            common.click(driver , signUpCountryDropdown);
            common.log("Step :: Click on country dropdown.");

            List<WebElement> drp1Option = driver.findElements(By.xpath(countryListInDropdown));

            for (WebElement eachOpt : drp1Option) {
                String optName = eachOpt.getText();
                if (optName.equalsIgnoreCase("India")) {
                    eachOpt.click();
                    common.log("Step :: Select country :: India.");
                    break;
                }
            }

            common.isElementDisplayed(driver, pinCodeInputField);
          //  driver.findElement(By.xpath(pinCodeInputField)).sendKeys(config.read_Test_Data("pinCode"));
            common.sendKeys(driver , pinCodeInputField ,config.read_Test_Data("pinCode"));
            common.log("Step :: Enter pin code.");
            common.pause(5);

            common.isElementDisplayed(driver, signUpAddLicenseButton);
            common.click(driver , signUpAddLicenseButton);
            common.log("Step :: Click on add license button.");
            common.pause(2);

            common.isElementDisplayed(driver, depositoryParticipantsDropDrown);
            common.click(driver , depositoryParticipantsDropDrown);
            common.log("Step :: Click on depository participants dropdown.");

            common.pause(2);
            common.isElementDisplayed(driver, checkboxCDSL);
            common.click(driver , checkboxCDSL);
            common.log("Step :: Select CDSL license.");

            common.pause(2);
            common.isElementDisplayed(driver, checkboxNSDL);
            common.click(driver , checkboxNSDL);
            common.log("Step :: Select NSDL license.");

            common.isElementDisplayed(driver, addLicenseButton);
            common.click(driver , addLicenseButton);
            common.log("Step :: Click on add license button.");

            common.isElementDisplayed(driver, doneButton);
            common.click(driver , doneButton);
            common.log("Step :: Click on done button.");

            common.isElementDisplayed(driver, Alert);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Alert)));
            String message = driver.findElement(By.xpath(Alert)).getText();
            common.pause(6);
            common.log("Step :: Got alert as :: " + message + ".");

            common.pause(5);
            common.isElementDisplayed(driver , SecureNowButton);

        } catch (Exception e) {
            System.out.println(e);
            common.isElementDisplayed(driver, skipButton);
            common.click(driver , skipButton);
            common.log("Step :: Something wrong so click on skip button.");
        }

        common.pause(5);

        common.isElementDisplayed(driver, SecureNowButton);
        common.click(driver , SecureNowButton);
        common.log("Step :: Click on secure now button.");

        approverSettingPage.retriveAlert();

        common.isElementDisplayed(driver, OTPInputField);
        common.sendKeys(driver , OTPInputField , config.read_Test_Data("otp"));
        common.log("Step :: Enter static OTP :: 334455.");

        common.isElementDisplayed(driver, VerifyButton);
        common.click(driver , VerifyButton);
        common.log("Step :: Click on verify button.");

        approverSettingPage.retriveAlert();

        common.isElementDisplayed(driver, SettingsButton);
        common.click(driver , SettingsButton);
        common.log("Step :: Click on settings icon.");

        common.isElementDisplayed(driver, RightInputRow);
        String Role = common.getAttribute(driver , RightInputRow);
        common.log("Step :: Verify role :: " + Role + ".");
    }


}