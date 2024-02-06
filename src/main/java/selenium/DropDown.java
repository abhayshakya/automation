package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {
    public static WebDriver driver;

    public void Handling_Drop_Down(String cause){

        List<WebElement> dropdown_list=driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
        System.out.println("The Options in the Dropdown are: " + dropdown_list.size());
        for (int i=0;i<=dropdown_list.size();i++){
            System.out.println(dropdown_list.get(i).getText());

            if (dropdown_list.get(i).getText().contains(cause)){
                dropdown_list.get(i).click();
                break;
            }
        }

    }
}
