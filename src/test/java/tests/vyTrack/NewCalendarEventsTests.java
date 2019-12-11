package tests.vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class NewCalendarEventsTests extends TestBase {

    @Test(description = "verify that page subtitle is equals to 'All Calendar Events'")
    public void test1(){
        extentTest = extentReports.createTest("verify that page subtitle is equals to 'All Calendar Events'");
        LoginPage loginPage = new LoginPage();

        loginPage.login("storemanager85","UserUser123");
        loginPage.navigateTo("Activities", "Calendar Events");

        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verified that page subtitle 'All Calendar Events' is displayed");

    }
}
