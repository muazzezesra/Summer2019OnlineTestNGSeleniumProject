package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    /*
    #BROWSER TYPE
    browser=chrome
    #key=value, it's like a Map in java

    #URL OF OUR WEB APPLICATION
    url=https://qa1.vytrack.com/

    #CREDENTIALS
    user_name=storemanager85
    password=UserUser123
     */


    @Test
    public void test1(){
        String expectedBrowser = "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);

        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }
}
