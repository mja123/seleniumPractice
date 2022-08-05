package org.mja123.dropdown;

import org.mja123.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public String selectedOption(String value) throws OptionNotFoundException {
        Select selectOptions = new Select(driver.findElement(By.tagName("select")));
        List<WebElement> options = selectOptions.getOptions();

        Optional<WebElement> optionSelected = options.stream()
                .filter(o -> o.getAttribute("value").contains(value))
                .findFirst();
        if (optionSelected.isPresent()) {
            return optionSelected.get().getText();
        }
        throw new OptionNotFoundException("The option " + value + " doesn't exist");
    }
}
