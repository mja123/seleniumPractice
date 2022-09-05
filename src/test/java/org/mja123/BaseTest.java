package org.mja123;

import com.google.common.io.Files;
import org.mja123.homePage.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected WebDriver driver;
    //protected WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        LOGGER.info("Opening remote driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--disable-dev-shm-usage");
        //chromeOptions.addArguments("--no-sandbox");
        //System.out.println("Name: " + chromeOptions.getBrowserName() + " version: " + chromeOptions.getBrowserVersion());
        //chromeOptions.setCapability("enableVNC", true);
        //chromeOptions.setBrowserVersion("104.0");
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        //((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

        System.setProperty("webdriver.chrome.driver", "rcs/chromedriverLinux105");

        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void clean() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("rcs/screenshots/", result.getName() + ".png"));
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }


}
