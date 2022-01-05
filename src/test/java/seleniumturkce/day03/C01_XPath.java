package seleniumturkce.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1- https:fitheinternet.herokuapp_._comtadd_remove_elententsi adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//        2- Add Element butonuna basin
            // TAMAMMI CALISIYOR //
//        WebElement addButonu = driver.findElement(By.tagName("button"));
//        WebElement addButonu = driver.findElement(By.xpath("//button"));
//        WebElement addButonu = driver.findElement(By.xpath("//button[text()='Add Element']"));
//        WebElement addButonu = driver.findElement(By.xpath("//*[text()='Add Element']"));
        WebElement addButonu = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        Thread.sleep(1000);
        addButonu.click();
//        3- Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("delete butonu testi PASS");
        }else{
            System.out.println("delete butonu testi FAILED");
        }
//        4- Delete tusuna basin
        deleteButonu.click();

//        5- Delete butonunun gorunur olmadigini test edin
        // Eger butona bastigimizda HTML kodunda ki satir siliniyorsa driver in o elemente ulasmasi mumkun olmayacagindan
        //varligi yada yoklugu test etmeniz mumkun olmaz varolan bir element bu sekilde silindikten sonra locate etmeye
        // calisirsak ==> StaleElementReferenceException:  bu hatayi exception i aliriz
/*        if (!deleteButonu.isDisplayed()){
            System.out.println("delete butonu gorunmuyor testi PASS");
        }else{
            System.out.println("delete butonu gorunmuyor testi FAILED");
      }
*/  driver.close();
    }

}
