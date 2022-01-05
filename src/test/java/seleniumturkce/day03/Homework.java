package seleniumturkce.day03;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Homework {
    public static void main(String[] args) {
        // amazon.com a gidin java kelimesini aratip
        //kac sonuc geldigini
        // ve gelen sonuclardan 4 ve 7 sinin isimlerini yazdirin
       System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement arama =driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("java"+ Keys.ENTER);
        WebElement sonucYazdirma=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazdirma.getText());
        WebElement dorduncuElement =driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[4]"));
        WebElement yedinciElement = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[7]"));
        System.out.println(yedinciElement.getText());
        System.out.println(dorduncuElement.getText());
    }


}
