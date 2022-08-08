package org.mja123.hover;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class HoverPage extends BasePage {
    private final List<WebElement> IMAGES;

    public HoverPage(RemoteWebDriver driver) {
        super(driver);
        this.IMAGES = driver.findElements(By.xpath("//div[@class='figure']"));
    }


    public FigureCaption hoverImage(int index) throws ProfileNotFoundException {

        if (index > IMAGES.size()) {
            throw new ProfileNotFoundException("The mouse isn't hovering the image.");
        }
        //We need to decrease it because in the page the index start in 1 not in 0
        WebElement profile = IMAGES.get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(profile)
                .perform();

        return new FigureCaption(profile);
    }

    public static class FigureCaption {
        private final WebElement PROFILE;

        public FigureCaption(WebElement profile) {
            this.PROFILE = profile;
        }

        public String getLink() throws ProfileNotFoundException {
            if (availableProfile()) {
                return PROFILE.findElement(By.tagName("a"))
                        .getAttribute("href");
            }
            throw new ProfileNotFoundException("The mouse isn't hovering the image.");
        }

        public String getName() throws ProfileNotFoundException {
            if (availableProfile()) {
                return PROFILE.findElement(By.tagName("h5"))
                        .getText();
            }
            throw new ProfileNotFoundException("The mouse isn't hovering the image.");
        }

        private Boolean availableProfile() {
            return PROFILE.isDisplayed();
        }
    }
}
