package common;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected WebDriver driver;
    protected static final String DOWNLOAD_PATH = "C:\\Downloads";

    @BeforeSuite
    public void beforeSuiteImplementation() {

        Map<String, Object> prefsMap = new HashMap<>();
        prefsMap.put("download.default_directory", DOWNLOAD_PATH);
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefsMap);
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver(option);
        maximizeBrowserWindow();
    }

    @BeforeMethod
    public void beforeMethodImplementation() {

    }

    @AfterMethod
    public void MethodTearDown() {

    }

    @AfterSuite()
    public void SuiteTearDown() {
        closeBrowser();
        quitDriver();
    }

    protected void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    protected void closeBrowser() {
        try {
            driver.close();
        } catch (UnreachableBrowserException | NoSuchWindowException e) {
            System.out.println("Cannot close driver. Browser is unreachable");
        }
    }

    protected void quitDriver() {
        try {
            driver.quit();
        } catch (UnreachableBrowserException | NoSuchWindowException e) {
            System.out.println("Cannot quit driver. Browser is unreachable");
        }
    }
}
