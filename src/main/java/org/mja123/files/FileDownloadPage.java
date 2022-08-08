package org.mja123.files;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class FileDownloadPage extends BasePage {
    private final List<WebElement> LINKS;

    public FileDownloadPage(RemoteWebDriver driver)
    {
        super(driver);
        this.LINKS = driver.findElements(By.xpath("//div[@id='content']//a"));
    }

    public void downloadDocument(String link) throws DocumentNotFoundException {
        selectLink(link).click();
        
    }
    private WebElement selectLink(String link) throws DocumentNotFoundException {
        Optional<WebElement> targetElement = LINKS.stream()
                .filter(l -> l.getText().equals(link))
                .findFirst();
        if (targetElement.isPresent()) {
            return targetElement.get();
        }
        throw new DocumentNotFoundException(link + " doesn't exist.");
    }

}
