package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedtitle = driver.getTitle();

        // step 1: open inspector in chrome and find locator for the element
        // step 2: create object of element
        // step 3: use WebElement
        WebElement button = driver.findElement(By.id("form_submit"));
        // to click on the element
        button.click();
        String actualtitle = driver.getTitle();
        if(actualtitle.equals(expectedtitle)){
            System.out.println("Test passed");
        } else{
            System.out.println("Test Failed");
            System.out.println("expected title" +expectedtitle);
            System.out.println("actual title"+actualtitle);
        }

        BrowserUtils.wait(2);
        driver.close();


    }

}
