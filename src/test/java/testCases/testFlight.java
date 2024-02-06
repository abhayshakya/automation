package testCases;

import applicationPages.Flights;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.Browser;
import utility.ReadJson;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class testFlight extends Browser {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"dataSet.json";
    Flights flights;

    @BeforeClass
    public void testSearchFlight() throws IOException, ParseException {
        String browserName = new ReadJson().Read_the_value_from_json(path,"Browser");
        String url = new ReadJson().Read_the_value_from_json(path,"URL");
        String airpot = new ReadJson().Read_the_value_from_json(path,"airpott");
        openBrowser(browserName, url);

    }

    @Test
    public void searchAgain(){
        flights.SearchFlight();
    }

    @Test
    public void test() throws IOException, ParseException, InterruptedException {
        String tt = new ReadJson().Read_the_value_from_json(path,"airpott");
        System.out.println(tt);
        flights = new Flights(driver);

        flights.Book_one_way_ticket();
        flights.book_a_ticket(new ReadJson().Read_the_value_from_json(path,"text"));
        flights.Eneter_Departure_date();
        flights.return_date();

        flights.SearchFlight();
        //flights.page_1();

    }
}
