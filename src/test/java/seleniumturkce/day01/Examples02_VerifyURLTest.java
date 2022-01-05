package seleniumturkce.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Examples02_VerifyURLTest {
    public static void main(String[] args) {
        /*
        Yeni bir calss olusturalim : (VerifyURLTest)
        Techproeducation ana sayfasina gidelim https://www.techproeducation.com/
        sayfa URL sinin www.techproeducation.com oldugunu dogrulayin
         */

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.techproeducation.com");

        String expectedUrl ="www.techproeducation.com";
        String currentUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(currentUrl)){
            System.out.println("Istenilen URL dogrulanmistir.");
        }else{
            System.out.println("Istenilen URL dogrulanmamistir.");
            System.out.println("Gecerli URL: "+driver.getCurrentUrl());
        }




        driver.close();
    }
}
