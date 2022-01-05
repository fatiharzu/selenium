package seleniumturkce.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_AmazonArama {
    public static void main(String[] args) {
        //amazon websayfasina gidip java icin arama yapin ve bulunan sonuc sayisini yazdirin

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
//   <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
//   placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("kazim"+ Keys.ENTER);

       WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        System.out.println(sonucYazisi.getText());

        // web elementler obje oldugu icin direk yazdirilamazlar
        // web elementin sahip oldugu yaziyi string olarak yazdirmak icin
      //  getText(); methodu kullanilir
    }
}
