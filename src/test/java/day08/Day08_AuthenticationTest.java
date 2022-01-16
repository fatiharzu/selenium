package day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_AuthenticationTest extends TestBase {
    @Test
    public void authenticationTest(){
        //For verification
        // https://username:password
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        // username : admin
        // password : admin
        WebElement message = driver.findElement(By.xpath("//h3"));
        String succesMessage = message.getText();

        Assert.assertTrue(message.isDisplayed());

        String expectedText = "Congratulations!";
        WebElement actualCongrat = driver.findElement(By.xpath("//p"));
        String actualCongratText = actualCongrat.getText();
        Assert.assertTrue(actualCongratText.contains(expectedText));
    }
}
