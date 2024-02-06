package applicationPages;

import basePages.Base_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Holidays extends Base_page {
    public Holidays(WebDriver driver) {
        super(driver);
    }

    public By select_holiday = By.xpath("//a[@title='Holidays']");
    public void gotoHolidays(){
        click(select_holiday);
    }

    public By depart_from = By.xpath("//input[@id='BE_holiday_leaving_city']");
    public void holidays_depart_from(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        click(depart_from);
    }

    public By select_city = By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div/ul/li[1]/div/div/ul/div/div/div/div[5]/li");
    public void origin_city(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        click(select_city);
    }

    public By going_where = By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div/ul/li[3]/div/div/ul/div/div/div/div[4]/li");

    public void going_to(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        click(going_where);
    }

    public By month_dd = By.xpath("//span[@class='sprite pointDwnPax holi_passengerBox']");
    public void travel_month_dd() throws InterruptedException {
        Thread.sleep(3000);
        click(month_dd);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public By select_month = By.xpath("//span[contains(text(),'March 2024')]");
    public void month(){
        click(select_month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public By search_holiday = By.xpath("//input[@id='BE_holiday_search_btn']");
    public void searchHoliday(){
        click(search_holiday);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//a[contains(text(),'12 Packages')]")));
        click(By.xpath("//*[@id=\"srpRoot\"]/div[1]/section[3]/div/div/ul/li[3]"));
    }
}
