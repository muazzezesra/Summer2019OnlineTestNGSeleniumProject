package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

// according to page object model design we have to create corresponded page class for each page of application
//login page = login page class
//every page class will store webelements and methods related to that page
public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput") //this line will initialize webelement
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2") //without findby, webelement will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    public LoginPage(){
        // it's mandatory if you want to use @FindBy annotation
        // this => means LoginPage class
        // Driver.get() returns webdriver object
        PageFactory.initElements(Driver.get(), this);

    }
    //reusable login method
    //just call this method to login provide username and password
    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
    }



}
