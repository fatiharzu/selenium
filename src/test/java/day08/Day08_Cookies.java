package day08;

import com.myfirstproject.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {
    @Test
    public void handleCookies(){
        //Go to amazon website and pront all the cookies
        driver.get("https://www.amazon.com");

        //1. Find the cookies size and print all cookies to the console
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size(); //size :8
        System.out.println("number of cookies: "+numberOfCookies);

        for (Cookie each :allCookies){
            System.out.println("eachCookie= "+each);
            System.out.println("eachCookies.getname() = "+each.getName());
            System.out.println("eachCookies.getvalue()= "+each.getValue());
        }
        System.out.println("driver.manage().getcookienamed(\"i18n-prefs\")=" + driver.manage().getCookieNamed("i18n-prefs"));
        //Adding a new cookie
        // 1.Create a cookie object

        Cookie cookie = new Cookie("My_Favorite","Sturbucks_Cookie");
        driver.manage().addCookie(cookie);
        int newSize = driver.manage().getCookies().size();
        System.out.println("newsize: "+newSize);

        driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookieNamed("skin");

        int newSize2 = driver.manage().getCookies().size();
        System.out.println("newsize2 =" +newSize2);

        // Deleting all cookies
        driver.manage().deleteAllCookies();
        int lastSize = driver.manage().getCookies().size();
        System.out.println("lastSize = " + lastSize);



    }
}
