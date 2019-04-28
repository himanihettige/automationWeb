package com.pages;

import com.stepdefinitions.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class contactUsDT_page extends DriverClass {

    public void SubjectHeading(String Subject_Heading)  {

        Select SubHeading =new Select(driver.findElement(By.id("id_contact")));
        if(Subject_Heading.equalsIgnoreCase("-- Choose --"))
        {
            SubHeading.selectByValue("0");
        }
        else if(Subject_Heading.equalsIgnoreCase("Customer Service"))
        {
            SubHeading.selectByValue("2");
        }
        else if(Subject_Heading.equalsIgnoreCase("Webmaster"))
        {
            SubHeading.selectByValue("1");
        }

    }


    public void EmailAddress(String Email)  {
        driver.findElement(By.id("email")).sendKeys(Email);

    }


    public void OrderReference(String Order_Ref)  {
        driver.findElement(By.id("id_order")).sendKeys(Order_Ref);
    }


    public void ChooseAFile() {
        String path=System.getProperty("user.dir");
        driver.findElement(By.name("fileUpload")).sendKeys(path+"/src/test/java/com/TestData/Sample.txt");
    }


    public void Message(String message1) {
        driver.findElement(By.id("message")).sendKeys(message1);
    }

    public void SendButton() {
        driver.findElement(By.name("submitMessage")).click();
    }

    public void SeeUrl(String controller_url) throws InterruptedException {

        String ActualURL= driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(controller_url,ActualURL);
    }

    public void SeeMessage(String message)  {

        String ActualMessage=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p")).getText();
        Assert.assertEquals(message,ActualMessage);

    }
    public void Err_message(String err_message)  {
        ///html/body/div/div[2]/div/div[3]/div/div/p

      //  String actualmsg=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        String actualmsg=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).getText();
        actualmsg=actualmsg.replace("\n"," ");
        System.out.println(actualmsg);
        System.out.println(err_message);
        Assert.assertEquals(err_message,actualmsg);

    }

    public void Err_msg(String err_msg)  {

        //String actualmsg1=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText();
        ///html/body/div/div[2]/div/div[3]/div/div/ol/li
        String actualmsg1=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).getText();
        actualmsg1=actualmsg1.replace("\n"," ");
         System.out.println(actualmsg1);
         System.out.println(err_msg);
        Assert.assertEquals(err_msg,actualmsg1);
    }
}



