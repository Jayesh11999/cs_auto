package Tests;

import Config.Configuration;
import Config.RetryAnalyzer;
import Pages.CO_Dashboard_Page;
import Pages.Compliance_Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CO_Dashboard_Tests extends Configuration {


    //1
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_Overdue_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_OverdueTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts();
        coDashboardPage.verifyTasksCount();

    }

    //2
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_Today_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_TodayTotalCountsWith_AssignToMe_AssignToOthers_NotAssigned_Counts();
        coDashboardPage.verifyTasksCount();
    }

    //3
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_Next6Days_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_Next6DaysTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts();
        coDashboardPage.verifyTasksCount();
    }

    //4
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_8To30Days_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_8To30Days_TotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts();
        coDashboardPage.verifyTasksCount();
    }

    //5
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_Beyond30Days_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws AWTException, IOException, ParseException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_Beyond30DaysTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts();
        coDashboardPage.verifyTasksCount();

    }

    //6
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_TotalMenu_TotalCounts_With_AssignToMe_AssignToOthers_NotAssigned_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_TotalMenu_TotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts();
        coDashboardPage.verifyTasksCount();
    }

    //7
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_ApprovalPendingMenu_TotalCounts_With_ApprovalPendingByMe_ApprovalPendingByOthers_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_ApprovalPending_TotalCountWith_ApprovalPendingByMe_ApprovalPendingByOthers();
    }

    //8
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_RejectedTasksTotalCountsWith_AssignToMe_AssignToOthers_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_RejectedTasksTotalCountsWith_AssignToMe_AssignToOthers_Counts();
    }


    //9
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_CompletedMenu_TotalCounts_With_CompletedByMe_CompletedByOthers_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_CompletedMenu_TotalCountsWith_CompletedByMe_CompletedByOthers();
    }

    //10
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_OverdueTotalCount_With_OverduePage_AllTask_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_OverdueTotalCountWith_OverduePageAllTaskCounts();
    }

    //11
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_TodayTotalCount_With_TodayPage_AllTask_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_TodayTotalCountWith_TodayPageAllTaskCounts();
    }

    //12
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_Next6DaysTotalCount_With_Next6DaysPage_AllTask_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_Next6DaysTotalCountWith_Next6DaysPageAllTaskCounts();
    }

    //13
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_8To30DaysTotalCount_With_8To30DaysPage_AllTask_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_8To3DaysTotalCountWith_8To30DaysPageAllTaskCounts();
    }

    //14
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_Beyond30DaysTotalCount_With_Beyond30DaysPage_AllTask_Counts() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_Beyond30DaysTotalCountWith_Beyond30DaysPageAllTaskCounts();
    }

    //15
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_TotalMenuTotalCount_With_TotalPage_AllTasks_Count() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_TotalMenuTotalCountWith_TotalPageAllTasksCount();
    }

    //16
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_ApprovalPendingMenuTotalCountWith_ApprovalPendingAllTasks_Count() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_ApprovalPendingMenuTotalCountWith_ApprovalPendingAllTasksCount();
    }

    //17
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_CompletedMenuTotalCount_With_CompletedAndRequestedPage_AllTasks_Count() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_CompletedMenuTotalCountWith_CompletedPageAllTasksCount();
    }

    //18
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_DashboardTaskAnalytics_RejectedTasksMenuTotalCountWith_RejectedTasksPageAllTasks_Count() throws IOException, ParseException, AWTException, InterruptedException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verify_DashboardTaskAnalytics_RejectedTasksMenuTotalCountWith_RejectedTasksPageAllTasksCount();
    }


    //19
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verify_Task_Repetition_Updates() throws IOException, ParseException, InterruptedException, AWTException {
        Compliance_Login_Page complianceLoginPage = new Compliance_Login_Page(driver);
        CO_Dashboard_Page coDashboardPage = new CO_Dashboard_Page(driver);
        Compliance_Login_Page co_Login = new Compliance_Login_Page(driver);
        co_Login.goToLoginPage();
        co_Login.enterLoginCredentials("ComplianceOfficer");
        co_Login.verifyLogin();
        coDashboardPage.verifyTasksUpdates();
    }
}