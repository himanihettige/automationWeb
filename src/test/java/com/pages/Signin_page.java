package com.pages;

import com.stepdefinitions.DriverClass;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Signin_page extends DriverClass {

    public void EnterTitle(String signin_Title) {

        if (signin_Title.equalsIgnoreCase("Mr")) {
            driver.findElement(By.id("id_gender1")).click();
        } else {
            driver.findElement(By.id("uniform-id_gender2")).click();
        }
    }


    public void EnterFirstName(String signin_FirstName) {
        driver.findElement(By.id("customer_firstname")).sendKeys(signin_FirstName);
    }


    public void EnterLastName(String signin_LastName) {
        driver.findElement(By.id("customer_lastname")).sendKeys(signin_LastName);
    }


    public void EnterEmail(String signin_Email) {
        driver.findElement(By.id("email")).sendKeys(signin_Email);
    }


    public void EnterPassword(String signin_Passwd) {
        driver.findElement(By.id("passwd")).sendKeys(signin_Passwd);
    }

    public void EnterDOBDay(String signin_Days) {
        Select days_select  = new Select(driver.findElement(By.id("days")));
        days_select.selectByValue(signin_Days);
    }


    public void EnterDOBMonth(String signin_Month) {
        Select months_select =new Select(driver.findElement(By.id("months")));
        if(signin_Month.equalsIgnoreCase("January")){
            months_select.selectByVisibleText("January ");
        }
        else if (signin_Month.equalsIgnoreCase("February ")){
            months_select.selectByVisibleText("February ");
        }
        else if(signin_Month.equalsIgnoreCase("March")){
            months_select.selectByVisibleText("March ");
        }
        else if(signin_Month.equalsIgnoreCase("April")){
            months_select.selectByVisibleText("April ");
        }
        else if(signin_Month.equalsIgnoreCase("May")){
            months_select.selectByVisibleText("May ");
        }
        else if(signin_Month.equalsIgnoreCase("June")){
            months_select.selectByVisibleText("June ");
        }
        else if(signin_Month.equalsIgnoreCase("July")){
            months_select.selectByVisibleText("July ");
        }
        else if(signin_Month.equalsIgnoreCase("August")){
            months_select.selectByVisibleText("August ");
        }
        else if(signin_Month.equalsIgnoreCase("September")){
            months_select.selectByVisibleText("September ");
        }
        else if(signin_Month.equalsIgnoreCase("October")){
            months_select.selectByVisibleText("October ");
        }
        else if (signin_Month.equalsIgnoreCase("November")){
            months_select.selectByVisibleText("November ");
        }
        else if(signin_Month.equalsIgnoreCase("December")){
            months_select.selectByVisibleText("December ");
        }
        //months_select.selectByVisibleText(signin_Month);
        // months_select.selectByValue(signin_Month);
    }


    public void EnterDOBYear(String signin_Year) {
        new Select(driver.findElement(By.id("years"))).selectByValue(signin_Year);

    }

    public void SignUpForNewsletter() {
        driver.findElement(By.id("newsletter")).click();
    }


    public void ReceiveSpecialOffersFromOurPartners() {
        driver.findElement(By.id("optin")).click();
    }


    public void EnterCompany(String signin_Company) {
        driver.findElement(By.id("company")).sendKeys(signin_Company);
    }


    public void EnterAddress(String signin_Address1)  {
        driver.findElement(By.id("address1")).sendKeys(signin_Address1);
    }


    public void EnterAdresssLineTwo(String signin_Address2) {
        driver.findElement(By.id("address2")).sendKeys(signin_Address2);
    }


    public void EnterCity(String signin_City) {

        driver.findElement(By.id("city")).sendKeys(signin_City);
    }

    public void SelectedState(String signin_State)  {
        Select stateid = new Select(driver.findElement(By.id("id_state")));
        if(signin_State.equalsIgnoreCase("Califonia")){
            stateid.selectByValue("5");
        }
        else if(signin_State.equalsIgnoreCase("New Jersey")) {
            stateid.selectByValue("30");
        }
        else if(signin_State.equalsIgnoreCase("New York")) {
            stateid.selectByValue("32");
        }
    }

    public void EnterZipPostalCode(String signin_Postcode)  {
        driver.findElement(By.id("postcode")).sendKeys(signin_Postcode);
    }


    public void SelectedCountry(String signin_Country)  {
        driver.findElement(By.id("id_country")).sendKeys(signin_Country);
    }


    public void EnterAdditionalInformation(String signin_AddInfo)  {
        driver.findElement(By.id("other")).sendKeys(signin_AddInfo);
    }


    public void EnterHomePhone(String signin_Homephone)  {
        driver.findElement(By.id("phone")).sendKeys(signin_Homephone);
    }


    public void EnterMobilePhone(String signin_Mobilephone)  {
        driver.findElement(By.id("phone_mobile")).sendKeys(signin_Mobilephone);
    }


    public void EnterAssignAnAddressAliasForFutureReference(String signin_Alias)  {
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(signin_Alias);
    }


    public void ClickRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }


    public void ErrorMessage(String Expectederror) throws InterruptedException {
        Thread.sleep(2000);
        String actualmsg = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
        Assert.assertEquals(actualmsg, Expectederror);

    }


    public void AccountCreationUrl(String ExpectedURL) throws InterruptedException {
        Thread.sleep(3000);
        String ActualURL = driver.getCurrentUrl();
        System.out.println("Actual " + ActualURL);
        System.out.println("expected" + ExpectedURL);
        Assert.assertEquals(ActualURL, ExpectedURL);
    }



    public void AccountPageUrl(String Expected_URL) throws InterruptedException {
        Thread.sleep(3000);
        String ActualURL = driver.getCurrentUrl();
        System.out.println("Actual " + ActualURL);
        System.out.println("expected" + Expected_URL);
        Assert.assertEquals(ActualURL, Expected_URL);
    }


    public void SigninPageErrorMessage(String ErrorMsg1)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/p")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg1);

    }
    public void SigninPageSecondErrorMessage(String ErrorMsg2)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg2);
    }

    public void SigninPageSecErrorMessage(String ErrorMes2)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[1]")).getText();
        Assert.assertEquals(actualmsg, ErrorMes2);
    }


    public void SigninPageThirdErrorMessage(String ErrorMsg3)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[2]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg3);
    }



    public void SigninPageFourthErrorMessage(String ErrorMsg4)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[3]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg4);
    }


    public void SigninPageFifthErrorMessage(String ErrorMsg5)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[4]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg5);
    }


    public void SigninPageSixthErrorMessage(String ErrorMsg6)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[5]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg6);
    }


    public void SigninPageSeventhErrorMessage(String ErrorMsg7)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[6]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg7);
    }


    public void SigninPageEighthErrorMessage(String ErrorMsg8)  {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[7]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg8);
    }


    public void SigninPageNighthErrorMessage(String ErrorMsg9) {
        String actualmsg = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li[8]")).getText();
        Assert.assertEquals(actualmsg, ErrorMsg9);
    }

}
