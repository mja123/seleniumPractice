package org.mja123.homePage;

import org.mja123.BasePage;
import org.mja123.alerts.AlertsPage;
import org.mja123.dropdown.DropdownPage;
import org.mja123.files.FileDownloadPage;
import org.mja123.files.FileUploadsPage;
import org.mja123.frames.FramesPageFactory;
import org.mja123.hover.HoverPage;
import org.mja123.js.MultipleDropDownPage;
import org.mja123.login.FormLogin;
import org.mja123.waits.WaitPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    private final List<WebElement> links;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        links = driver.findElements(By.xpath("//div[@id='content']//a"));
    }

    public BasePage pageFactory(EPages page) throws PageNotFoundException {
        WebElement targetPage = findLink(page);

        targetPage.click();
        switch (page) {
            case FORM_LOGIN:
                return new FormLogin(driver);
            case DROPDOWN:
                return new DropdownPage(driver);
            case HOVER:
                return new HoverPage(driver);
            case ALERTS:
                return new AlertsPage(driver);
            case FILE_UPLOADS:
                return new FileUploadsPage(driver);
            case FILE_DOWNLOAD:
                return new FileDownloadPage(driver);
            case FRAMES:
                return new FramesPageFactory(driver);
            case WAITS:
                return new WaitPageFactory(driver);
            case MULTIPLE_DROPDOWN:
                return new MultipleDropDownPage(driver);
            default:
                return null;
        }
    }
    private WebElement findLink(EPages page) throws PageNotFoundException {

        Optional<WebElement> targetPage = links.stream()
                        .filter(l -> l.getText().equals(page.getText()))
                        .findFirst();

        if (targetPage.isEmpty()) {
            throw new PageNotFoundException(page + " isn't exist.");
        }
        return targetPage.get();
    }
}
