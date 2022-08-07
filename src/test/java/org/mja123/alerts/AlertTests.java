package org.mja123.alerts;

import org.mja123.BaseTest;
import org.mja123.homePage.EPages;
import org.mja123.homePage.PageNotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class AlertTests extends BaseTest {
    private AlertsPage alertsPage;

    @BeforeClass
    public void openPage() throws PageNotFoundException {
        alertsPage = (AlertsPage) homePage.pageFactory(EPages.ALERTS);
    }

    @Test

    public void clickAlertButton() {
        assertEquals("You successfully clicked an alert", alertsPage.clickAcceptAlert("Alert"));
    }

    @Test
    public void clickConfirmButton() {
        assertEquals("You clicked: Ok", alertsPage.clickAcceptAlert("Confirm"));
        assertEquals("You clicked: Cancel", alertsPage.clickCancelAlert("Confirm"));
    }

    @Test
    public void clickPromptButton() {
        String message = "Testing message";

        assertEquals("You entered: "+ message, alertsPage.clickPromptButton(message));
        assertEquals("You entered: null", alertsPage.clickCancelAlert("Prompt"));
    }
}
