package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {
        /*
        Create a new class: VerifyURLTest 
        Navigate to google homepage 
        Verify if google homepage url is “www.google.com”
         */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        //getting actuel URL of the page
        String actualURL = driver.getCurrentUrl();
        //expected URL
        String expectedURL = "www.google.com";
       //Verification
        if (expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("Expected URL: "+expectedURL);
            System.out.println("Actual URL: "+actualURL);
        }
     driver.quit();
        /*
        TEST CASE FAILED
        Fail
        Expected URL: www.google.com
        Actual URL: https://www.google.com/

        Then what do you do when your test  case fails?
        1- Run script again to make sure
        2- Manual testing to make sure
        3- Now I know that expected and actual result is not the same
        4- Then we communicate with the BA(write acceptance criteria) or talk to developers, teach lead, test lead

        ~~~Tester do not fix a code. We reports the bugs. Developers then fix.

         After verifying the there is a bug then what do you do?
         1- Follow the company precedures
         2- If they are using JIRA then open a big ticket

         Ticket opened, dev told you that bug is fixed.
         1- Re-test to make sure
         2- If all good then close th bug ticket

         */
    }
}
