//package com.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


//public class contactUs_SD extends DriverClass {
//
////    @When("^I click contact us Link on Home Page$")
////    public void iClickContactUsLinkOnHomePage()
////    {
////        driver.findElement(By.linkText("Contact us")).click();
////
////    }
//
//    @Given("^I selected Subject Heading as \"([^\"]*)\"$")
//    public void iSelectedSubjectHeadingAs(String Subject_Heading)  {
//
//   // new Select(driver.findElement(By.id("id_contact"))).selectByValue("2");
//
//      Select SubHeading =new Select(driver.findElement(By.id("id_contact")));
//        if(Subject_Heading.equalsIgnoreCase("-- Choose --"))
//        {
//            SubHeading.selectByValue("0");
//        }
//        else if(Subject_Heading.equalsIgnoreCase("Customer Service"))
//        {
//            SubHeading.selectByValue("2");
//        }
//        else if(Subject_Heading.equalsIgnoreCase("Webmaster"))
//        {
//            SubHeading.selectByValue("1");
//        }
//
// }
//
//    @Given("^I enter valid Email address as \"([^\"]*)\"$")
//    public void iEnterValidEmailAddressAs(String Email)  {
//        driver.findElement(By.id("email")).sendKeys(Email);
//
//    }
//
//    @Given("^I enter valid Order Reference as \"([^\"]*)\"$")
//    public void iEnterValidOrderReferenceAs(String Order_Ref)  {
//        driver.findElement(By.id("id_order")).sendKeys(Order_Ref);
//    }
//
//    @Given("^I choose a File$")
//    public void iChooseAFile() {
//        String path=System.getProperty("user.dir");
//        driver.findElement(By.name("fileUpload")).sendKeys(path+"/src/test/java/com/TestData/Sample.txt");
//    }
//
//    @Given("^I entered message as \"([^\"]*)\"$")
//    public void iEnteredMessageAs(String message1) {
//        driver.findElement(By.id("message")).sendKeys(message1);
//    }
//
//
//    @When("^I click Send Button$")
//    public void iClickSendButton() {
//        driver.findElement(By.name("submitMessage")).click();
//    }
//
//
//    @Then("^I should see url \"([^\"]*)\"$")
//    public void iShouldSeeUrl(String controller_url) throws InterruptedException {
//
//        String ActualURL= driver.getCurrentUrl();
//       Thread.sleep(3000);
//       Assert.assertEquals(ActualURL,controller_url);
//    }
//
//    @Then("^I should see message \"([^\"]*)\"$")
//    public void iShouldSeeMessage(String message2)  {
//
//        String ActualMessage=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p")).getText();
//        Assert.assertEquals(ActualMessage,message2);
//
//    }

/*
    @Then("^I should see err_message \"([^\"]*)\"$")
    public void iShouldSeeErr_message(String err_message)  {
        String actualmsg=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        //System.out.println(actualmsg);
        //System.out.println(err_message);
        Assert.assertEquals(actualmsg,err_message);


    }

    @Then("^I should see err_msg \"([^\"]*)\"$")
    public void iShouldSeeErr_msg(String err_msg)  {
        String actualmsg1=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText();
       // System.out.println(actualmsg1);
       // System.out.println(err_msg);
        Assert.assertEquals(actualmsg1,err_msg);
    }

    @Given("^I keep choose a File without file$")
    public void iKeepChooseAFileWithoutFile() {

    }
}
*/