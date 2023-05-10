package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CO_Dashboard_Page extends Abstract {

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public CO_Dashboard_Page(WebDriver driver) {
        this.driver = driver;
    }

    SoftAssert softAssert = new SoftAssert();

    public void verifyTasksCount() {

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String activeTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + activeTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        common.isElementVisible(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, AssignedToMeCount);
        String assignedToMe1 = driver.findElement(By.xpath(AssignedToMeCount)).getText();
        int assignedToMe = Integer.parseInt(assignedToMe1);
        common.log("Step :: Verify the assigned to me count :: " + assignedToMe + ".");

        common.isElementDisplayed(driver, AssignedToOthersCount);
        int assignedToOthers = Integer.parseInt(common.getText(driver , AssignedToOthersCount));
        common.log("Step :: Verify the assigned to others count :: " + assignedToOthers + ".");

        common.isElementDisplayed(driver, NotAssignedCount);
        String notAssigned1 = common.getText(driver , NotAssignedCount);
        int notAssigned = Integer.parseInt(notAssigned1);
        common.log("Step :: Verify the not assigned count :: " + notAssigned + ".");

        int sumValue = assignedToMe + assignedToOthers + notAssigned;
        common.log("Step :: Total sum of assigned to me , assigned to others , not assigned :: " + sumValue + ".");

        try {
            Assert.assertEquals(allCount, sumValue);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with assigned to me , assigned to others , not assigned.");
            throw e;
        }
        common.log("Step :: All counts matched with assigned to me , assigned to others , not assigned.");
        common.pause(2);
    }

    public void verify_OverdueTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts() {
        common.pause(2);
        common.isElementDisplayed(driver, OverDueMenu);
        common.click(driver , OverDueMenu);
        common.log("Step :: Click on overdue menu.");
    }

    public void verify_TodayTotalCountsWith_AssignToMe_AssignToOthers_NotAssigned_Counts() {

        common.pause(2);
        common.isElementDisplayed(driver, TodayMenu);
        common.click(driver , TodayMenu);
        common.log("Step :: Click on today menu.");
    }

    public void verify_Next6DaysTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts() {

        common.pause(2);
        common.isElementDisplayed(driver, Next6DaysMenu);
        common.click(driver , Next6DaysMenu);
        common.log("Step :: Click on next 6 days menu.");
    }

    public void verify_8To30Days_TotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts() {

        common.pause(2);
        common.isElementDisplayed(driver, CO8To30DaysMenu);
        common.click(driver , CO8To30DaysMenu);
        common.log("Step :: Click on 8 to 30 days menu.");



    }

    public void verify_Beyond30DaysTotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts() {

        common.pause(2);
        common.isElementDisplayed(driver, Beyond30DaysMenu);
        common.click(driver , Beyond30DaysMenu);
        common.log("Step :: Click on beyond 30 days menu.");

    }

    public void verify_TotalMenu_TotalCountsWith_AssignToMe_AssignToOthers_NotAssignedCounts() {

        common.pause(2);
        common.isElementDisplayed(driver, TotalMenu);
        common.click(driver , TotalMenu);
        common.log("Step :: Click on total menu.");


    }

    public void verify_RejectedTasksTotalCountsWith_AssignToMe_AssignToOthers_Counts() {

        common.pause(2);
        common.isElementDisplayed(driver, rejectedTasks);
        common.click(driver , rejectedTasks);
        common.log("Step :: Click on beyond 30 days menu.");

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String activeTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + activeTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, AssignedToMeCount);
        String assignedToMe1 = common.getText(driver , AssignedToMeCount);
        int assignedToMe = Integer.parseInt(assignedToMe1);
        common.log("Step :: Verify the assigned to me count :: " + assignedToMe + ".");

        common.isElementDisplayed(driver, AssignedToOthersCount);
        int assignedToOthers = Integer.parseInt(driver.findElement(By.xpath(AssignedToOthersCount)).getText());
        common.log("Step :: Verify the assigned to others count :: " + assignedToOthers + ".");

        int sumValue = assignedToMe + assignedToOthers;
        common.log("Step :: Total sum of assigned to me , assigned to others :: " + sumValue + ".");

        try {
            Assert.assertEquals(allCount, sumValue);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with assigned to me , assigned to others.");
            throw e;
        }
        common.log("Step :: All counts matched with assigned to me , assigned to others.");
        common.pause(2);

    }

    public void verify_ApprovalPending_TotalCountWith_ApprovalPendingByMe_ApprovalPendingByOthers() {
        common.pause(2);
        common.isElementDisplayed(driver, approvalPending);
        common.click(driver , approvalPending);
        common.log("Step :: Click on approval pending menu.");

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String activeTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + activeTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, approvalPendingByMeCount);
        String approvalPendingByMe1 = common.getText(driver , approvalPendingByMeCount);
        int approvalPendingByMe = Integer.parseInt(approvalPendingByMe1);
        common.log("Step :: Verify the approval pending by me count :: " + approvalPendingByMe + ".");

        common.isElementDisplayed(driver, approvalPendingByOthersCount);
        String approvalPendingByOthers1 = common.getText(driver , approvalPendingByOthersCount);
        int approvalPendingByOthers = Integer.parseInt(approvalPendingByOthers1);
        common.log("Step :: Verify the approval pending by others count :: " + approvalPendingByOthers + ".");

        int sumValue = approvalPendingByMe + approvalPendingByOthers;
        common.log("Step :: Total sum of approval pending by me, approval pending by others :: " + sumValue + ".");

        try {
            Assert.assertEquals(allCount, sumValue);
        } catch (AssertionError e) {
            System.out.println("Step :: All counts not matched with approval pending by me, approval pending by others.");
            throw e;
        }
        common.log("Step :: All counts matched with approval pending by me, approval pending by others.");


    }

    public void verify_CompletedMenu_TotalCountsWith_CompletedByMe_CompletedByOthers() {

        common.pause(2);
        common.isElementDisplayed(driver, CompleteMenu);
        common.click(driver , CompleteMenu);
        common.log("Step :: Click on completed menu.");

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String completedTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + completedTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, completedByMe);
        String completedByMe1 = common.getText(driver , completedByMe);
        int completedByMe = Integer.parseInt(completedByMe1);
        common.log("Step :: Verify the assigned to me count :: " + completedByMe + ".");

        common.isElementDisplayed(driver, completedByOthers);
        String completedByOthers1 = common.getText(driver , completedByOthers);
        int completedByOthers = Integer.parseInt(completedByOthers1);
        common.log("Step :: Verify the assigned to others count :: " + completedByOthers + ".");

        int sumValue = completedByMe + completedByOthers;
        common.log("Total sum of assigned to me, assigned to others, not assigned :: " + sumValue + ".");

        try {
            Assert.assertEquals(allCount, sumValue);
        } catch (AssertionError e) {
            System.out.println("Step :: All counts not matched with completed by me, completed by others.");
            throw e;
        }
        common.log("Step :: All counts matched with completed by me, completed by others.");

    }

    public void verify_DashboardTaskAnalytics_OverdueTotalCountWith_OverduePageAllTaskCounts() {

        common.pause(2);
        common.isElementDisplayed(driver, OverDueMenu);
        common.click(driver , OverDueMenu);
        common.log("Step :: Click on overdue menu.");

        common.isElementDisplayed(driver, DashboardHeaderOverdueActive);
        String overDueTitle = common.getText(driver , DashboardHeaderOverdueActive);
        common.log("Step :: Verify the title :: " + overDueTitle + ".");

        common.pause(3);
        common.isElementDisplayed(driver, DashboardAnalyticsOverdueTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsOverdueTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");


    }

    public void verify_DashboardTaskAnalytics_TodayTotalCountWith_TodayPageAllTaskCounts() {

        common.pause(3);
        common.isElementDisplayed(driver, TodayMenu);
        common.click(driver , TodayMenu);
        common.log("Step :: Click on today menu.");

        common.isElementDisplayed(driver, DashboardHeaderTodayActive);
        String todayTitle = common.getText(driver , DashboardHeaderTodayActive);
        common.log("Step :: Verify the title :: " + todayTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsTodayTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsTodayTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");


    }

    public void verify_DashboardTaskAnalytics_Next6DaysTotalCountWith_Next6DaysPageAllTaskCounts() {

        common.pause(3);
        common.isElementDisplayed(driver, Next6DaysMenu);
        common.click(driver , Next6DaysMenu);
        common.log("Step :: Click on next 6 days menu.");

        common.isElementDisplayed(driver, DashboardHeaderNext6DaysActive);
        String next6DaysTitle = common.getText(driver , DashboardHeaderNext6DaysActive);
        common.log("Step :: Verify the title :: " + next6DaysTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsNext6DaysTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsNext6DaysTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");


    }

    public void verify_DashboardTaskAnalytics_8To3DaysTotalCountWith_8To30DaysPageAllTaskCounts() {

        common.pause(3);
        common.isElementDisplayed(driver, CO8To30DaysMenu);
        common.click(driver , CO8To30DaysMenu);
        common.log("Step :: Click on 8 to 30 days menu.");

        common.isElementDisplayed(driver, DashboardHeader8To30DaysActive);
        String title = common.getText(driver , DashboardHeader8To30DaysActive);
        common.log("Step :: Verify the title :: " + title + ".");

        common.pause(3);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalytics8To30DaysTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalytics8To30DaysTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");
    }

    public void verify_DashboardTaskAnalytics_Beyond30DaysTotalCountWith_Beyond30DaysPageAllTaskCounts() {

        common.pause(3);
        common.isElementDisplayed(driver, Beyond30DaysMenu);
        common.click(driver , Beyond30DaysMenu);
        common.log("Step :: Click on beyond 30 days menu.");

        common.isElementDisplayed(driver, DashboardHeaderBeyond30DaysActive);
        String title = common.getText(driver , DashboardHeaderBeyond30DaysActive);
        common.log("Step :: Verify the title :: " + title + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsBeyond30DayTotalCounts);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsBeyond30DayTotalCounts);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");
    }

    public void verify_DashboardTaskAnalytics_TotalMenuTotalCountWith_TotalPageAllTasksCount() {

        common.pause(3);
        common.isElementDisplayed(driver, TotalMenu);
        common.click(driver , TotalMenu);
        common.log("Step :: Click on total menu.");

        common.isElementDisplayed(driver, DashboardHeaderTotalActive);
        String totalTitle = common.getText(driver , DashboardHeaderTotalActive);
        common.log("Step :: Verify the title :: " + totalTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsTotal_TotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsTotal_TotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");
    }

    public void verify_DashboardTaskAnalytics_ApprovalPendingMenuTotalCountWith_ApprovalPendingAllTasksCount() {

        common.pause(2);
        common.isElementDisplayed(driver, approvalPending);
        common.click(driver , approvalPending);
        common.log("Step :: Click on approval pending menu.");

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String activeTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + activeTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsApprovalPendingTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsApprovalPendingTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        common.isElementDisplayed(driver, requestCount);
        common.click(driver , requestCount);
        common.pause(2);
        String requests1 = common.getText(driver , requestCount);
        int requests = Integer.parseInt(requests1);
        common.log("Step :: Verify the request total count :: " + requests + ".");

        int sumValue = allCount + requests;
        common.log("Step :: Verify sum of all count and request count" + sumValue);

        try {
            Assert.assertEquals(taskTotalCount, sumValue);
        } catch (AssertionError e) {
            common.log("Step :: The sum of all and request counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: The sum of all and request counts matched with dashboard analytics total count.");
    }

    public void verify_DashboardTaskAnalytics_RejectedTasksMenuTotalCountWith_RejectedTasksPageAllTasksCount() {

        common.pause(2);
        common.isElementDisplayed(driver, rejectedTasks);
        common.click(driver , rejectedTasks);
        common.log("Step :: Click on rejected tasks menu.");

        common.pause(2);
        common.isElementDisplayed(driver, titleActive);
        String activeTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + activeTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, DashboardAnalyticsRejectedTasksTotalCount);
        String rejectedTasks1 = common.getText(driver , DashboardAnalyticsRejectedTasksTotalCount);
        int rejectedTasks = Integer.parseInt(rejectedTasks1);
        common.log("Step :: Verify the dashboard analytics total count :: " + rejectedTasks + ".");

        try {
            Assert.assertEquals(rejectedTasks, allCount);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");
    }

    public void verify_DashboardTaskAnalytics_CompletedMenuTotalCountWith_CompletedPageAllTasksCount() {

        common.pause(3);
        common.isElementDisplayed(driver, CO_CompleteMenu);
        common.click(driver , CO_CompleteMenu);
        common.log("Step :: Click on completed menu.");

        common.isElementDisplayed(driver, titleActive);
        String completedTitle = common.getText(driver , titleActive);
        common.log("Step :: Verify the title :: " + completedTitle + ".");

        common.pause(5);
        common.isElementDisplayed(driver, AllCount);
        String allCount1 = common.getText(driver , AllCount);
        int allCount = Integer.parseInt(allCount1);
        common.log("Step :: Verify the all count :: " + allCount + ".");

        common.isElementDisplayed(driver, COCompletedRequestCount);
        String completedRequest1 = common.getText(driver , COCompletedRequestCount);
        int completedRequest = Integer.parseInt(completedRequest1);
        common.log("Step :: Verify the completed request count :: " + completedRequest + ".");

        int sumValue = allCount + completedRequest;

        common.isElementDisplayed(driver, DashboardAnalyticsCompletedTotalCount);
        String taskTotalCount1 = common.getText(driver , DashboardAnalyticsCompletedTotalCount);
        int taskTotalCount = Integer.parseInt(taskTotalCount1);
        common.log("Step :: Verify the dashboard analytics total count :: " + taskTotalCount + ".");

        try {
            Assert.assertEquals(taskTotalCount, sumValue);
        } catch (AssertionError e) {
            common.log("Step :: All counts not matched with dashboard analytics total count.");
            throw e;
        }
        common.log("Step :: All counts matched with dashboard analytics total count.");

    }

    public void verifyTasksUpdates() throws IOException, ParseException {

        common.isElementDisplayed(driver, TotalMenu);
        common.click(driver , TotalMenu);
        common.log("Step :: Click on total menu.");

        common.isElementDisplayed(driver, DashboardHeaderTotalActive);
        String totalTitle = common.getText(driver , DashboardHeaderTotalActive);
        common.log("Step :: Verify the title :: " + totalTitle + ".");

        common.isElementDisplayed(driver, SearchIconInDashboard);
        common.click(driver , SearchIconInDashboard);
        common.log("Step :: Click on search icon on dashboard.");

        common.isElementDisplayed(driver, SearchInputFieldDashboard);
        common.sendKeys(driver , SearchInputFieldDashboard , config.read_Test_Data("TaskName"));
        common.log("Step :: Searched created task.");
        common.pause(2);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        Date date1 = new Date();
        String todayDate = formatter.format(date1);
        common.log("Step :: Today's date: " + todayDate + ".");

        common.isElementDisplayed(driver, Internal_Deadline_Filter_Icon);
        common.click(driver , Internal_Deadline_Filter_Icon);
        common.log("Step :: Click on internal deadline filer.");

        common.isElementDisplayed(driver, Date_Filter_Search_Input_Field);
        common.sendKeys(driver , Date_Filter_Search_Input_Field , todayDate);
        common.log("Step :: Enter today's date.");

        common.pause(3);

        common.isElementDisplayed(driver, Filtered_Date_Checkbox);
        common.click(driver , Filtered_Date_Checkbox);
        common.log("Step :: Click on filtered date checkbox.");

        common.pause(3);

        common.isElementDisplayed(driver, Filter_Ok_Button);
        common.click(driver ,Filter_Ok_Button);
        common.log("Step :: Click on ok button.");

        common.isElementDisplayed(driver, First_Row_Date);
        String actualDate = common.getText(driver , First_Row_Date);
        common.log("Step :: Get filtered date from table row and verify with today's date.");

        if (actualDate.equalsIgnoreCase(todayDate)) {
            softAssert.assertTrue(true);
            common.log("Step :: Verified today's task is created.");
        } else {
            softAssert.fail("Today task not found");
            common.log("Step :: Today's task is not created.");
        }

        common.click(driver ,First_Row_Date);
        common.log("Step :: Click on date.");
        common.pause(3);

        common.isElementDisplayed(driver, CO_Task_AssignTo);
        String assignTo = common.getText(driver , CO_Task_AssignTo);
        softAssert.assertEquals(assignTo, "TMTeam Member", "Assigned to is mismatch.");
        common.log("Step :: Assign To: " + assignTo + ".");

        common.isElementDisplayed(driver, CO_Task_Approvr);
        String approver = common.getText(driver , CO_Task_Approvr);
        softAssert.assertEquals(approver, "RCRahul CO");
        common.log("Step :: Approver: " + approver + ".");

        common.isElementDisplayed(driver, CO_Task_CC);
        String cc = common.getText(driver , CO_Task_CC);
        softAssert.assertEquals(cc, "RTRahul TM two");
        common.log("Step :: CC: " + cc + ".");

        common.isElementDisplayed(driver, CO_Task_Due_Date);
        String dueDate = common.getText(driver , CO_Task_Due_Date);
        softAssert.assertEquals(dueDate, todayDate, "Due date mismatch.");
        common.log("Step :: Due date: " + dueDate + ".");

        common.isElementDisplayed(driver, CO_Task_Frequency);
        String frequency = common.getText(driver , CO_Task_Frequency);
        softAssert.assertEquals(frequency, "Daily", "Frequency in mismatch.");
        common.log("Step :: Frequency: " + frequency + ".");

        common.isElementDisplayed(driver, CO_Task_Creator);
        String creator = common.getText(driver , CO_Task_Creator);
        softAssert.assertEquals(creator, "KTKevin Trivedi", "Creator is mismatch.");
        common.log("Step :: Creator: " + creator + ".");

        common.isElementDisplayed(driver, CO_Task_DeadLine);
        String internalDeadLine = common.getText(driver , CO_Task_DeadLine);
        softAssert.assertEquals(internalDeadLine, todayDate + " 11:59 PM", "Internal deadline is mismatch.");
        common.log("Step :: Internal deadline: " + internalDeadLine + ".");

        common.isElementDisplayed(driver, CO_Task_Tag);
        String tag = common.getText(driver , CO_Task_Tag);
        softAssert.assertEquals(tag, "I-Test", "Tag is mismatch.");
        common.log("Step :: Tag is on left corner: " + tag + ".");

        common.isElementDisplayed(driver, Note_Menu);
        common.click(driver , Note_Menu);
        common.log("Step :: Click on note menu.");

        common.isElementDisplayed(driver, Note_Inside_Note_Menu);
        String note = common.getText(driver , Note_Inside_Note_Menu);
        softAssert.assertEquals(note, "Automation task Automation task Automation task", "Note is mismatch.");
        common.log("Step :: Verify note.");

        common.isElementDisplayed(driver, Close_Icon);
        common.click(driver , Close_Icon);
        common.log("Step :: Click on close icon.");

    }

}