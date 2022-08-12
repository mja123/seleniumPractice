package org.mja123.frames;

import org.mja123.BasePage;
import org.mja123.homePage.PageNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Optional;

public class FramesPageFactory extends BasePage {

    public FramesPageFactory(RemoteWebDriver driver) {
        super(driver);
    }

    public FramesPageFactory frameFactory(EFrames frame) throws PageNotFoundException {

        WebElement page = selectFrameLink(frame);
        page.click();

        if (frame == EFrames.NESTED) {
            return new NestedFramePage(driver);
        }
        return new FramePage(driver);
    }

    private WebElement selectFrameLink(EFrames frame) throws PageNotFoundException {
        List<WebElement> frames = driver.findElements(By.xpath("//li/a"));

        Optional<WebElement> link = frames.stream()
                .filter(f -> f.getText().contains(frame.getFrame()))
                .findFirst();

        if (link.isPresent()) {
            return link.get();
        }
        throw new PageNotFoundException("Frame not found.");
    }
}
