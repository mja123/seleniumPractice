package org.mja123.login;


import org.mja123.BasePage;
import org.mja123.SecurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormLogin extends BasePage {
    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public FormLogin(WebDriver driver) {
        super(driver);
        this.usernameInput = driver.findElement(By.id("username"));
        this.passwordInput = driver.findElement(By.id("password"));
        this.loginButton = driver.findElement(By.tagName("button"));
    }

    public SecurePage sendCredentials(String username, String password) {
        LOGGER.info("Sending credentials");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new SecurePage(driver);
    }
}
