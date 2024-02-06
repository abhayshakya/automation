package applicationPages;

import basePages.Base_page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Villas extends Base_page {
    public By villa_stays = By.xpath("//a[@title='Hotels']");
    public By city = By.xpath("//input[@id='BE_hotel_destination_city']");
    public By name_of_hotel = By.xpath("//*[@id=\"booking_engine_modues\"]/div/div[1]/div[2]/ul/li[1]/div/div/ul/div/div/div/div[3]");
    public By check_in = By.xpath("//input[@id='BE_hotel_checkin_date']");
    public By check_out = By.xpath("//input[@id='BE_hotel_checkout_date']");
    public By checkindate = By.xpath("//td[@id='01/02/2024']");
    public By checkoutdate = By.xpath("//td[@id='03/02/2024']");
    public By traveller = By.xpath("//span[@class='txt-ellipses hotel_passengerBox travellerPaxBox']");
    public By search_hotel= By.xpath("//input[@value='Search Hotels']");
    public By hotel_name =By.xpath("//input[@id='hotelFilterInput']");
    public By hotel_to_stay = By.xpath("//p[contains(text(),'Alchemy Suites')]");
    //private WebDriver driver;

    public Villas(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

//    public By try_other_date = By.xpath("//a[@class='mt5 mb5 new-blue-button ng-scope']");
//
//    public By new_date = By.xpath("//input[@id='checkInDate']");
//
//    public By renewdate = By.xpath("//a[@id='10/01/2024']");
//
//    public By newcheckout = By.xpath("//input[@id='checkOutDate']");
//
//    public By recheckout = By.xpath("//a[@id='12/01/2024']");
//
//    public By search_again = By.xpath("//input[@value='Search Again']");

    public void villastay() throws InterruptedException {
        Thread.sleep(3000);
        click(villa_stays);
    }
    public void select_city() throws InterruptedException {
        Thread.sleep(2000);
        click(city);
    }
    public void choose_city(String vilas) throws InterruptedException {
        Thread.sleep(2000);
        String text = "B";
        String text2 = "Bangalore";
        click(city);
        Thread.sleep(3000);
        send_keys(city, text);
        int nameofhotel = getEl(name_of_hotel).size();
        System.out.println("name of hotel--"+ nameofhotel );

        for (WebElement element: getEl(name_of_hotel)){
            if (element.getText().contains(text2)) {
                element.click();
                break;
            }
        }
    }
    public void enter_checkin() throws InterruptedException {
        Thread.sleep(2000);
        click(check_in);
        Thread.sleep(2000);
        click(checkindate);
    }
    public void enter_checkout() throws InterruptedException {
        Thread.sleep(2000);
        click(check_out);
        Thread.sleep(2000);
        click(checkoutdate);
    }

    public void travellers_rooms() throws InterruptedException {
        Thread.sleep(3000);
            click(traveller);
            driver.findElement(By.xpath("//span[@class='ddSpinnerPlus']")).click(); //add adults
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"BE_Hotel_pax_box\"]/div[1]/div[2]/div[3]/div/div/span[2]")).click();//add children
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='agedropdown']")).click();//child age
            WebElement element = driver.findElement(By.xpath("//select[@class='ageselect']"));
            Select select = new Select(element);
            select.selectByValue("7");
 }

    public void searchvilla() throws InterruptedException {
        Thread.sleep(2000);
        click(search_hotel);
        Thread.sleep(2000);
    }

    public void searchhotel(String hotel) throws InterruptedException {
        Thread.sleep(2000);
        String text3 = "Alchemy";
        //String text4 ="Alchemy";
        click(hotel_name);
        Thread.sleep(2000);

        send_keys(hotel_name,text3);
        Thread.sleep(2000);
        click(hotel_to_stay);

//        int hoteltostay = getEl(hotel_to_stay).size();
//        System.out.println("hotel to stay " + hoteltostay);
//
//        for (WebElement element: getEl(hotel_to_stay)){
//            if (element.getText().contains(text4)) {
//                element.click();
//                break;
//            }
//        }
    }

//    public void newdate() throws InterruptedException { // hotels not found then search again
//        Thread.sleep(3000);
//        click(try_other_date);
//
//        Thread.sleep(2000);
//        click(new_date);
//
//        Thread.sleep(2000);
//        click(renewdate);
//
//        Thread.sleep(2000);
//        click(newcheckout);
//
//        Thread.sleep(2000);
//        click(recheckout);
//
//        Thread.sleep(3000);
//        click(search_again);}

}
