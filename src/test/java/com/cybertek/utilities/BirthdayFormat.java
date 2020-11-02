package com.cybertek.utilities;

import com.github.javafaker.Faker;

public class BirthdayFormat {

    public static String bDay() {
        Faker faker = new Faker();

        String bday = faker.date().birthday().toString();
        String bdayResult = bday.substring(4, 7)+"/"+bday.substring(8, 10)+"/"+bday.substring(24);

        if (bdayResult.substring(0, 3).equals("Jan")) {
            bdayResult = "01"+bdayResult.substring(3);
        }else if (bdayResult.substring(0, 3).equals("Feb")) {
            bdayResult = "02"+bdayResult.substring(3);
        }else if (bdayResult.substring(0, 3).equals("Mar")) {
            bdayResult = "03"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Apr")) {
            bdayResult = "04"+bdayResult.substring(3);
        }else if (bdayResult.substring(0, 3).equals("May")) {
            bdayResult = "05"+bdayResult.substring(3);
        }else if(bdayResult.substring(0, 3).equals("Jun")){
            bdayResult = "06"+bdayResult.substring(3);
        }else if (bdayResult.substring(0, 3).equals("Jul")) {
            bdayResult = "07"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Aug")) {
            bdayResult = "08"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Sep")) {
            bdayResult = "09"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Oct")) {
            bdayResult = "10"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Nov")) {
            bdayResult = "11"+bdayResult.substring(3);
        } else if (bdayResult.substring(0, 3).equals("Dec")) {
            bdayResult = "12"+bdayResult.substring(3);
        }

        return bdayResult;
    }

}
