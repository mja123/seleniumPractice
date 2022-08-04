package org.mja123;

import org.mja123.login.FormLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    private List<WebElement> links;
    private HashMap<EPages, WebElement> pages;

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
            default:
                return new FramesPage(driver);
        }
    }
    private WebElement findLink(EPages page) throws PageNotFoundException {

        Optional<WebElement> targetPage = links.stream().filter(l -> l.getText().equals(page.getText())).findFirst();

        if (targetPage.isEmpty()) {
            throw new PageNotFoundException(page + " isn't exist.");
        }
        return targetPage.get();
    }
}
