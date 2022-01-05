package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) throws InterruptedException {
//      Step 1: set the path and driver name
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

//      Step 2: create WebDriver object
        WebDriver driver = new ChromeDriver();

//      Step 3: now I have driver, I can use driver in automation
       // go to google  Open google home page https://www.google.com/.
        driver.get("https://www.google.com");

//        Maximize the window
        driver.manage().window().maximize();

        Thread.sleep(3000);//3 seconds hard wait (if we have red underline==> hoverover and tread exception
//        On the same class, Navigate to amazon home page https://www.amazon.com/
//          navigate() is also used to go to the webpages
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

//        Navigate back to google
        driver.navigate().back();
        Thread.sleep(2000);

//        Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(2000);

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
//       driver.quit();//  we can use also  ==>  driver.close():
        driver.close();
/*  --------------------------------------------------------------------------------------------------------------------
    ****What is the difference between get() and navigate.to ?
    1. get() easier to use, used more than navigate()
    2. get() a little faster
    3. get() takes only String, but navigate.to takes String or URL as parameter
    4. navigate has more options: back, forward, refresh
    --------------------------------------------------------------------------------------------------------------------
    *****What is the difference between close and quit
    - close() --> closes only current working browser
    - quit() --> closes all browsers. and more stronger
    --------------------------------------------------------------------------------------------------------------------
    *****What is Thread.sleep()?
    - It is used to put some wait.
    *  Thread.sleep(2000); puts 2 seconds ON THIS STEP
    -Thread.sleep is a JAVA wait. It is not a selenium wait.
    * Because this is HARD wait.
    * It means, this will put extra wait EVEN IF WE DON'T NEED
    * We will use selenium waits. They will be DYNAMIC WAIT.
    --------------------------------------------------------------------------------------------------------------------
     */
    }
}
