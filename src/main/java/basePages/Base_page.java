package basePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Base_page {
    public WebDriver driver;
    WebDriverWait wait;

    public Base_page(WebDriver driver){
        this.driver = driver;
    }

    public void send_keys(By by_locator, String text){
        driver.findElement(by_locator).sendKeys(text);
    }

    public void click(By by_locator){
        driver.findElement(by_locator).click();
    }

    public List<WebElement> getEl(By by_locator){
        return driver.findElements(by_locator);
    }

    public boolean isDisplayed(By by_locator){
        driver.findElement(by_locator).isDisplayed();
        return true;
    }

    public String GetText(By by_locator){
        return driver.findElement(by_locator).getText();
    }

    public void WaitForPresenceOfElement(By by_locator,int timeout){
        wait = new WebDriverWait(driver, Duration.ofMinutes(timeout));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by_locator));
    }
    public void WaitForVisibilityOfElement(By by_locators,int timeout){
        wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf((WebElement) by_locators));
    }
}
