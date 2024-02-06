package testCases;

import applicationPages.Holidays;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.Browser;
import utility.ReadJson;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class testHolidays extends Browser {

    String path= System.getProperty("user.dir")+ File.separator + "TestData"+File.separator +"dataSet.json";

    Holidays holidays;
    @BeforeClass
    public void testSearchHolidays() throws IOException, ParseException {
        String browserName = new ReadJson().Read_the_value_from_json(path,"Browser");
        String url = new ReadJson().Read_the_value_from_json(path,"URL");
        //String city = new ReadJson().Read_the_value_from_json(path,"vilas");
        openBrowser(browserName,url);

    }

    @Test
    public void test() throws IOException, ParseException, InterruptedException {
        String OriginCity = new ReadJson().Read_the_value_from_json(path,"origincity");
        System.out.println(OriginCity);

        String GoingTo = new ReadJson().Read_the_value_from_json(path,"goingto");
        System.out.println(GoingTo);

        holidays = new Holidays(driver);

        holidays.gotoHolidays();
        holidays.holidays_depart_from();
        holidays.origin_city();
        holidays.going_to();
        holidays.travel_month_dd();
        holidays.month();
        holidays.searchHoliday();

    }

}
