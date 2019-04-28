package com.pages;

import com.stepdefinitions.DriverClass;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Authentication_page extends DriverClass {

    public void EnterValidEmail(String email){

        String timestamp =new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        //System.out.println(timestamp);

        String email_id1[]=email.split("@");
        String email_id2=email_id1[0]+timestamp+"@"+email_id1[1];

        driver.findElement(By.name("email_create")).sendKeys(email_id2);
    }

    public void ClickAccountButton() {
        driver.findElement(By.name("SubmitCreate")).click();
    }

    public void InvalidEmail(String invalidEmail)  {
        driver.findElement(By.name("email_create")).sendKeys(invalidEmail);
    }
    public void EnterExistingEmail(String ExistingEmail)  {
        driver.findElement(By.name("email_create")).sendKeys(ExistingEmail);

    }


}
