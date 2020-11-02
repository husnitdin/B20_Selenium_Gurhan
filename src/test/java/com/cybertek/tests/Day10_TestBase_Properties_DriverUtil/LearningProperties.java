package com.cybertek.tests.Day10_TestBase_Properties_DriverUtil;

import org.apache.commons.exec.OS;
import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_test(){
        System.out.println("Your system name: " + System.getProperty("os.name"));
        System.out.println("Your system user name:  " + System.getProperty("user.name"));
        System.out.println("System password: " + System.getProperty("password.name"));
    }
}

