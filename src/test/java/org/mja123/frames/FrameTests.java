package org.mja123.frames;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.mja123.waits.EWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.AssertJUnit.*;

public class FrameTests extends BaseTest {
    private FramePage framePage;

    @BeforeClass
    public void openPage() throws PageNotFoundException {
        FramesPageFactory factory = (FramesPageFactory) homePage.pageFactory(EPages.FRAMES);
        framePage = (FramePage) factory.frameFactory(EFrames.IFRAME);
    }

    @Test
    public void inputMessage() {
        int index = new Random().nextInt(8);
        String message = "Test";

        framePage.changeFormat(index);
        assertEquals(framePage.writeMessage(message), message);
    }
}
