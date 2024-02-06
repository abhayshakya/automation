package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshot {
    static WebDriver driver;

    public static String captureScreenShot1(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String  base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot was saved successfully");
        return base64Code;
    }

    public static String captureScreenShot(String filename){
        TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+filename+" "+timestamp()+".jpeg");
        try {
            FileUtils.copyFile((sourceFile),destFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot was taken successfully");
        return destFile.getAbsolutePath();
    }
    public static String timestamp(){
        return new SimpleDateFormat("dd-MM-yyy HH-mm-ss").format(new Date());
    }


    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yatra.com/");

        String base64code = captureScreenShot1();
        String path= captureScreenShot("Yatra");


        extentReports
                .createTest("author report test")
                        .assignAuthor("John")
                                .assignDevice("Chrome 102")
                                        .assignCategory("smoke testing");

        extentReports
                .createTest("author report test 2")
                        .assignAuthor("Cena")
                                .assignDevice("Chrome 102")
                                        .assignCategory("Regression test");

        extentReports
                .createTest("Screenshot Test 1", "This screenshot attacheed in a test level")
                    .info("This is an info message")
                        .addScreenCaptureFromBase64String(base64code);

        extentReports
                .createTest("Screenshot Test 2", "This screenshot attacheed in a test level")
                    .info("This is an info message")
                        .addScreenCaptureFromBase64String(base64code, "Yatra Home Page");

        extentReports
                .createTest("Screenshot Test 3", "This screenshot attacheed in a test level")
                    .info("This is an info message")
                        .addScreenCaptureFromPath(path);
        extentReports
                .createTest("Screenshot Test 4", "This screenshot attacheed in a test level")
                    .info("This is an info message")
                        .addScreenCaptureFromPath(path, "Yatra1 Tilte");

        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
        driver.quit();
    }
}