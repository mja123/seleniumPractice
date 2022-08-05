package org.mja123.dropdown;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class DropdownTests extends BaseTest {
    private DropdownPage dropdownPage;
    private String option;

    @BeforeClass
    public void setUpClass() throws PageNotFoundException {
        dropdownPage = (DropdownPage) homePage.pageFactory(EPages.DROPDOWN);
    }

    @Test
    public void selectExistedOption() throws OptionNotFoundException {
        option = "1";
        String optionText = dropdownPage.selectedOption(option);

        assertEquals("Selected option text:" + optionText + " is not equals to Option 1",
                "Option 1", optionText);
    }

    @Test(expectedExceptions = OptionNotFoundException.class)
    public void selectNotExistedOption() throws OptionNotFoundException {
        option = "3";
        String optionText = dropdownPage.selectedOption(option);
    }
}
