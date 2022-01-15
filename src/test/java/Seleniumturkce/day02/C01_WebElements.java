package Seleniumturkce.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebElements {
    public static void main(String[] args) throws InterruptedException {
/*
<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email"
placeholder="E-posta veya Telefon Numarası" autofocus="1" aria-label="E-posta veya Telefon Numarası">
 */

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // email text box a ali yazdiralim
        WebElement mailTextBox = driver.findElement(By.id("email"));
        mailTextBox.sendKeys("aliseleniumcu@gmail.com");
        Thread.sleep(2000);
        mailTextBox.clear();
        WebElement mailKutusuTagName = driver.findElement(By.tagName("input"));
//        mailKutusuTagName.sendKeys("veligocer@gmail.com");
//        input tagname  ile 6 tane webelement oldugundan hangisine yazacagina karar veremiyor
//        weblement i buldugu icin NoSuchElementException vermez
//  --------------------------------------------------------------------------------------------------------------------
//        WebElement yanlisElement = driver.findElement(By.id("emailyanlis"));
        //NoSuchElementException: bu hatayi goruyorsak LOCATOR i gozden gecirmemiz gerekecek.
//        yanlisElement.sendKeys("yanlis eleman");
//  --------------------------------------------------------------------------------------------------------------------
//      giris yap butonuna tiklayalim

        WebElement girisButonu = driver.findElement(By.tagName("button"));
        System.out.println(girisButonu.isEnabled());
        girisButonu.click();




    }
}
