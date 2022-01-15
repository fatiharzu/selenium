package day07;

import com.myfirstproject.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions2 extends TestBase {
    /*
    Create a class: Actions2
    Create test method : hoverOver() and test the following scenario:
    Given user is on the https://www.amazon.com/
    When use click on “Account” link
    Then verify the page title contains “Your Account”
     */

    @Test
    public void contextClickMethod() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
try{
//    IF NO THANKS IS VISIBLE, IT CLICKS
//    OTHERWISE, WE WILL CATCH HTE EXCELTIP IN CATCH BLOCK
//    CODE WILL CONTINUE TO EXECUTE
    driver.findElement(By.xpath("No,thanks")).click();
}catch(Exception e){
    e.getMessage();
}

//      1. Create actions class
        Actions actions = new Actions(driver);
//      2. use proper actions method
//        Move to mause over account list element
        actions.moveToElement(accountList).perform();
        Thread.sleep(2000);

//      clicking on Account option
        driver.findElement(By.linkText("Account")).click();

//   Then verify the page title comtains "Your Account"
        Assert.assertEquals("Your Account",driver.getTitle());
    }

}
