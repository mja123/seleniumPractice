package org.mja123.frames;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Optional;

public class FramesPageFactory extends BasePage {

    public FramesPageFactory(RemoteWebDriver driver) {
        super(driver);
    }

    public FramesPageFactory frameFactory(EFrames frame) {

        selectFrameLink(frame);

        if (frame == EFrames.NESTED) {
            return new NestedFramePage(driver);
        }
        return new IFramePage(driver);
    }

    private void selectFrameLink(EFrames frame) {
        List<WebElement> frames = driver.findElements(By.tagName("li"));

        Optional<WebElement> link = frames.stream()
                .filter(f -> f.getText().contains(frame.getFrame()))
                .findFirst();

        link.ifPresent(WebElement::click);
    }
}
