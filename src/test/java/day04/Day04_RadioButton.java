package day04;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
//  --------------------------------------------------------------------------------------------------------------------
    @Test
    public void radioButton() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@id='u_0_j_Pn']")).click();
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Myname");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lastname");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1111111");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Secretpass1!");
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
//  --------------------------------------------------------------------------------------------------------------------

//        NOTE: some ids might be DYNAMIC if id has NUMBER
//        It means id values can change after the next usage.
//        For this reason, we need to avoid using dynamic ids
//        HOW DO YOU HANDLE DYNAMIC ID?????
//        - Dynamic id means id value can change. In this case, i don't prefer to use id
//        If I have to use it I WRITE DYNAMIC XPATH!!!
//        I find what is the same every single time then write dynamic xpath
//        I can use contains, start-with or ends-with dynamic xpath

//        tag[contains(@attribute,’value’)]     => (//input[contains(@id,'u_')])[1]
//        tag[starts-with(@attribute,’value’)]   => (//input[starts-with(@id,’u_')])[1]  Returns the first input whose id starts with u_
//        tag[ends-with(@attribute,’value’)]    => //input[ends-with(@id,’P7’)] Returns the input elements who ends with P7
//  --------------------------------------------------------------------------------------------------------------------
    // Selecting birth month
        WebElement month =driver.findElement(By.id("month"));
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("Jun");

     // Selecting birth day
        WebElement day =driver.findElement(By.id("day"));
        Select daySelect = new Select(day);
        daySelect.selectByIndex(2);

    // Selecting birth year
        WebElement year =driver.findElement(By.id("year"));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("2000");

    //Clicking on the sign up
        driver.findElement(By.name("websubmit")).click();



    }

}
