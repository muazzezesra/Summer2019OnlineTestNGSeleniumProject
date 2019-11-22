package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = "verify that title is still Practice")
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
    }

    @Test(description = "verify that user is able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        // record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        BrowserUtils.wait(3);
        //in the selenium every window has an id. that id calls window handle
        //to read window handle we use a method .getWindowHandle()
        //after new window was opened, we can get list of all window id's
        //list - it's a data structure
        // set it's also a data structure, like list. but it doesn't allow duplicates
        //there is no .get() method
        //that's why we need to loop through the set, to read a data from there
        //set can store only unique values
        Set<String> windowHandles = driver.getWindowHandles();
        //loop through the collection of window handles
        for (String windowHandle : windowHandles){
            //if it's not an old window
            if (!windowHandle.equals(oldWindow)){
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        //let's verify that title of new window is a fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong");
        //comeback to original page
        //we can build a function, that will jump in between windows based on the page title
        //based on page title we can determine where to stop
        String pageTitle = "Practice";
        for (String windowHandle : windowHandles){
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            // once we found the correct page title
            if (driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

}
