package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {
        /*
        1.Create a new class: VerifyTitleTest
	    2.Navigate to google homepage
	    3.Verify if google title is “Google”
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        //Expected title of the page
        String expectedTitle="google";
        //Actual title of a page
        String actualTitle= driver.getTitle();
        //Verification - Validation - Assertion
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verified");
        }else{
            System.out.println("Title is not verified");
            System.out.println("Current title is: "+driver.getTitle());
            System.out.println("Expected title is: "+expectedTitle);
        }
        /*
        After Verification your test failed
        Expected and Actual aren't same
        Creating a bug ticket
        Bug tracking tools -- Jira
        Developer will fix the bug by debugging
         */
        //closing the driver
        driver.close();
    }

}
