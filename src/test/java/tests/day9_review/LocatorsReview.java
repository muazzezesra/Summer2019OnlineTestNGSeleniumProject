package tests.day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Verify checkboxes")
    public void Test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        // [type='checkbox'] since there is 2 elements with same locator
        //and I need only first one, i can use in css, :nth-of-type(index) 7th, 8th etc..
        //it's very useful if you have more than one element under same css selector
        //any tag + attributes :nth-of-type(index)
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 was selected"); // assert that checkbox is not selected
//      // [index] to specify index of the element, if there are multiple elements with this xpath
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 was not selected");
        // css selector preferable, because of speed
    }


}
