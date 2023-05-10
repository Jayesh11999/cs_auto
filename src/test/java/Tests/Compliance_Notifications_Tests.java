package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.CO_Dashboard_Page;
import Pages.Compliance_Login_Page;
import Pages.Compliance_Notifications_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Compliance_Notifications_Tests extends Configuration {

    //1
    @Test
    public void verifyApprovedFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyApprovedFilterInNotificationsMenu();

    }

    //2
    @Test
    public void verifyAssignedFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyAssignedFilterInNotificationsMenu();

    }

    //3
    @Test
    public void verifyTasksFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyTasksFilterInNotificationsMenu();

    }

    //4
    @Test
    public void verifyUpdatesFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyUpdatesFilterInNotificationsMenu();

    }

    //5
    @Test
    public void verifyRejectedFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyRejectedFilterInNotificationsMenu();

    }

    //6
    @Test
    public void verifyReassignedFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyReassignedFilterInNotificationsMenu();

    }

    //7
    @Test
    public void verifyCommentFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyCommentFilterInNotificationsMenu();

    }

    //8
    @Test
    public void verifyAllNotificationsFilterInNotificationsMenu() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.clickOnNotificationFilterDropdown();
        complianceNotificationsPage.verifyAllNotificationsFilterInNotificationsMenu();

    }

    //9
    @Test
    public void verifySearchNotificationsWithValidDetails() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.verifySearchNotificationsWithValidDetails();

    }

    //10
    @Test
    public void verifySearchNotificationsWithInvalidTaskName() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        Compliance_Notifications_Page complianceNotificationsPage = new Compliance_Notifications_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        complianceNotificationsPage.clickOnNotificationMenuButton();
        complianceNotificationsPage.verifySearchNotificationsWithInvalidTaskName();

    }

}