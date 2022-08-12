package org.mja123.waits;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalTime;

import static org.testng.AssertJUnit.assertEquals;

public class WaitRenderedTests extends BaseTest {
    private WaitRenderedPage waitPage;

    @BeforeClass
    public void goPage() throws PageNotFoundException {
        WaitPageFactory factory = (WaitPageFactory) homePage.pageFactory(EPages.WAITS);
        System.out.println(LocalTime.now());
        waitPage = (WaitRenderedPage) factory.selectWait(EWait.RENDERED);
        System.out.println(LocalTime.now());
    }

    @Test
    public void checkFinishedLoadingMessage() {
        assertEquals("Hello World!", waitPage.waitElement());
    }
}
