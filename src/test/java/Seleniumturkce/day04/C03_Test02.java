package Seleniumturkce.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


// 1. https://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");

// 2. Signin buttonuna tikloyin
        driver.findElement(By.id("signin_button")).click();
// 3. Login alanine "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

// 4. Password alanina "password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
// 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
// 6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();

// 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("1000");
// 8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
// 9. Pay buttonuna tiklayin+
        driver.findElement(By.id("pay_saved_payees")).click();
// 10."The payment sms successfully submitted." mesajinin ciktigini control edin
        WebElement basariliYazisi = driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (basariliYazisi.isDisplayed()){
            System.out.println("TEST PASS");
        }else{
            System.out.println("TEST FAILED");
        }

 driver.close();
    }
}
