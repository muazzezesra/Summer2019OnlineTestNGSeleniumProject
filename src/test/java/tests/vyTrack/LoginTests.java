package tests.vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;
import utils.explicitwait;

public class LoginTests extends TestBase {

    @Test(description = "verify that page title is a 'Dashboard'")
    public void test1(){
        //create page object
        LoginPage loginpage = new LoginPage();
        //call login method
        //provide username and password
        loginpage.login("storemanager85","UserUser123");
        // verification stage
        // Driver.get() = driver   same thing
        // Driver.get() returns webdriver object

        explicitwait.explicitlywait(10,"Dashboard"); // bunu ben olusturdum, utils classda. explicit wait methodu


        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
    }


}
