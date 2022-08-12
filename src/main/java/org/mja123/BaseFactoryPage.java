package org.mja123;

import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Optional;

/*ublic abstract class BaseFactoryPage extends BasePage {
    EEnums enums;
    public BaseFactoryPage(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement findLink(EEnums page, String xpath) throws PageNotFoundException {
        List<WebElement> links = driver.findElements(By.xpath(xpath));



        Optional<WebElement> targetPage = links.stream()
                .filter(l -> l.getText().equals(page.))
                .findFirst();

        if (targetPage.isEmpty()) {
            throw new PageNotFoundException(page + " isn't exist.");
        }
        return targetPage.get();
    }
}
*/