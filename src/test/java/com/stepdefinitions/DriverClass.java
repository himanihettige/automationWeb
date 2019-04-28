package com.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverClass {

    public static WebDriver driver;


    public void openBrowser() throws IOException {

        String browser = System.getProperty("browser");

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


       // driver.get("http://automationpractice.com/index.php");

        String env=System.getProperty("env");
        String path=System.getProperty("user.dir");
        String file=null;

        if(env.equalsIgnoreCase("qa")){
            file=path+"/src/test/java/com/propertyfiles/environment_qa.properties";

        }
        else if(env.equalsIgnoreCase("uat")){
            file=path+"/src/test/java/com/propertyfiles/environment_uat.properties";

        }
        else if(env.equalsIgnoreCase("prod")){
            file=path+"/src/test/java/com/propertyfiles/environment_prod.properties";
        }

        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(file);

        properties.load(fileInputStream);
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("username"));

        driver.get(properties.getProperty("url"));


        driver.manage().window().maximize();

    }



    public void closeBrowser (){
        driver.close();


    }
}