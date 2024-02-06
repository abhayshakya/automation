package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class actionClass {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

//        WebElement more = driver.findElement(By.xpath("//span[contains(text(),'+ More')]"));
//        WebElement cruise = driver.findElement(By.xpath("//span[contains(text(),'Cruise')]"));
//        Thread.sleep(2000);
//
//        Actions actions = new Actions(driver);
//        actions.click(more).build().perform();
//        Thread.sleep(2000);
//        cruise.click();

        
    }
}
