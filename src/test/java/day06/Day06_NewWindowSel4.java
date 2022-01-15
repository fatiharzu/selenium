package day06;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewWindowSel4 {


    @Test
    public void newWindowTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Open google in window 1
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle();

        //Open amazon in window 2
        //Creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        //Open linkedin in window 2
        //Creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

//        SWITCH BACK TO google window
        Thread.sleep(2000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("GOOGLE URL => "+driver.getCurrentUrl());

//        SWITCH BACK TO amazon window
        Thread.sleep(2000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("AMAZON URL => "+driver.getCurrentUrl());

//        SWITCH BACK TO linkedin window
        Thread.sleep(2000);
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("LINKEDIN URL => "+driver.getCurrentUrl());
    }
}
