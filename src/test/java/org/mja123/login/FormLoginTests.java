package org.mja123.login;

import org.mja123.BaseTest;
import org.mja123.EPages;
import org.mja123.PageNotFoundException;
import org.mja123.SecurePage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class FormLoginTests extends BaseTest {

    @Test
    public void successfulLogin() throws PageNotFoundException {
        LOGGER.info("Accessing to the page factory");
        FormLogin loginForm = (FormLogin) homePage.pageFactory(EPages.FORM_LOGIN);

        SecurePage securePage = loginForm.sendCredentials("tomsmith", "SuperSecretPassword!");
        assertTrue(securePage.checkAlertMessage());

    }
}
