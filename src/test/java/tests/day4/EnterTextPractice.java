package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputbox = driver.findElement(By.name("email"));
        inputbox.sendKeys("random@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        String expectedurl = "http://practice.cybertekschool.com/email_sent";
        String actualurl = driver.getCurrentUrl();
        if (expectedurl.equals(actualurl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }



        BrowserUtils.wait(2);
        driver.close();
    }
}
