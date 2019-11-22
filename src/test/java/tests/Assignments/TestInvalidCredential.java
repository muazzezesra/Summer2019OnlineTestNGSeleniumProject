package tests.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestInvalidCredential {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");
        WebElement email = driver.findElement(By.id("prependedInput"));
        email.sendKeys("user13");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser12");
        WebElement button = driver.findElement(By.id("_submit"));
        button.click();


    }
}
