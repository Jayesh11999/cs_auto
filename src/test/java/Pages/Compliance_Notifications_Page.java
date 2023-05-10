package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class Compliance_Notifications_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();


    public Compliance_Notifications_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNotificationMenuButton() {
        common.pause(3);
        common.isElementDisplayed(driver, NotificationMenuButton);
        common.click(driver , NotificationMenuButton);
        common.log("Step :: Click on notification menu.");
    }

    public void clickOnNotificationFilterDropdown() {
        common.pause(1);
        common.isElementDisplayed(driver, NotificationFilterDropdown);
        common.click(driver ,NotificationFilterDropdown );
        common.log("Step :: Click on notification filter dropdown.");
    }

    public void verifyApprovedFilterInNotificationsMenu() throws InterruptedException {
        common.isElementDisplayed(driver, ApprovedOption);
        common.click(driver , ApprovedOption);
        common.log("Step :: Select approved option from dropdown.");

        common.pause(2);
        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {

            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver , TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");
            common.pause(2);
        } else {

            common.log("No notification found.");

        }

    }

    public void verifyAssignedFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, AssignedOption);
        common.click(driver , AssignedOption);
        common.log("Step :: Select assigned option from dropdown.");

        common.pause(2);
        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {
            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver , TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");
            common.pause(2);
        } else {

            common.log("No notification found.");
        }
    }

    public void verifyTasksFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, TaskOption);
        common.click(driver , TaskOption);
        common.log("Step :: Select tasks option from dropdown.");
        common.pause(2);

        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {
            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = driver.findElement(By.xpath(TaskStatus)).getText();

            common.log("Step :: Verify the task status :: " + taskStatus + ".");
            common.pause(2);
        } else {

            common.log("No notification found.");
        }

    }

    public void verifyUpdatesFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, UpdatesOption);

        common.click(driver , UpdatesOption);
        common.log("Step :: Select updates option from dropdown.");
        common.pause(2);

        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {
            String notificationName = driver.findElement(By.xpath(VerifyNotification)).getText();
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, UpdateTitle);
            String taskStatus = common.getText(driver , UpdateTitle);
            common.log("Step :: Verify the update title :: " + taskStatus + ".");
            common.pause(2);


        } else {

            common.log("No notification found.");
        }

    }

    public void verifyRejectedFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, RejectedOption);
        common.click(driver , RejectedOption);
        common.log("Step :: Select rejected option from dropdown.");
        common.pause(2);

        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {

            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver , TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");
            common.pause(2);

        } else {

            common.log("No notification found.");

        }
    }

    public void verifyReassignedFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, ReassignedOption);
        common.click(driver , ReassignedOption);
        common.log("Step :: Select reassigned option from dropdown.");

        common.pause(2);

        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {

            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver,TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");

            common.pause(2);
        } else {

            common.log("No notification found.");
        }

    }

    public void verifyCommentFilterInNotificationsMenu() throws InterruptedException {


        common.isElementDisplayed(driver, CommentOption);
        common.click(driver , CommentOption);
        common.log("Step :: Select comment option from dropdown.");

        common.pause(2);
        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {

            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver , TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");

            common.pause(2);
        } else {

            common.log("No notification found.");
        }

    }

    public void verifyAllNotificationsFilterInNotificationsMenu() throws InterruptedException {



        common.isElementDisplayed(driver, AllNotificationsOption);
        common.click(driver, AllNotificationsOption);
        common.log("Step :: Select all option from dropdown.");

        common.pause(2);
        if (common.ifElementIsDisplayed(driver, VerifyNotification) == true) {

            String notificationName = common.getText(driver , VerifyNotification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, VerifyNotification);
            common.click(driver , VerifyNotification);
            common.log("Step :: Click on 1st notification.");

            common.isElementDisplayed(driver, TaskStatus);
            String taskStatus = common.getText(driver , TaskStatus);
            common.log("Step :: Verify the task status :: " + taskStatus + ".");

            common.pause(2);
        } else {

            common.log("No notification found.");
        }
    }

    public void verifySearchNotificationsWithValidDetails() {


        common.pause(2);

        if (driver.findElement(By.xpath(Notification)).isDisplayed()) {

            String notificationName = common.getText(driver , Notification);
            common.log("Step :: Verify any notification :: " + notificationName + ".");

            common.isElementDisplayed(driver, SearchNotification);
            common.click(driver , SearchNotification);
            common.log("Step :: Click on search icon.");

            common.isElementDisplayed(driver, TaskNameField);
            common.sendKeys(driver , TaskNameField , notificationName);
            common.log("Step :: Enter task name :: " + notificationName + ".");

            common.isElementDisplayed(driver, Notification);
            String taskName = common.getText(driver , Notification);
            common.log("Step :: Verify any Notification :: " + taskName + ".");

            common.pause(2);

            try {
                Assert.assertEquals(notificationName, taskName);
            } catch (AssertionError e) {
                common.log("Searched task not matched.");
                throw e;
            }
            common.log("Searched task matched.");

        } else if (driver.findElement(By.xpath(NoNotificationFound)).isDisplayed()) {

            common.log("No notification found.");
        }
    }

    public void verifySearchNotificationsWithInvalidTaskName() throws IOException, ParseException {

        common.isElementDisplayed(driver, SearchNotification);
        common.click(driver , SearchNotification);
        common.log("Step :: Click on search icon.");

        common.isElementDisplayed(driver, TaskNameField);
        common.sendKeys(driver , TaskNameField , config.read_Test_Data("invalidTaskName"));
        common.log("Step :: Enter invalid task name.");

        common.isElementDisplayed(driver, NotificationMessage);
        String taskMessage = common.getText(driver , NotificationMessage);
        common.log("Step :: Verify the message" + taskMessage + ".");

        common.pause(2);
    }

}
