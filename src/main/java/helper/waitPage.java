package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.Browser;

import java.time.Duration;

public class waitPage extends Browser {
    WebDriverWait wait;

    public void WaitForPresenceofElement(int timeout,WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
