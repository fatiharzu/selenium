package Seleniumturkce.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_AssertionsYoutube {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https:JJwww.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        o titleTest => Sayfa başlığının "YouTube" oldugunu test edin
        o imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        o Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        o wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
     */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//*[text()='I Agree']")).click();
    }
    @Test
    public void titleTesti() throws InterruptedException {

    String expectedTitle ="YouTube";
    String actualTitle= driver.getTitle();
        Assert.assertEquals("Sayfa title beklenenden farkli",expectedTitle,actualTitle);
    }
    @Test
    public void logoTesti(){
        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }
    @Test
    public void serchBoxTesti(){
        WebElement serachBox = driver.findElement(By.id("search-container"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor",serachBox.isEnabled());
    }
    @Test
    public void yanlisTitleTesti() {
        String istenmeyenBaslik = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals("Sayfa title istenmeyen kelimeye esit ", istenmeyenBaslik, actualTitle);
        Assert.assertFalse("False Mesaji",istenmeyenBaslik.equals(actualTitle));
        Assert.assertTrue("True mesaji",!istenmeyenBaslik.equals(actualTitle));

    }
    @AfterClass
    public static void tearDown(){

    }
}
