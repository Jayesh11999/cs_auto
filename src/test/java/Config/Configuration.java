package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static java.lang.System.setProperty;

public class Configuration {

    public WebDriver driver;
    public Common common;
    @BeforeMethod
    public void init() throws Exception {
        String targetBrowser = read_json("Browser");

        if (targetBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions Coptions = new ChromeOptions();
            Coptions.addArguments("--remote-allow-origins=*");
            Coptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(Coptions);
        }else if (targetBrowser.equalsIgnoreCase("chromeHeadless")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (targetBrowser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/Driver/geckodriver.exe");
            ChromeOptions Foptions = new ChromeOptions();
            Foptions.addArguments("--remote-allow-origins=*");
            Foptions.addArguments("--disable-notifications");
            driver = new FirefoxDriver(Foptions);
        } else if (targetBrowser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/Driver/msedgedriver.exe");
            EdgeOptions Eoptions = new EdgeOptions();
            Eoptions.addArguments("--remote-allow-origins=*");
            Eoptions.addArguments("--disable-notifications");
            Eoptions.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(Eoptions);
        } else if (targetBrowser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        common = new Common(driver);
        URL url = new URL("https://secmark-np.azurewebsites.net/");
        driver.get(String.valueOf(url));
        common.log("Url Launched.");
        common.isElementDisplayed(driver, "//a[normalize-space()='Login']");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws IOException {
        String testName = testResult.getName();
        Reporter.setCurrentTestResult(testResult);
        File img = new File("target" + File.separator + "surefire-reports" + File.separator + testName + ".png");
        if (testResult.getStatus() == 1) {
            common.log("PASS : " + testResult.getName() + "\n");
            testResult.getThrowable();
        }
        if (testResult.getStatus() == 2) {
            common.makeScreenshot(driver, testName);
            Reporter.log("Failed : This is failed log from reporter.log" + "<br>", true);
            FileOutputStream screenshotStream = new FileOutputStream(img);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            Reporter.log("<a target='blank' href='" + testName + ".png'> <img  src='" + testName + ".png' height='250' width='500'></img> </a>" + "<br>");
        }
        driver.quit();
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

    public String read_Test_Data(String Json_Key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/Test_Data.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        JSONObject user = (JSONObject) usersList.get(0);
        String Name = (String) user.get(Json_Key);
        return Name;
    }




}