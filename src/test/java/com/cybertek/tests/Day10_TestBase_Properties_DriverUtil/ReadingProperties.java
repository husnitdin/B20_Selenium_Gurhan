package com.cybertek.tests.Day10_TestBase_Properties_DriverUtil;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file() throws IOException {
        // Properties: use Properties class object
        // we create properties object to read configuration.properties file
        Properties properties = new Properties();

        // FileInputStream: opens the file
        // copy path from Content Root
        String path = "configuration.properties";

        // We need to pass the path of the file
        FileInputStream file = new FileInputStream(path);

        // We will load the file
        properties.load(file);

        // We read from the file
        System.out.println("properties of browser = " + properties.getProperty("browser"));
        System.out.println("properties of name = " + properties.getProperty("username"));
        System.out.println("properties of url = " + properties.getProperty("url"));

        // Close the file
        file.close();
    }

    @Test
    public void using_properties_utility_method(){

        // this will read the given "key's" value
        // and return it as a String
        ConfigurationReader.getProperty("browser");
        ConfigurationReader.getProperty("username");
        ConfigurationReader.getProperty("smartBearURL");
    }

}
