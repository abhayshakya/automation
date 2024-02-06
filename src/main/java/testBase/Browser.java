package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class Browser {
    public static WebDriver driver;

    public Browser(){

    }

    public void openBrowser(String browser, String url){
        String environment = System.getProperty("os.name");
        System.out.println("Automation Script runs on ==="+environment);

        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

    }
}
