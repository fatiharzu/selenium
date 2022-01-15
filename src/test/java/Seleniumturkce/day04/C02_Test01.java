package Seleniumturkce.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {

// 1- Test01 isimli bir closs olusturun


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// 2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
// 3- Browseri tam sayfa yapin '
        driver.manage().window().maximize();
// 4- Sayfayi "refresh" yapin
        driver.navigate().refresh();
// 5- Sayfa bosliginin "Save" ifadesi icerdigini control edin '
        String actuelTitle = driver.getTitle();
        String arananKelime = "Save";

        if (actuelTitle.contains(arananKelime)){
            System.out.println("title "+ arananKelime+" kelimesini iceriyor, TEST PASS");
        }else{
            System.out.println("title "+arananKelime+" kelimesini icermiyor, TEST FAILED");
        }

// 6- Sayfa basliginin "Walmort.com | Save Honey.Live Better" a esit oldugunu control ediniz
        String expectedTitle="Wallmart.com | Save Money.Live Better";

        if(expectedTitle.equals(actuelTitle)){
            System.out.println("Sayfa title i beklenen ile ayni, TEST PASS");
        }else{
            System.out.println("Title beklenen ile ayni degil Test FAILED"+ actuelTitle);
        }

// 7- URL in walmart.com icerdigini control edin
        String actuelURL = driver.getCurrentUrl();
        String urlArananKelime ="walmart.com";

        if (actuelURL.contains(urlArananKelime)){
            System.out.println("URL "+ urlArananKelime+" kelimesini iceriyor TEST PASS");
        }else{
            System.out.println("URL "+ urlArananKelime+ " kelimesini iceriyor TEST FAILED");
        }
// 8- "Nutella" icin arama yapiniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella");
// 9- Kac sonuc bulundugunu yaziniz
        WebElement  sonucYazdirmaElementi = driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazdirmaElementi.getText());
// 10-Sayfayi kapatin
        driver.close();


    }
}
