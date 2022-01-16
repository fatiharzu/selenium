package day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions3  extends TestBase {
    /*
    Create a class: Actions3
Create test method : keysUpDown()
Go to google/amazon
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
     */
    @Test
    public void keysUpDown() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        WebElement searchBox = driver.findElement(By.name("q"));

//        Send iPhone X prices => convert small letter capital vice versa.
//        Highlight the search box by double clicking
//        seachBox.sendKeys(iPhone X prices);

//      1. Create actions object for keybord actions
        Actions actions = new Actions(driver);

//      2. use the proper actions methods
        actions
                .keyDown(searchBox, Keys.SHIFT)//pressing the shift on searchBox
                .sendKeys("iPhone X prices")//typing in the search box
                .keyUp(searchBox,Keys.SHIFT)//un pressing
                .sendKeys(" too expensive OMG!"+Keys.ENTER)//Typing and pressing ENTER
                .perform(); //Execute actions class. Without perform Actions will not work


    }

}
