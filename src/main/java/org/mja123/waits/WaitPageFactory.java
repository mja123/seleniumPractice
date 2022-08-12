package org.mja123.waits;

import org.mja123.BasePage;
import org.mja123.homePage.PageNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class WaitPageFactory extends BasePage {
    public WaitPageFactory(RemoteWebDriver driver) {
        super(driver);
    }

    public WaitPageFactory selectWait(EWait wait) throws PageNotFoundException {
        WebElement targetPage = getWaitPageLink(wait);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(targetPage));
        targetPage.click();

        if (wait == EWait.HIDDEN) {
            return new WaitHiddenPage(driver);
        }
        return new WaitRenderedPage(driver);
    }

    private WebElement getWaitPageLink(EWait wait) throws PageNotFoundException {
        List<WebElement> links = driver.findElements(By.xpath("//div[@id = 'content']//a"));


        Optional<WebElement> link = links.stream()
                .filter(l -> l.getText().contains(wait.getText()))
                .findFirst();
        if (link.isPresent()) {
            return link.get();
        }
        throw new PageNotFoundException("Wait link not found.");
    }

}
