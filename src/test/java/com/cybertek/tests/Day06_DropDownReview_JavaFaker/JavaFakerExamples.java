package com.cybertek.tests.Day06_DropDownReview_JavaFaker;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaFakerExamples {
    @Test
    public void fakerTest() {

        // Create faker object ot be able to use methods
        Faker faker = new Faker();

        String phone = faker.phoneNumber().phoneNumber();

        System.out.println(phone);
        String xpart = phone.substring ( phone.indexOf("x") );

        /*if (phone.contains("x")){
            phone = phone.replace(xpart, "");
        }

        if (phone.substring(0, 2).equals("1-")){
            phone = phone.substring(2);
        }*/

        System.out.println(phone);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String currentDate  = date.format(formatter);

    }
}
