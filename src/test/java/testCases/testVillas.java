package testCases;

import applicationPages.Villas;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.Browser;
import utility.ReadJson;

import java.io.File;
import java.io.IOException;


public class testVillas extends Browser {

    String path= System.getProperty("user.dir")+ File.separator + "TestData"+File.separator +"dataSet.json";

    Villas villas;
    @BeforeClass
    public void testSearchVilla() throws IOException, ParseException {
        String browserName = new ReadJson().Read_the_value_from_json(path,"Browser");
        String url = new ReadJson().Read_the_value_from_json(path,"URL");
        String city = new ReadJson().Read_the_value_from_json(path,"vilas");
        openBrowser(browserName,url);

    }

    @Test
    public void test2() throws IOException, ParseException, InterruptedException {
      String villa = new ReadJson().Read_the_value_from_json(path,"vilas");
      System.out.println(villa);
      villas = new Villas(driver);

      villas.villastay();
      villas.select_city();
      villas.choose_city(new ReadJson().Read_the_value_from_json(path,"vilas"));
      villas.enter_checkin();
      villas.enter_checkout();
      villas.travellers_rooms();
      villas.searchvilla();
      villas.searchhotel(new ReadJson().Read_the_value_from_json(path,"hotel"));
//      villas.newdate(); // only runs when there are no hotels
    }
}
