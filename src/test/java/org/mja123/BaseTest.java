package org.mja123;

import org.mja123.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected RemoteWebDriver driver;
    //protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        LOGGER.info("Opening remote driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.setFileDetector(new LocalFileDetector());

       /* System.setProperty("webdriver.chrome.driver", "rcs/chromedriver.exe");

        driver = new ChromeDriver(new ChromeOptions());*/
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void clean() {
        driver.quit();
    }
}
