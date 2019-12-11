package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    // if this locator doesn't work use -> [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[logo][file]")
    public WebElement logoElement;

    /*
         This method stands for selecting tags
         Provide tag name to select
         If checkbox already selected, it will not do anything
         tagName represents name of tag that has to be selected, like Junior, Senior or Purchased
         CreateCarPage createCarPage = new CreateCarPage();
         createCarPage.selectTags("Senior"); // Senior tag will be selected
    */
    public WebElement selectTags(String tagName){
        // Locator for checkbox is based on label name
        // label and checkbox are siblings
        String locator = "//label[text()='" + tagName + "']/preceding-sibling::input[@type='checkbox']";        WebElement checkBox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkBox,15);
        BrowserUtils.waitForClickablility(checkBox,15);
        if (!checkBox.isSelected()){
            checkBox.click();
        }
        return checkBox;
    }

    /*
    Select fuel type by visible text
    fuelType - Diesel, Electric, Hybrid
    CreateCarPage createCarPage = new CreateCarPage();
    to select gasoline type
    createCarPage.selectFuelType("Diesel"); if you want to select diesel as a fuel type
     */
    public void selectFuelType(String fuelType){
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();
    }

    /*
      This method will upload a file from your computer
      pathToTheFile that you want to upload
     */
    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement,15);
        locationElement.sendKeys(pathToTheFile);
    }

}
