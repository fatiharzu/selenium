package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    /*
    Making this abstract, because we just want to implemetn the methods without showing the details
    we also do not want to create an object on TestBase
    Test Base will have only two methods
    1. Before
    2. After
        Why TestBase
        We use TestBase for REPATED PRE CONDITION AND AFTER CONDITION
        This will make actual test class shorter
     */
   protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
//        driver.close();
    }
}
