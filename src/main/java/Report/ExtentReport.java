package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport {
    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        //ExtentSparkReporter sparkReporter = new ExtentSparkReporter("")
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        extentReports.createTest("<i>Test 1</i>")
                .log(Status.FAIL, "<b>TestFail</b>")
                .log(Status.SKIP, "<b>TestSkip</b>")
                .log(Status.WARNING, "<b>TestWarning</b>")
                .log(Status.PASS, "<b>TestPass</b>")
                .log(Status.INFO, "<b>TestInformation</b>");

        extentReports.flush();
    }
}
