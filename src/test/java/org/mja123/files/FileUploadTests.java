package org.mja123.files;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.*;

public class FileUploadTests extends BaseTest {
    private FileUploadsPage uploadsPage;

    @BeforeClass
    public void goToPage() throws PageNotFoundException {
        uploadsPage = (FileUploadsPage) homePage.pageFactory(EPages.FILE_UPLOADS);
    }

    @Test
    public void uploadExistedFileTest() {
        String path = System.getenv("FILE_UPLOAD");

        assertEquals("File Uploaded!", uploadsPage.uploadCorrectFile(path));
    }

    @Test
    public void uploadWithoutFileTest() {
        assertEquals("Internal Server Error", uploadsPage.uploadWithoutFile());
    }

    @Test(expectedExceptions = org.openqa.selenium.InvalidArgumentException.class)
    void uploadNotExistedFileTest() {
        assertTrue(uploadsPage.uploadNotExistedFile("asdf").contains("FIle not found."));
    }
}
