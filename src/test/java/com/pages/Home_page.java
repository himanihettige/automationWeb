package com.pages;

import com.stepdefinitions.DriverClass;
import org.openqa.selenium.By;

public class Home_page extends DriverClass {

    public void clickSigninlink_Homepage(){
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void ContactUsLink_HomePage() {
        driver.findElement(By.linkText("Contact us")).click();
    }
}
