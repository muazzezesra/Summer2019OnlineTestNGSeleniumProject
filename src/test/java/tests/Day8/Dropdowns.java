package tests.Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Dropdowns {

    private WebDriver driver;
  /*
    <select id="dropdown">
    <option value="" disabled="disabled" selected="selected">Please select an option</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    </select>

    */

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        // to select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        // how to verify that option 2 is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
