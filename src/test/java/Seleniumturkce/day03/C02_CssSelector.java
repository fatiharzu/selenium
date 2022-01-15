package Seleniumturkce.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//      1. Bir class oluşturun : Locators_css
//      2. Main method oluşturun ve aşağıdaki görevi tamamlayın.


//              a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

//              b. Locate email textbox
        Thread.sleep(2000);
        WebElement emailTextBox = driver.findElement(By.cssSelector(".form-control"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
//              c. Locate password textbox ve
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='session_password']"));    // css sector ile uzun yazilis
//        WebElement passwordTextBox1 = driver.findElement(By.xpath("//input[@id='session_password']"));    // xpaths ile yazilis
//        WebElement passwordTextBox2 = driver.findElement(By.cssSelector("#session_password"));            // css sector ile kisa yazilis
        passwordTextBox.sendKeys("Test1234!");  // css ile yazdirma
//        passwordTextBox1.sendKeys("Test1234!");         // xpath  ile yazdirma
//        passwordTextBox2.sendKeys("Test1234!");

//              d. Locate signin button
        WebElement signButonu = driver.findElement(By.cssSelector("input[type='submit']"));     // cssSelector
//        WebElement signButonu = driver.findElement(By.xpath("//input[@type='submit']"));       // xpath
        signButonu.click();
//              e. Asagidaki kullanici adını ve şifreyi girin ve sign in düğmesini tıklayın
//                          i. Username : testtechproed@gmail.com
//                          ii. Password : Test1234!
//      NOT: cssSelector kullanarak elementleri Locate ediniz.
    }
}
