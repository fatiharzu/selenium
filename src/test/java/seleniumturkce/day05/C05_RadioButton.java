package seleniumturkce.day05;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05_RadioButton {
    /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi oluşturun ve aşağıdaki görevi tamamlayın.
    - https://www.facebook.com adresine gidin
    - "Create an Account" button'una basin
    - "radio buttons" elementlerini locate edin
    - Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[.='Allow All Cookies']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys(faker.name().lastName());
        WebElement radioButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));

        if (!radioButton.isSelected()){
                radioButton.click();
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
