package org.mja123.login;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SecurePage extends BasePage {
    private final WebElement alert;

    public SecurePage(RemoteWebDriver driver) {
        super(driver);
        alert = driver.findElement(By.id("flash"));
    }

    public boolean checkAlertMessage() {
        LOGGER.info("Checking alert message");
        return alert.getText().contains("You logged into a secure area!");
    }

}
