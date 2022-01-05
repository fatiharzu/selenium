package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
 //         System.setProperty("DRIVER TYPE","DRIVER PATH")
 //         System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");==> chromedriver.exe  ==> for WINDOWS
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//      Creating the WebDriver object
//      Polymorphism
        WebDriver driver = new ChromeDriver();

        //Now that I crated driver object, I can use that to interact with the web based application
        //get(""); -> used to go to a URL
        driver.get("https://www.google.com/");
    }
}
