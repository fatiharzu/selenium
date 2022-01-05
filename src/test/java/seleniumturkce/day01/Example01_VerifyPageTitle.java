package seleniumturkce.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example01_VerifyPageTitle {
    public static void main(String[] args) {
        /*
        Yeni bir class olusturup(VerifyTitle)
        Amazon anasayfasina gidin https://www.amazon.com
        Sayfa basliginin (title) "amazon" oldugunu dogrulayin. (verify)
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");

        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title beklenen deger ile ayni, test PASS");
        }else{
            System.out.println("Title beklenenden farkli, test FAILED");
            System.out.println("Aktuel title: "+driver.getTitle());

        }
        driver.close();
    }
}
