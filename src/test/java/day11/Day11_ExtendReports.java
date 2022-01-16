package day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day11_ExtendReports extends TestBase {
//               3 libraries to remember?????
//    Extent reports are used for customized html reports
//    it is used to add steps on teh test cased when needed.
//    we have the extent reports set ups in test base

//    ExtentHtmlReporter extentHtmlReporter;
//    ExtentReports extentReports;
//    ExtentTest extentTest;
    @Test
    public void extentReportsTest() throws InterruptedException {
//        Path of the html report
//        String reportPath =  System.getProperty("user.dir")+ "/test-output/my_project_report.html";
//        Creating html report in the file path
//        extentHtmlReporter= new ExtentHtmlReporter(reportPath);
//        Creating extent report
//        extentReports=new ExtentReports();
//        Attaching html report the Extent report
//        extentReports.attachReporter(extentHtmlReporter);
//        So far the report creating is DONE.
//        extentTest =extentReports.createTest("Caretta Extent Reports","Automation Login Scenarios");
        extentTest.pass("Going to the google home page");
        driver.get("https://www.google.com");
//  --------------------------------------------------------------------------------------------------------------------
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@role='none'])[5]")).click();
//  --------------------------------------------------------------------------------------------------------------------
        extentTest.pass("Searching for iphone");
        driver.findElement(By.name("q")).sendKeys("iphene x"+ Keys.ENTER);
        extentTest.pass("Printing the result");
//        Logging as failed
        extentTest.fail("This will FAIL");
//        logging as skipped
        extentTest.skip("This is Skipped");

    }
}