package org.mja123.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class FramePage extends FramesPageFactory {

    public FramePage(RemoteWebDriver driver) {
        super(driver);
        System.out.println(driver.getCurrentUrl());
    }

    public String writeMessage(String message) {

        switchToChildFrame();

        WebElement input = driver.findElement(By.id("tinymce"));
        input.clear();
        input.sendKeys(message);
        String result = input.findElement(By.tagName("p")).getText();

        switchToParentFrame();

        return result;
    }

    public void changeFormat(int index) {


        WebElement format = driver.findElement(By.xpath("//button[child::span[text()='Format']]"));

        format.click();
        //All the divs without descendants
        List<WebElement> letterFormats = format
            .findElements(By
                .xpath("//div[@class='tox-collection__group'][1]/div | //div[@class='tox-collection__group'][4]/div"));

        //apply a format
        letterFormats.get(index).click();
    }

    private void switchToChildFrame() {
        //frames'id
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
    }

    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
}
