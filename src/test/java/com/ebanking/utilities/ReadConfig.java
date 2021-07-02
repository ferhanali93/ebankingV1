package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    // First we have to create an object of a properties class.
    Properties pro;

    // Second we need to create a constructor
    public ReadConfig(){

        // Reading from a config.properties file
        File src = new File("./Configuration/config.properties");

        // We need to handle exceptions when reading from a config.properties file
        try {
            // Opening a file in input stream
            FileInputStream fis = new FileInputStream(src);

            //initializing
            pro = new Properties();

            // load is a method that will load a complete file
            pro.load(fis);

        } catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL(){
        String url = pro.getProperty("baseUrl");
        return url;
    }

    public String getUsername(){
        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String password = pro.getProperty("password");
        return password;
    }
    public String getChromePath(){
        String chromePath = pro.getProperty("chromepath");
        return chromePath;
    }
    public String getFirefoxPath(){
        String firefoxPath = pro.getProperty("firefoxpath");
        return firefoxPath;
    }
    public String getIEPath(){
        String IEPath = pro.getProperty("iepath");
        return IEPath;
    }
}
