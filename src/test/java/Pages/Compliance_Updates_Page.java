package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Compliance_Updates_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Compliance_Updates_Page(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnUpdatesMenu() throws InterruptedException {
        common.pause(3);
        common.isElementDisplayed(driver, UpdatesMenu);
        common.click(driver , UpdatesMenu);
        common.log("Step :: Click on updates menu.");
        common.pause(2);
    }

    public void verifySearchUpdateFromUpdatesList() throws InterruptedException {
        common.isElementDisplayed(driver, FirstUpdate);
        String updateName = common.getText(driver , FirstUpdate);
        common.log("Step :: Get the 1st update name :: " + updateName + ".");

        common.isElementDisplayed(driver, SearchIconUpdates);
        common.click(driver , SearchIconUpdates);
        common.log("Step :: Click on search icon.");

        common.isElementDisplayed(driver, SearchUpdateField);
        common.sendKeys(driver , SearchUpdateField , updateName);
        common.log("Step :: Enter the update name :: " + updateName + ".");

        common.isElementDisplayed(driver, SearchedUpdateTitle);
        String searchedUpdate = common.getText(driver , SearchedUpdateTitle);
        common.log("Step :: Get the searched update name :: " + searchedUpdate + ".");

        try {
            Assert.assertEquals(updateName, searchedUpdate);
        } catch (AssertionError e) {
            System.out.println("Entered update not matched with found update.");
            throw e;
        }
        System.out.println("Entered update matched with found update.");
    }

    public void verifySelectMoreThan12Updates() throws InterruptedException {
        common.isElementDisplayed(driver, SelectAll);
        common.click(driver , SelectAll);
        common.log("Step :: Click on select all checkbox.");

        common.isElementDisplayed(driver, Select13thUpdate);
        common.click(driver , Select13thUpdate);
        common.log("Step :: Select 13th update checkbox.");

    }

    public void verifySearchOneMonthEmailLogs() throws InterruptedException {

        common.pause(2);
        common.isElementDisplayed(driver, EmailLogButton);
        common.click(driver , EmailLogButton);
        common.log("Step :: Click on email log button.");

        common.pause(2);
        common.isElementDisplayed(driver, StartDateField);
        common.click(driver , StartDateField);
        common.log("Step :: Click on start date field.");

        common.isElementDisplayed(driver, HeaderPrevButton);
        common.click(driver , HeaderPrevButton);
        common.log("Step :: Click on previous icon in date picker.");

        common.isElementDisplayed(driver, LastMonthFirstDate);
        common.click(driver , LastMonthFirstDate);
        common.log("Step :: Select last month 1st date.");

        common.isElementDisplayed(driver, EndDateField);
        common.click(driver , EndDateField);
        common.log("Step :: Click on end date field.");

        common.isElementDisplayed(driver, TodaysDate);
        common.click(driver , TodaysDate);
        common.log("Step :: Select today's date in end date calendar.");

    }

    public void verifySendUpdatesViaEmail() throws InterruptedException, IOException, ParseException {
        Approver_Setting_Page approverSettingPage = new Approver_Setting_Page(driver);
        common.isElementDisplayed(driver, FirstUpdate);
        String UpdateName = common.getText(driver, FirstUpdate);
        common.log("Step :: Get the 1st update name :: " + UpdateName + ".");

        common.isElementDisplayed(driver, FirstUpdateCheckbox);
        common.click(driver , FirstUpdateCheckbox);
        Assert.assertTrue(driver.findElement(By.xpath(FirstUpdateCheckbox)).isSelected());
        common.log("Step :: Select any update from update menu" + ".");
        common.pause(2);

        common.isElementDisplayed(driver, SendEmailButton);
        common.click(driver , SendEmailButton);
        common.log("Step :: Click on send email button.");
        common.pause(2);

        common.isElementDisplayed(driver, SelectAllUsers);
        common.click(driver , SelectAllUsers);
        common.log("Step :: Click on select all checkbox in users.");


        common.isElementDisplayed(driver, SendMailButton);
        common.click(driver , SendMailButton);
        common.log("Step :: Click on send mail button.");

        common.isElementDisplayed(driver, Alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Alert)));
        String message = driver.findElement(By.xpath(Alert)).getText();
        common.pause(6);
        common.log("Step :: Got alert as :: " + message + ".");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get(config.read_Test_Data("emailLoginPageUrl"));

        common.pause(3);

        String email = config.read_Test_Data("email");
        common.isElementDisplayed(driver, IdentifierID);
        common.sendKeys(driver , IdentifierID ,email);
        common.log("Step :: Enter Email :: " + email + ".");

        common.isElementDisplayed(driver, NextButton);
        common.click(driver , NextButton);
        common.log("Step :: Click on next button.");

        common.pause(3);

        common.isElementDisplayed(driver, PasswordField);
        String emailPWD = config.read_Test_Data("emailPassword");
        common.sendKeys(driver , PasswordField , emailPWD);
        common.log("Step :: Enter email :: " + emailPWD + ".");

        common.isElementDisplayed(driver, NextButtonPass);
        common.click(driver , NextButtonPass);
        common.log("Step :: Click on next button.");

        common.isElementDisplayed(driver, InboxButton);
        common.click(driver , InboxButton);
        common.log("Step :: Click on inbox.");

        common.pause(8);

        common.isElementDisplayed(driver, RefreshButton);
        common.click(driver , RefreshButton);
        common.log("Step :: Click on refresh icon.");

        common.pause(10);

        common.isElementDisplayed(driver, FirstMail);
        common.click(driver , FirstMail);
        common.log("Step :: Click on 1st email from inbox.");

        common.isElementDisplayed(driver, MailTitle);
        String mailTitle = common.getText(driver , MailTitle);
        common.log("Step :: Verify the mail title :: " + mailTitle + ".");

        try {
            Assert.assertEquals(UpdateName, mailTitle);
        } catch (AssertionError e) {
            common.log("CS sent update not matched with received in mailbox.");
            throw e;
        }
        common.log("CS sent update matched with received in mailbox.");
    }


}
