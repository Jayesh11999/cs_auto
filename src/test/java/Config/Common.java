package Config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Common extends Configuration {

    public Common(WebDriver driver) {
        this.driver = driver;
    }

    private static final TimeUnit SECONDS = null;
    Date date = new Date();
    protected Wait<WebDriver> wait;

    /**
     * Highlight given element
     *
     * @param element the element to be highlighted
     */
    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
    }

    /**
     * Find the first {@link WebElement} using the given method. This method is
     * affected by the 'implicit wait' times in force at the time of execution. The
     * findElement(..) invocation will return a matching row, or try again
     * repeatedly until the configured timeout is reached.
     *
     * @param locator the locator to be used by locating mechanism to find element
     * @return The first matching element on the current page
     * @throws NoSuchElementException If no matching elements are found
     */
    public WebElement findElement(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return driver.findElement(By.partialLinkText(locator));
            return driver.findElement(By.linkText(locator));
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return driver.findElement(By.id(locator));
        } else if (locator.startsWith("//")) {
            return driver.findElement(By.xpath(locator));
        } else if (locator.startsWith("#")) {
            return driver.findElement(By.cssSelector(locator));
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return driver.findElement(By.name(locator));
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return driver.findElement(By.className(locator));
        } else if (locator.equalsIgnoreCase("body")) {
            return driver.findElement(By.cssSelector(locator));
        } else {
            return driver.findElement(By.id(locator));
        }
    }

    /**
     * Log given message to Reporter output.
     *
     * @param msg Message/Log to be reported.
     */
    public void log(String msg) {
        Reporter.log("<br></br>" + msg);
        System.out.println(msg);
    }

    /**
     * <p>
     * Creates a random character string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of alphabetic characters.
     * </p>
     *
     * @param length the length of random character string to create
     * @return The random character string in lower case
     */
    public static String generateRandomChars(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }


    /**
     * Generate Random Number1
     *
     * @param
     * @return
     */
    /**
     * <p>
     * Creates a random number string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of numeric characters.
     * </p>
     *
     * @param length the length of random number string to create
     * @return The random number string
     */
    /**
     * Click on given element. If this causes a new page to load, you should discard
     * all references to given element and any further operations performed on given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible and it must have a height and width greater then 0.
     *
     * @param locator the locator of element to be clicked.
     */

    /**
     * Click on given element. If this causes a new page to load, you should discard
     * all references to given element and any further operations performed on given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible and it must have a height and width greater then 0.
     *
     * @param element the element to be clicked.
     */

//    public void click(WebElement element) {
//        element.click();
//        pause10Sec();
//    }
    public void click(WebDriver driver, String elementName){
        pause(driver ,elementName);
        driver.findElement(By.xpath(elementName)).click();
    }

    public void pause(WebDriver driver, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
    }
    public void sendKeys(WebDriver driver, String elementName , String data ){
        pause(driver ,elementName);
        driver.findElement(By.xpath(elementName)).sendKeys(data);
    }
    public void clear(WebDriver driver, String elementName){
        pause(driver ,elementName);
        driver.findElement(By.xpath(elementName)).clear();
    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
    public boolean isEnabled(WebDriver driver, String elementName){
        pause(driver ,elementName);
       boolean result = driver.findElement(By.xpath(elementName)).isEnabled();
       return result ;
    }
    public String getText(WebDriver driver, String elementName){
        pause(driver ,elementName);
        String gottenText = driver.findElement(By.xpath(elementName)).getText();
        return gottenText ;
    }
    public String getAttribute(WebDriver driver, String elementName){
        pause(driver ,elementName);
        String gottenText = driver.findElement(By.xpath(elementName)).getAttribute("value");
        return gottenText ;
    }


    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of milliseconds, subject to the precision and
     * accuracy of system timers and schedulers. The thread does not lose ownership
     * of any monitors.
     */
    public void pause10Sec() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {

        }
    }

    public static String generateRandomNumberString(int length) {
        String randNumber = RandomStringUtils.randomNumeric(length);
        for (int i = 0; i < 10; i++) {
            if (randNumber.startsWith("0") || randNumber.startsWith("1") || randNumber.startsWith("2") || randNumber.startsWith("3") || randNumber.startsWith("4") || randNumber.startsWith("5") || randNumber.startsWith("6")) {
                randNumber = RandomStringUtils.randomNumeric(length);
            } else {
                break;
            }
        }
        return randNumber;
    }

    /**
     * Checks if given element is being displayed on page.
     *
     * @param elementName Locator of element.
     * @return true if displayed else false.
     */
    public void isElementDisplayed(WebDriver driver, String elementName) {
        try {
            WebDriverWait w = new WebDriverWait(driver, 30);
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
            WebElement ele = driver.findElement(By.xpath(elementName));
            highLighterMethod(driver, ele);
        } catch (Exception e) {
            this.log(String.valueOf(e));
        }
    }

    public boolean ifElementIsDisplayed(WebDriver driver, String locator) throws InterruptedException {
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath(locator)).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if given element is being displayed on page.
     *
     * @param elementName Locator of element.
     * @return true if displayed else false.
     */
    public void isElementVisible(WebDriver driver, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
        } catch (Exception e) {
            this.log(String.valueOf(e));
        }
    }

    public Boolean isDisplayed(String locator) {
        try {
            driver.findElement(By.xpath(locator)).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Pauses for given seconds.
     *
     * @param secs
     */
    public void pause(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException interruptedException) {

        }
    }


    public String getScreenshotLink(String screenshot_name, String link_text) {
        Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
        return "<a href='../target/surefire-reports" + screenshot_name + "'>" + link_text + "</a>";
    }

    /**
     * Takes screenshot and adds it to TestNG report.
     *
     * @param driver WebDriver instance.
     */
    public void makeScreenshot(WebDriver driver, String screenshotName) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";

        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "surefire-reports" + File.separator;

            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot, new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
        } catch (IOException e) {
            Reporter.log("Failed to capture screenshot: " + e.getMessage());
        }
        Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
    }


    /**
     * Checks if element loaded in browser memory.
     *
     * @param locator Locator of element.
     * @return true if loaded else false.
     */
    public boolean isElementPresent(WebDriver driver, String locator) {

        WebElement webElement = this.findElement(locator);
        if (webElement != null) {
            return true;
        } else {

            return false;
        }
    }

    public String read_json(String Json_Key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/User_Creds.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        JSONObject user = (JSONObject) usersList.get(0);
        String Name = (String) user.get(Json_Key);
        return Name;
    }

    public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red');", element);
        js.executeScript("arguments[0].style.border='4px solid Red'", element);
    }

}