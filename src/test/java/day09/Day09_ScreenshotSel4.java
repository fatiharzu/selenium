package day09;

import com.myfirstproject.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day09_ScreenshotSel4 extends TestBase {
    /*
     * In selenium 4, we can take screenshot of specific elements
     *
     */
    @Test
    public void takeScreenShot() throws IOException {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//div[@role='none'])[5]")).click();
//        get the screenshot of ONLY THE GOOGLE LOGO
        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        File googleLogoImage = googleLogo.getScreenshotAs(OutputType.FILE);
        File finalPath = new File("google.png");
        FileUtils.copyFile(googleLogoImage,finalPath);
    }
}
