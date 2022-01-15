package Homework;

import com.myfirstproject.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IframeTest extends TestBase {

    // ● Create a class: IframeTest
    // ● Method : iframeTest
    @Test
    public void iFrameTest() throws InterruptedException {
//  ● When a user goes to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

//  ● Then click on the first video play to play the video
        WebElement iFrame =driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrame);
        WebElement playButonu =driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playButonu).perform();
//  ● Then wait for a 5 second (hard wait)
        Thread.sleep(6000);


//  ● Then stop the play
        WebElement actionButton = driver.findElement(By.xpath("//video[@tabindex='-1']"));
        actions.moveToElement(actionButton).perform();
        actions.click().perform();

    }
}
