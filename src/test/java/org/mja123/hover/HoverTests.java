package org.mja123.hover;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HoverTests extends BaseTest {
    private HoverPage hoverPage;

    @BeforeClass
    public void setUpPage() throws PageNotFoundException {
        hoverPage = (HoverPage) homePage.pageFactory(EPages.HOVER);
    }

    @Test
    public void getImageData() throws ProfileNotFoundException {
        int index = 1;
        HoverPage.FigureCaption figureCaption =  hoverPage.hoverImage(index);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(figureCaption.getName(), "name: user" + index);
        softAssert.assertTrue(figureCaption.getLink().endsWith("/users/" + index));
        softAssert.assertAll();
    }

    @Test(expectedExceptions = ProfileNotFoundException.class)
    public void checkException() throws ProfileNotFoundException {
        hoverPage.hoverImage(4);
    }
}
