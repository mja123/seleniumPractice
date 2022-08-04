package org.mja123;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurePage extends BasePage {
    private WebElement alert;

    public SecurePage(WebDriver driver) {
        super(driver);
        alert = driver.findElement(By.id("flash"));
    }

    public boolean checkAlertMessage() {
        LOGGER.info("Checking alert message");
        return alert.getText().contains("You logged into a secure area!");
    }

}
