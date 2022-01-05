package seleniumturkce.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework {
    /*
    1. Bir class oluşturun : AmazonSearchTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
            a.google web sayfasına gidin. https://www. amazon.com/
            b. Search(ara) "city bike"
            c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
            d. "Shopping" e tiklayın.
            e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement arama =driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("city bike"+ Keys.ENTER);
        WebElement aramaSonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Arama sonucu city bike sayisi: "+aramaSonucSayisi.getText());
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        driver.findElement(By.id("landingImage")).click();
    }
}
