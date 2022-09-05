package org.mja123.js;

import org.mja123.BasePage;
import org.mja123.dropdown.DropdownPage;
import org.mja123.dropdown.OptionNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class MultipleDropDownPage extends BasePage {

    public MultipleDropDownPage(WebDriver driver) {
        super(driver);
    }

    public int selectMultipleElements() throws OptionNotFoundException {
        Select select = new Select(changeSelectAttribute());

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .click(selectOption("Option 1"))
                .click(selectOption("Option 2"))
                .perform();

        return select.getAllSelectedOptions().size();
    }

    private WebElement changeSelectAttribute() {
        WebElement select = driver.findElement(By.xpath("//select['dropdown']"));

        String script = "arguments[0].setAttribute('multiple', '')";

        ((JavascriptExecutor)driver).executeScript(script, select);

        return select;
    }
    private WebElement selectOption(String value) throws OptionNotFoundException {
        List<WebElement> options = driver.findElements(By.xpath("//option[not(@disabled='disabled')]"));

        Optional<WebElement> option =  options.stream()
                .filter(o -> o.getText().contains(value))
                .findFirst();
        if (option.isPresent()) {
            return option.get();
        }
        throw new OptionNotFoundException(value + " is not an option.");
    }
}
