package tests.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        // go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        // enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk37@cybertekschool.com");
        //enter password
        // * matches any element
        //it's better to spesify tag name, to avoid issues with finding element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");

        driver.quit();
    }
}
