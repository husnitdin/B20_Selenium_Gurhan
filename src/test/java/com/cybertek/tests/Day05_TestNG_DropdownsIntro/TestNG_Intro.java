package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.print.DocFlavor;

public class TestNG_Intro {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void treadDownClass(){
        System.out.println("After class is running...");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod is running...");
    }

   @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }

    @Test
    public void test3(){
        String str1 = "TestNG";
        String str2 = "TestNG";
        String str3 = "asdajdka";

        Assert.assertTrue(str2.equals(str3));
        Assert.assertTrue(str2.equals(str1), "str2 is not equal to str3");

        Assert.assertEquals(str1, str3, "str1 is not equal to str3");
    }
}
