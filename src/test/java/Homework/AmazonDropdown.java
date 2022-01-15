package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
//   Create A Method dropdownTest
    @Test
    public void dropdownTest(){
//  Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//  Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
//  --------------------------------------------------------------------------------------------------------------------
        try{
            driver.findElement(By.xpath("No,thanks")).click();
        }catch(Exception e){
            e.getMessage();
        }
//  --------------------------------------------------------------------------------------------------------------------
        Select select = new Select(dropDown);
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);
        Assert.assertEquals("All Departments",firstSelectedOption);

//  Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you
//  select you to need to use the get first selected option method)
        String fourthOption = select.getOptions().get(3).getText();
        System.out.println("Fourth Element: "+fourthOption);

//  Print all of the dropdown options
        List<WebElement> allOptions = select.getOptions();

        for(WebElement each : allOptions){
            System.out.println("All list: "+each.getText());
        }

//  Print the total number of options in the dropdown
        int totalNumber = allOptions.size();
        System.out.println("Number of elements: "+totalNumber);

//  Check if Appliances is a drop-down option. Print true if “Appliances” is an option. Print false
//  otherwise
        if (allOptions.contains("Appliances")) {
            System.out.println("True: 'Appliances' is an option");
        }else {
            System.out.println("False: 'Appliances' is NOT an option");
        }

    }
    @After
    public void tearDown(){

    }
}
