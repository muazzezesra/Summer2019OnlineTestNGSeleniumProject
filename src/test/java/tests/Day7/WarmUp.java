package tests.Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links
        //every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());
        for (WebElement webelement: links){
            System.out.println(webelement.getText());
        }

        driver.quit();
    }
}
