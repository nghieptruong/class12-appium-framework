package base;

import drivers.*;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;
import utils.ConfigManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("Starting beforeSuite");
        // Khoi tao extent report
        ExtentReportManager.initializeExtentReports();
        ConfigManager.loadProperties();
    }

    @BeforeClass
    public void beforeClass() {
        LOG.info("Starting beforeClass");
        String platform = ConfigManager.getProperty("platform");
        DriverManager driverManager = DriverManagerFactory.getDriverManager(platform);

        driverManager.createDriver();
        AppiumDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("Starting beforeMethod: " + method.getName());
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        LOG.info("Starting afterMethod: " + testResult.getMethod().getMethodName());
        if(testResult.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), testResult.getMethod().getMethodName());
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
        LOG.info("Test Method: " + testResult.getMethod().getMethodName() + " - END");
    }

    @AfterClass
    public void afterClass() {
        LOG.info("Starting afterClass");
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null) {
            driver.quit();
        }
        DriverFactory.removeDriverThreadLocal();
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("Starting afterSuite");
        ExtentReportManager.flushReports();
        LOG.info("--------- Suite Ended ---------------");
    }
}
