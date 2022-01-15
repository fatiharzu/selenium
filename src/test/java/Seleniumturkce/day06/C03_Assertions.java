package Seleniumturkce.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Assertions {
    /*
    1. Bir Class olusturalim YanlisErnailTesti
    2. https://www.automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
                    "Invalid email address" uyarisi ciktigini test edelim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.automationpractice.com/index.php");
    }
    @Test
    public void gecersizMailTesti() throws InterruptedException {
    driver.findElement(By.partialLinkText("Sign in")).click();
    WebElement emailGiris=driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[1]"));
    emailGiris.sendKeys("merhaba televole"+ Keys.ENTER);
    Thread.sleep(2000);

    WebElement hataYazisiElementi = driver.findElement(By.id("create_account_error"));
        Assert.assertTrue("Mesaj gorunmedi",hataYazisiElementi.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){

    }
}
