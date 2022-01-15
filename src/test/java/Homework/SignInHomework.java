package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
//1.____________________________________________________________________________________________________________________
public class SignInHomework {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//2.____________________________________________________________________________________________________________________
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void signInHomework() throws InterruptedException {
//3.____________________________________________________________________________________________________________________
        driver.findElement(By.xpath("//a[@class='login']")).click();
//4.____________________________________________________________________________________________________________________
        driver.findElement(By.xpath("//input[@class='is_required validate account_input form-control']")).sendKeys("fatihdeneme3@gmail.com"+ Keys.ENTER);
//5.____________________________________________________________________________________________________________________
        WebElement verifyingCreateAnAccount = driver.findElement(By.xpath("//h1[@class=\"page-heading\"]"));
        Assert.assertTrue("we don't have any Create Account Text",verifyingCreateAnAccount.isDisplayed());
        System.out.println(verifyingCreateAnAccount.getText());
//6.____________________________________________________________________________________________________________________
        WebElement verifyingYourPersonelInfo = driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]"));
        Assert.assertTrue("we don't have any Your Personal Info Text",verifyingYourPersonelInfo.isDisplayed());
        System.out.println(verifyingYourPersonelInfo.getText());
//7.____________________________________________________________________________________________________________________
        WebElement verifyingTitle = driver.findElement(By.xpath("//*[text()='Title']"));
        Assert.assertTrue("there is no Title text",verifyingTitle.isDisplayed());
        System.out.println(verifyingTitle.getText());
//8.____________________________________________________________________________________________________________________
        driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
//9.____________________________________________________________________________________________________________________
        driver.findElement(By.id("customer_firstname")).sendKeys("Fatih");
//10.___________________________________________________________________________________________________________________
        driver.findElement(By.id("customer_lastname")).sendKeys("Deneme");
//11.___________________________________________________________________________________________________________________
        WebElement email =driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("fatihdeneme@gmail.com");
//12.___________________________________________________________________________________________________________________
        driver.findElement(By.id("passwd")).sendKeys("asd123!");
//13.___________________________________________________________________________________________________________________
//day
        WebElement birthDay = driver.findElement(By.id("days"));
        Select selectDay = new Select(birthDay);
        selectDay.selectByIndex(6);
//monht
        WebElement birthMont = driver.findElement(By.id("months"));
        Select selectMonth = new Select(birthMont);
        selectMonth.selectByValue("4");
//year
        WebElement birthYear = driver.findElement(By.id("years"));
        Select selectYear = new Select(birthYear);
        selectYear.selectByValue("1988");
//14.___________________________________________________________________________________________________________________
        driver.findElement(By.id("uniform-newsletter")).click();
//15.___________________________________________________________________________________________________________________
        WebElement firstnameCheck =driver.findElement(By.xpath("//input[@id='firstname']"));
        firstnameCheck.clear();
        firstnameCheck.sendKeys("Fatih");
//16.___________________________________________________________________________________________________________________
        WebElement lastNameCheck =driver.findElement(By.xpath("//input[@id='lastname']"));
        lastNameCheck.clear();
        lastNameCheck.sendKeys("Deneme");
//17.___________________________________________________________________________________________________________________
        driver.findElement(By.id("company")).sendKeys("Deneme LTD");
//18.___________________________________________________________________________________________________________________
//adsress1
        driver.findElement(By.id("address1")).sendKeys("Eichenstr.2 Göppingen");
//address2
        driver.findElement(By.id("address2")).sendKeys("73033 Stutgart");
//19.___________________________________________________________________________________________________________________
        driver.findElement(By.id("city")).sendKeys("Baden-Württenberg");
//20.___________________________________________________________________________________________________________________
        WebElement state = driver.findElement(By.id("id_state"));
        Select selectState = new Select(state);
        selectState.selectByValue("43");
//21.___________________________________________________________________________________________________________________
        driver.findElement(By.id("postcode")).sendKeys("75030");
//22.___________________________________________________________________________________________________________________
        WebElement country =driver.findElement(By.id("id_country"));
        Select selectCountry =new Select(country);
        selectCountry.selectByVisibleText("United States");
//23.___________________________________________________________________________________________________________________
        driver.findElement(By.id("other")).sendKeys("I am a QA Tester");
//24.___________________________________________________________________________________________________________________
        driver.findElement(By.id("phone")).sendKeys("0 252 252 2520");
//25.___________________________________________________________________________________________________________________
        driver.findElement(By.id("phone_mobile")).sendKeys("0 555 555 5555");
//26.___________________________________________________________________________________________________________________
        driver.findElement(By.id("alias")).sendKeys("Techproeducation");
//27.___________________________________________________________________________________________________________________
        driver.findElement(By.id("submitAccount")).click();

        WebElement myAccauntDisplayed = driver.findElement(By.className("page-heading"));
        Assert.assertTrue("My Accaount not Displayed",myAccauntDisplayed.isDisplayed());
        System.out.println(myAccauntDisplayed.getText());
    }
    @Test
    public void openAccount(){
//click again login_____________________________________________________________________________________________________
     driver.findElement(By.xpath("//a[@class='login']")).click();
//type email____________________________________________________________________________________________________________
     driver.findElement(By.id("email")).sendKeys("fatihdeneme2@gmail.com");
//type password + Enter_________________________________________________________________________________________________
     driver.findElement(By.id("passwd")).sendKeys("asd123!");
//click submit and Open Account_________________________________________________________________________________________
    driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
// verify MY ACCOUNT is displayed on the home page______________________________________________________________________
     WebElement myAccauntDisplayed = driver.findElement(By.className("page-heading"));
     Assert.assertTrue("My Accaount not Displayed",myAccauntDisplayed.isDisplayed());
        System.out.println(myAccauntDisplayed.getText());
    }
    @After
    public void tearDown(){
//        driver.close();
    }

}
