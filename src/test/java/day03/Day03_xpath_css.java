package day03;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03_xpath_css {
WebDriver driver;
  @Before
  public void setUp(){
     System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("http://a.testaddressbook.com/sign_in");
  }

   @Test
   public void xpath_css() throws InterruptedException {

//          locating email box using xpath
      WebElement emailBox=driver.findElement(By.xpath("//input[@id='session_email']"));
//          typing the email
      emailBox.sendKeys("testtechproed@gmail.com");
      Thread.sleep(2000);
//          locating password box using xpath
      WebElement passwordBox=driver.findElement(By.xpath("//input[@id='session_password']"));
//          typing password
      passwordBox.sendKeys("Test1234!");
      Thread.sleep(2000);
//          locating sing in button
      WebElement signInButton=driver.findElement(By.xpath("//input[@type='submit']"));
      Thread.sleep(2000);
//            clicking
      signInButton.click();
      Thread.sleep(2000);
   }
   @After
   public void tearDown(){
      driver.close();
   }
}
