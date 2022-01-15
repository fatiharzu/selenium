package Seleniumturkce.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework01 {
    public static void main(String[] args) {
        /*
        Tekrar Testi
1. Yeni bir class olusturun (TekrarTesti)
2. Youtube web sayfasina gidin ve sayfa basliginin "youtube" olup olmadigim dogrulaym (verify), eger degilse dogru basligi(Actual Title) konsolda yazdirin.
3. Sayfa URL'sinin "youtube" icerip icermedigini (contains) dogrulaym, icermiyorsa dogru URL'yi yazdirin.
4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
5. Youtube sayfasina geri donun
6. Sayfayi yenileyin
7. Amazon sayfasina donun
8. Sayfayi tamsayfa yapin
9. Ardindan sayfa bashomm "Amazon" icerip icermedigini (contains) dogrulaym, Yoksa dogru bashoi(Actual Title) yazdirm.
10.Sayfa URL'sinin https://www.amazon.com/ olup olmadigmi dogrulaym, degilse dogru URL'yi yazdirin
11.Sayfayi kapatin
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");
        String expectedTitle ="youtube";
        String actuelTitle=driver.getTitle();
        if (expectedTitle.equals(actuelTitle)){
            System.out.println("youtube aktuel basligi dogrudur");
        }else{
            System.out.println("youtube aktuel basligi dogru degildir");
            System.out.println("actuel baslik: "+driver.getTitle());
        }
        String expectedUrl="youtube";
        String actuelUrl= driver.getCurrentUrl();
        if (expectedUrl.contains("youtube")){
            System.out.println("Istenen URL nin icinde youtube vardir.");
        }else{
            System.out.println("Istenen URL nin icinde youtube yoktur");
        }
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().maximize();
        String expectedTitle2="Amazon";
        String actuelTitle2=driver.getTitle();
        if (expectedTitle2.contains("Amazon")){
            System.out.println("Test Basarili");
        }else{
            System.out.println("Test basarisiz");
            System.out.println("Aktuel Title:" + driver.getTitle());
        }
        String expectedUrl2 = "https://www.amazon.com/";
        String currentlUrl2 = driver.getCurrentUrl();
        if (expectedUrl2.equals(currentlUrl2)){
            System.out.println("Amazon URL dogrudur");
        }else{
            System.out.println("Amazon URL YANLIS");
            System.out.println("DOGRU URL: "+driver.getCurrentUrl());
        }


    driver.close();
    }

}
