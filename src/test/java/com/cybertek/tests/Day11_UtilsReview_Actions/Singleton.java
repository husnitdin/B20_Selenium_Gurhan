package com.cybertek.tests.Day11_UtilsReview_Actions;

public class Singleton {

    private Singleton(){}

    private static String word;

    public static String getWord(){
        if (word == null){
            System.out.println("First time call. word is null."+" Assigning value to it!");
            word = "something";
        } else {
            System.out.println("word already has value");
        }
        return word;
    }

}
