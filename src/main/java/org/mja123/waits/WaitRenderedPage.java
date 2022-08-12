package org.mja123.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitRenderedPage extends WaitPageFactory {
    public WaitRenderedPage(RemoteWebDriver driver) {
        super(driver);
    }

    public String waitElement() {
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishedLoading = driver.findElement(By.xpath("//div[@id='finish']/h4"));

        driver.findElement(By.tagName("button")).click();

        waitElement.until(ExpectedConditions.visibilityOf(finishedLoading));

        return finishedLoading.getText();
    }
}

