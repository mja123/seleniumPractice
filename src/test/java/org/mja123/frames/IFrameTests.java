package org.mja123.frames;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.HomePage;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

public class IFrameTests extends BaseTest {
    private IFramePage framePage;

    @BeforeClass
    public void openPage() throws PageNotFoundException {
        FramesPageFactory factory = (FramesPageFactory) homePage.pageFactory(EPages.FRAMES);
        framePage = (IFramePage) factory.frameFactory(EFrames.IFRAME);
    }

    @Test
    public void inputMessage() {
        int index = new Random().nextInt(8);
        String message = "Test";

        assertEquals(framePage.writeMessage(message, index), message);
    }
}
