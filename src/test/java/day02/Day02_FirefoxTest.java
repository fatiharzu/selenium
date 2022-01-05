package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Day02_FirefoxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");

//Creating firefox driver
        WebDriver driver = new FirefoxDriver();
//going to the google.com
        driver.get("https://www.google.com");

/// maximazi the window
        driver.manage().window().maximize();


        //close driver
        driver.close();
    }
}
