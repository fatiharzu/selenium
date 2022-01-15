package Seleniumturkce.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {
        /*
      1. Bir class oluşturun: Locators
      2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
            a. http://a.testaddressbook.com adresine gidiniz.
            b. Sign in butonuna basin
            c. email textbox,password textbox, and signin button elementlerini locate ediniz..
            d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
                    i. Username : testtechproed©gmail.com
                   ii. Password : Test1234!
            e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
            f. "Addresses" ve "Sign Out" textlerinin görüntütendiğini( displayed) doğrulayin(verify).
      3. Sayfada kac tane link oldugunu bulun.
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com");
        driver.manage().window().maximize();
        WebElement signInLinki= driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        Thread.sleep(2000);

        WebElement emailTextBox = driver.findElement(By.name("session[email]"));
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        WebElement signInButonu=driver.findElement(By.name("commit"));

        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
        WebElement dogruKullanici = driver.findElement(By.className("navbar-text"));
        String userName="testtechproed@gmail.com";
        if (dogruKullanici.getText().equals(userName)) {
            System.out.println("dogru kullanici testi. PASS");

        }else{
            System.out.println("dogru kullanici testi. FAILED");
        }
        WebElement addressesLinki = driver.findElement(By.linkText("Addresses"));
        WebElement singOutLinki = driver.findElement(By.linkText("Sign out"));

        if (addressesLinki.isDisplayed()){
            System.out.println("addresses linki gorunuyor, test PASS");
        }else{
            System.out.println("addresses linki gorunmuyor; test FAILED");
        }
        if (singOutLinki.isDisplayed()){
            System.out.println("singOutLinki linki gorunuyor, test PASS");
        }else{
            System.out.println("singOutLinki linki gorunmuyor; test FAILED");
        }

        // 3. Sayfada kac tane link oldugunu yazdirin

        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        System.out.println("Sitenin giris sayfasinda olan link sayisi ====>"+linkler.size());

        //linklerin yazilarini yazdiralim
        ///elimizdeki tum web elementlerin yazilarini for loop veyafor-each loop ile yazdiralim
        //tum elementler yazdirilacaksa for each loop daha kullanisli olacaktir.

        int sira=1;
        for (WebElement each:linkler)
        {
            System.out.println(sira+" "+each.getText());
            sira++;
        }
      //  driver.close();
    }

}
