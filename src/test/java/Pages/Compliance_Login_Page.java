package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class Compliance_Login_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Compliance_Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginCredentials(String UserName) throws IOException, org.json.simple.parser.ParseException {
        String Mail;
        if (UserName.equalsIgnoreCase("ComplianceOfficer")) {
            Mail = common.read_json("ComplianceOfficerMail");
            common.isElementDisplayed(driver, ComplianceOfficerEmailField);
          //  driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.sendKeys(driver , ComplianceOfficerEmailField , Mail);
            common.log("Step :: Enter compliance officer email address.");
        }
        if (UserName.equalsIgnoreCase("TeamMember")) {
            Mail = common.read_json("TeamMemberMail");
            common.isElementDisplayed(driver, ComplianceOfficerEmailField);
            //driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.sendKeys(driver ,ComplianceOfficerEmailField , Mail);
            common.log("Step :: Enter team member email address.");
        }
        if (UserName.equalsIgnoreCase("Approver")) {
            Mail = common.read_json("ApproverMail");
            common.isElementDisplayed(driver, ComplianceOfficerEmailField);
            //driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.sendKeys(driver ,ComplianceOfficerEmailField , Mail);
            common.log("Step :: Enter approver email address.");
        }

        String Password = common.read_json("UserPassword");
        common.isElementDisplayed(driver, ComplianceOfficerPasswordField);
        //driver.findElement(By.xpath(ComplianceOfficerPasswordField)).sendKeys(Password);
        common.sendKeys(driver ,ComplianceOfficerPasswordField , Password);
        common.log("Step :: Enter password.");
    }

    public void verifyLogin() throws InterruptedException {
        common.isElementDisplayed(driver, SubmitButton_Login);
       // driver.findElement(By.xpath(SubmitButton_Login)).click();
        common.click(driver , SubmitButton_Login);
        common.log("Step :: Click on login button.");
        if (common.isDisplayed(Tasks_Header) == true) {
            common.log("Step :: User is successfully logged in.");
        }
        common.isElementDisplayed(driver, WelcomeHeader_SideBar);
    }

    public void goToLoginPage() {
        common.pause(3);
        ;
        common.isElementDisplayed(driver, LoginButton);
        //driver.findElement(By.xpath(LoginButton)).click();
        common.click(driver , LoginButton);
        common.log("Step :: Click on login button.");
    }

    public void verifyLoginWithValidComplianceOfficerCredentials() throws AWTException, IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        goToLoginPage();
        enterLoginCredentials("ComplianceOfficer");
        verifyLogin();
    }

    public void verifyLoginWithValidTeamMemberCredentials() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        goToLoginPage();
        enterLoginCredentials("TeamMember");
        verifyLogin();
    }

    public void verifyLoginWithValidApproverCredentials() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        goToLoginPage();
        enterLoginCredentials("Approver");
        verifyLogin();
    }

}