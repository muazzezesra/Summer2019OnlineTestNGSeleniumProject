package tests.Day7;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test(){
        Assert.assertEquals("apple","apple");
    }

    @Test
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
        driver.quit();
    }

    @Test
    public void verifyHeadingIsDisplayed(){

    }

}
