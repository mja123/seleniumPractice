package org.mja123.alerts;

import org.mja123.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage {
    private Alert alert;
    private final WebElement RESULT;

    public AlertsPage(WebDriver driver) {
        super(driver);
        this.RESULT = driver.findElement(By.id("result"));
    }

    public String clickAcceptAlert(String alertType) {
        setAlert(alertType);
        alert.accept();
        return RESULT.getText();
    }

    public String clickCancelAlert(String alertType) {
        setAlert(alertType);
        alert.dismiss();
        return RESULT.getText();
    }
    public String clickPromptButton(String message) {
        setAlert("Prompt");
        alert.sendKeys(message);
        alert.accept();
        return RESULT.getText();
    }

    private void setAlert(String alertType) {
        driver.findElement(By.xpath("//button[contains(text(),'"+ alertType +"')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }
}
