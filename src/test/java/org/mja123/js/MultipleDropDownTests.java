package org.mja123.js;

import org.mja123.BaseTest;
import org.mja123.dropdown.OptionNotFoundException;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class MultipleDropDownTests extends BaseTest {
    private MultipleDropDownPage multiplePage;

    @BeforeClass
    public void openPage() throws PageNotFoundException {
        multiplePage = (MultipleDropDownPage) homePage.pageFactory(EPages.MULTIPLE_DROPDOWN);
        assertEquals("https://the-internet.herokuapp.com/dropdown", driver.getCurrentUrl());
    }

    @Test
    public void selectMultipleOptions() throws OptionNotFoundException {
        assertEquals(2 ,multiplePage.selectMultipleElements());
    }
}
