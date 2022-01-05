package day05;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_JavaFaker {
    @Test
    public void fakerTest(){
//      Java faker can be used for genrating fake test data
//      name, lastname, job, title, phone nember, email, city, state, country ...

//      1. Create a Faker object
        Faker faker=new Faker();

//      2. Generate some fake data(mock data)
        String fakeName =faker.name().firstName();
        String fakeLName =faker.name().lastName();
        String fullFakeName = faker.name().fullName();
        String fakeUserName = faker.name().username();

        System.out.println("Name: "+fakeName);
        System.out.println("Last Name: "+fakeLName);
        System.out.println("Full Name: "+fullFakeName);
        System.out.println("User Name: "+fakeUserName);

//          title
        System.out.println(faker.name().title());
//          city
        System.out.println(faker.address().city());
//          state
        System.out.println(faker.address().state());
//          phonenumber
        System.out.println(faker.phoneNumber().cellPhone());
//          e-mail
        System.out.println(faker.internet().emailAddress());
//          random 5 digit number
        System.out.println(faker.number().digit());//zipp code
    }
}
