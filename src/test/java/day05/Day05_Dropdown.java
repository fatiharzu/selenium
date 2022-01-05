package day05;

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

import java.time.Duration;
import java.util.List;

public class Day05_Dropdown {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void selectByIndexText() throws InterruptedException {
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);
//      3- selecting  the option by index
        Thread.sleep(2000);
        select.selectByIndex(1); // Option 1

        Thread.sleep(2000);
        select.selectByIndex(2);    // Option 2

        Thread.sleep(2000);
        select.selectByIndex(1); // Option 1
    }
    @Test
    public void selectByValueTest() throws InterruptedException {
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);
//      3- selecting  by value
        Thread.sleep(2000);
        select.selectByValue("1"); // option 1

        Thread.sleep(2000);
        select.selectByValue("2"); // option 2

        Thread.sleep(2000);
        select.selectByValue("1"); // option 1
    }
    @Test
    public void selectByVisibleText() throws InterruptedException {
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);
//      3-   selectByVisibleText
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1"); //option 1

        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");// option 2

        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");// option 1
    }
    // 4. Creating method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);

//      getOptions(); returns ALL OPTIONS as List
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption:allOptions) {
            System.out.println(eachOption.getText());
        }
    }
    // 5. Create method printFirstSelectedOptionTest  Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);
//      3- printFirstSelectedOptionTest
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected Option "+ selectedOption.getText());


     // Assertion
        Assert.assertEquals("Please select an option", selectedOption.getText());

    }
    // 6 Find the size of the dropdown
    //print " Expect I Not Equal Actual" if there are not 4 elements in the dropdown
    @Test
    public void sizeTest(){
//      1- Locate the dropdown element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//      2- use select object
        Select select = new Select(dropDown);

//      getting all options
        List<WebElement> allOptions = select.getOptions();

//      finding the number of options
        int numberOfOption = allOptions.size(); //Actual 3
        Assert.assertEquals("Expected I Not Equal Actual", numberOfOption, 3);// 3 PASS
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
