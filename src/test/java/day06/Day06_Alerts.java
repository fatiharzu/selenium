package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.invoke.SwitchPoint;
import java.time.Duration;

public class Day06_Alerts {
    /*
    Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”
     */
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        /*
        acceptAlert() => click on the first alert,
        verify the text “I am a JS Alert” ,
        click OK , and Verify “You successfully clicked an alert”
         */
        // locating the first button
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        WebElement button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //clicking
        button.click();
        //verifying the text "I am a JS Alert" ,
        // We can not inspect alert elements, so we must use sitchTo() function to handle alerts
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Alert",alertText);
        // click ok
        // Again, we cannot inspect OK button on the Alert
        //so we must switch to alert and accept
        driver.switchTo().alert().accept();

//      and verify "You successfully clicked an alert"
        String actualResult = driver.findElement(By.id("result")).getText();

        Assert.assertEquals("You successfully clicked an alert",actualResult);

    }
    @Test
    public void dismissAlert(){
        /*
        dismissAlert()=> click on the second alert,
        verify text "I am a JS Confirm”, click cancel,
        and Verify “You clicked: Cancel”
         */
        WebElement button =driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();
        String dismissAlert = driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Confirm",dismissAlert);
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",actualResult);

        // Expected data comes from the user stories/acceptance criteria
        // Actual comes from the website
    }
    @Test
    public void sendKeysAlert(){
        /*
        sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”,
        type “Hello World”, click OK, and Verify “You entered: Hello Word”
         */
        WebElement button =driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String sendKeysAlert = driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS prompt",sendKeysAlert);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);
    }
}
