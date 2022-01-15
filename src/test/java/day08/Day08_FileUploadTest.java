package day08;

import com.myfirstproject.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
     WebElement chooseFile = driver.findElement(By.id("file-upload"));
     //We have download.png on Desktop use it
        String pathOfImage = System.getProperty("user.home")+ "/Desktop/download.png";
        System.out.println("pathOfImage = "+pathOfImage);

        Thread.sleep(2000);
        chooseFile.sendKeys(pathOfImage);
        Thread.sleep(2000);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(2000);

        String expectedMessage = "File Uploaded!";

        WebElement message = driver.findElement(By.xpath("//h3"));

        String actualMessageText = message.getText();
        Assert.assertEquals(expectedMessage,actualMessageText);
    }
}
