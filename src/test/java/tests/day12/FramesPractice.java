package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = "iFrame example")
    public void test1(){
        driver.findElement(By.linkText("iFrame")).click();

        driver.switchTo().frame("mce_0_ifr");

        WebElement inputArea = driver.findElement(By.id("tinymce"));
        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText, expectedText);

        BrowserUtils.wait(2);

        inputArea.clear();

        BrowserUtils.wait(2);

        inputArea.sendKeys("Java is fun!");

        BrowserUtils.wait(2);

        // exit the frame
        driver.switchTo().defaultContent();
    }

    @Test(description = "Nested Frames example")
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top"); // second floor

        driver.switchTo().frame("frame-left"); // third floor

        System.out.println(driver.findElement(By.tagName("body")).getText()); // print text of body
    }




}
