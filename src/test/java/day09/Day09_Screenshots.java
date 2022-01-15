package day09;

import com.myfirstproject.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day09_Screenshots extends TestBase {
    /*
    How to do take screenshot ? How you automated taking screenshot in your current project?
    -There is an interface called TakesScreenshot
    I use getScreenshotAs methods.
    I have a utilities package and reusable class and I have a takeScreenshot method. Iuse taht method.

    When do you take screenshots ?
    If my test scenario fails, To open bug ticket we need some proves.
    If you find the bug with automation then there should be a method to provide a pro

     */

    public void takeScreenShoot() throws IOException {
//  1.  TakesScreenshot is used to take screenshot

        TakesScreenshot ts = (TakesScreenshot) driver;

//     getScreenshotAs method to take a screeshot the type is File
       File image = ts.getScreenshotAs(OutputType.FILE);

       String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

//      Where you store the image
        // test-output/Screenshots.png
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+".png";

       File finalPath = new File(path);
       try{
        FileUtils.copyFile(image,finalPath);
    }catch (IOException e){
           e.printStackTrace();
       }
    }
    @Test
    public void getScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@role='none'])[5]")).click();
        takeScreenShoot();

        driver.findElement(By.name("q")).sendKeys("iphoneX prices"+ Keys.ENTER);
        takeScreenShoot();
    }
}
