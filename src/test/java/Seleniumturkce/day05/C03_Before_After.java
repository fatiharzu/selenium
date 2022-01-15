package Seleniumturkce.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {
    //uc test methodu yapin
    //1. method amazzon.com
    //2. method techproeducation.com
    //3. method facebook.com a gitsin

    //eger her test method u icin yeni bir sayfa  acilsin ve test methodu sonunda kapansin istiyorsak
    //@Before @After notasyonu kullanilmali
    WebDriver driver;
    @Before
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void techproedTesti(){
        driver.get("https://www.techproeducation.com/");
    }
    @Test
    public void facebookTesti(){
        driver.get("https://www.facebook.com/");
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
