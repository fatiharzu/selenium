package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        /*
        //getPageSource() returns page source code as a string
        //We might use this to verify if a certain text exist in the entire page
        //Note that pageSource is not used a lot to do assertions
         //Because it is too general and can lead false result
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

      //getting the page source
        String pageSource = driver.getPageSource();

        // cehecking if 'Best Seller' exist on the page
        if (pageSource.contains("Registry")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.quit();
    }
}
