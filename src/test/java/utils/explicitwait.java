package utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class explicitwait {


    public static void explicitlywait(long time, String title) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), time);
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(Driver.get().getTitle(), title);
    }
}
