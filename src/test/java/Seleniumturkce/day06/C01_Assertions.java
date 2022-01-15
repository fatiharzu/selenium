package Seleniumturkce.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) htips://w•w.bestbuy.conı/ Adresine gidin farkli test methodlari olusturarak asagidaki testleri yapin
            Sayfa URL'inin https://www.bestbuy.com esit oldugunu test edin
            titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
            logoTest => BestBuy logosunun görüntülendigini test edin
            FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void urlTest(){
        String expectedURL ="https://www.bestbuy.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulunamadi",expectedURL,actualURL);
    }
    @Test
    public void titleTest(){
        String unExpectedKelime = "Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da vardir",actualTitle.contains(unExpectedKelime));
    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }
    @Test
    public void fransizcaTesti(){
        WebElement fransizcaLinki= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Istenen Fransizca linki bulunamadi",fransizcaLinki.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}