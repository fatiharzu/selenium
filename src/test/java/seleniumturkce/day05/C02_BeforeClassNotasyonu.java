package seleniumturkce.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeClassNotasyonu {
    //amazon sayfasina gidelim 3 farkli test methodu hazirlayin
    // her methodda farkli aramalar yapin
    static WebDriver driver;
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test1() {
       searchBox.clear();
        searchBox.sendKeys("nutella" + Keys.ENTER);
    }

    @Test
    public void test2() {
        searchBox.clear();
        searchBox.sendKeys("bicycle" + Keys.ENTER);
    }
    @Test
    public void test3() {
        searchBox.clear();
        searchBox.sendKeys("java" + Keys.ENTER);
    }
    @AfterClass
    public static void tearDown (){
        driver.close();
    }
}