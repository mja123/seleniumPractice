package org.mja123.homePage;

import org.mja123.BasePage;
import org.mja123.dropdown.DropdownPage;
import org.mja123.frames.FramesPage;
import org.mja123.hover.HoverPage;
import org.mja123.login.FormLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    private final List<WebElement> links;

    public HomePage(WebDriver driver) {
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
            default:
                return new FramesPage(driver);
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
