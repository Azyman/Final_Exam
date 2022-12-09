package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;

import java.io.*;
import java.util.Base64;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public static WebDriver driver;
    protected LandingPage landingPage;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    Calendar calendar;

    String BASEURL = "https://katalon-demo-cura.herokuapp.com/";

        @BeforeMethod
        public void setup(){
            //Calendar instance to get TimmeInMillis for distinguishing Extent Report names
            calendar = Calendar.getInstance();

            //Initializing Extent Report
            extentSparkReporter = new ExtentSparkReporter(new File("./resources/Reports/" + this.getClass().getSimpleName() + "_" + calendar.getTimeInMillis() + "_" + "TestReport.html"));
            extent = new ExtentReports();
            extent.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setReportName("Automation Final Exam");
            extentSparkReporter.config().setDocumentTitle("Automation Document Title");
            extent.setSystemInfo("Host Name", "CURA Healthcare Service");
            extent.setSystemInfo("Environment", "Exam: Automation Testing");
            extent.setSystemInfo("User Name", "John Doe");
            extentSparkReporter.config().setTimelineEnabled(true);
            extentSparkReporter.config().setTheme(Theme.DARK);
            logger = extent.createTest(this.getClass().getSimpleName()).log(Status.PASS, "This is a logging event for "+this.getClass().getSimpleName()+" method");

            //Setting up the driver
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(BASEURL);
            landingPage = new LandingPage(driver);

    }


    @AfterMethod
    public void captureScreenShots(ITestResult testResult) throws IOException {

        if(ITestResult.FAILURE == testResult.getStatus()){

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/Resources/screenshots/Failed/"+testResult.getName()+"_"+testResult.getStartMillis()+".png");
            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Convert the screenshot to Base64 so that it's available for attachment on the report
            InputStream in = new FileInputStream(source);
            byte[] imageBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);

            logger.log(Status.FAIL,"Attached Screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());

        }
        else if (ITestResult.SUCCESS == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/Resources/screenshots/Passed/"+testResult.getName()+"_"+testResult.getStartMillis()+".png");
            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Convert the screenshot to Base64 so that its available for attachment on the report
            InputStream in = new FileInputStream(source);
            byte[] imageBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);

            logger.log(Status.PASS,"Attached Screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());

        }
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}
