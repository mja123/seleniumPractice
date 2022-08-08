package org.mja123.files;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class FileUploadsPage extends BasePage {
    private final WebElement FILE_UPLOAD;
    private final WebElement FILE_SUBMIT;

    public FileUploadsPage(RemoteWebDriver driver) {
        super(driver);
        this.FILE_UPLOAD = driver.findElement(By.id("file-upload"));
        this.FILE_SUBMIT = driver.findElement(By.id("file-submit"));
    }

    public String uploadCorrectFile(String path) {
        FILE_UPLOAD.sendKeys(path);
        FILE_SUBMIT.click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions
                        .refreshed(ExpectedConditions
                                .presenceOfElementLocated(By.tagName("h3"))));

        return driver.findElement(By.tagName("h3")).getText();
    }


    public String uploadNotExistedFile(String path) {

        FILE_UPLOAD.sendKeys(path);
        return driver.switchTo().activeElement().getText();
    }

    public String uploadWithoutFile() {
        FILE_SUBMIT.click();
        WebElement uploadError = driver.findElement(By.tagName("h1"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions
            .refreshed(ExpectedConditions
            .visibilityOf(uploadError)));

        return uploadError.getText();
    }
}
