package com.stepdefinitions;

import com.pages.Authentication_page;
import com.pages.Home_page;
import com.pages.Signin_page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Signin_SD extends DriverClass {

    public Home_page H_page=PageFactory.initElements(driver,Home_page.class);
    public Signin_page S_page= PageFactory.initElements(driver,Signin_page.class);
    public Authentication_page A_page=PageFactory.initElements(driver,Authentication_page.class);


    @When("^I click Sign in Link on Home Page$")
    public void iClickSignInLinkOnHomePage() {
        H_page.clickSigninlink_Homepage();
    }

    @Given("^I enter valid Email as \"([^\"]*)\"$")
    public void iEnterValidEmailAs(String email) {
        A_page.EnterValidEmail(email);
    }

    @When("^I click Create an account Button$")
    public void iClickCreateAnAccountButton() throws InterruptedException {
        A_page.ClickAccountButton();
        Thread.sleep(3000);
    }

    @Given("^I enter Title as \"([^\"]*)\"$")
    public void iEnterTitleAs(String signin_Title) {
        S_page.EnterTitle(signin_Title);
    }

    @And("^I enter First Name as \"([^\"]*)\"$")
    public void iEnterFirstNameAs(String signin_FirstName) {
        S_page.EnterFirstName(signin_FirstName);
    }

    @And("^I enter Last Name as \"([^\"]*)\"$")
    public void iEnterLastNameAs(String signin_LastName) {
        S_page.EnterLastName(signin_LastName);
    }

    @And("^I enter email as \"([^\"]*)\"$")
    public void iEnterEmailAs(String signin_Email) {
        S_page.EnterEmail(signin_Email);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String signin_Passwd) {
        S_page.EnterPassword(signin_Passwd);
    }


    @And("^I enter DOB day as \"([^\"]*)\"$")
    public void iEnterDOBDayAs(String signin_Days) {
        S_page.EnterDOBDay(signin_Days);
    }

    @And("^I enter DOB month as \"([^\"]*)\"$")
    public void iEnterDOBMonthAs(String signin_Month) {
       S_page.EnterDOBMonth(signin_Month);
    }


    @And("^I enter DOB year as \"([^\"]*)\"$")
    public void iEnterDOBYearAs(String signin_Year) {
      S_page.EnterDOBYear(signin_Year);

    }

    @And("^I click sign up for newsletter$")
    public void iClickSignUpForNewsletter() {
       S_page.SignUpForNewsletter();
    }

    @And("^I click I receive special offers from our partners$")
    public void iClickIReceiveSpecialOffersFromOurPartners() {
        S_page.ReceiveSpecialOffersFromOurPartners();
    }

    @And("^I enter Company as \"([^\"]*)\"$")
    public void iEnterCompanyAs(String signin_Company) {
        S_page.EnterCompany(signin_Company);
    }

    @And("^I enter address as \"([^\"]*)\"$")
    public void iEnterAddressAs(String signin_Address1)  {
        S_page.EnterAddress(signin_Address1);

    }

    @And("^I enter adresss line Two as \"([^\"]*)\"$")
    public void iEnterAdresssLineTwoAs(String signin_Address2) {
        S_page.EnterAdresssLineTwo(signin_Address2);
    }

    @And("^I enter city as \"([^\"]*)\"$")
    public void iEnterCityAs(String signin_City) {
        S_page.EnterCity(signin_City);
    }


    @And("^I selected State as \"([^\"]*)\"$")
    public void iSelectedStateAs(String signin_State)  {
        S_page.SelectedState(signin_State);
    }

    @And("^I enter Zip/Postal code as \"([^\"]*)\"$")
    public void iEnterZipPostalCodeAs(String signin_Postcode)  {
        S_page.EnterZipPostalCode(signin_Postcode);
    }

    @And("^I selected Country as \"([^\"]*)\"$")
    public void iSelectedCountryAs(String signin_Country)  {
        S_page.SelectedCountry(signin_Country);
    }

    @And("^I enter Additional information as \"([^\"]*)\"$")
    public void iEnterAdditionalInformationAs(String signin_AddInfo)  {
      S_page.EnterAdditionalInformation(signin_AddInfo);
    }

    @And("^I enter Home phone as \"([^\"]*)\"$")
    public void iEnterHomePhoneAs(String signin_Homephone)  {
       S_page.EnterHomePhone(signin_Homephone);
    }

    @And("^I enter Mobile phone as \"([^\"]*)\"$")
    public void iEnterMobilePhoneAs(String signin_Mobilephone)  {
        S_page.EnterMobilePhone(signin_Mobilephone);
    }

    @And("^I enter Assign an address alias for future reference \"([^\"]*)\"$")
    public void iEnterAssignAnAddressAliasForFutureReference(String signin_Alias)  {
        S_page.EnterAssignAnAddressAliasForFutureReference(signin_Alias);
    }

    @When("^I click Register Button$")
    public void iClickRegisterButton() {
        S_page.ClickRegisterButton();

    }

    @Then("^I should see error message as \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageAs(String Expectederror) throws InterruptedException {
        S_page.ErrorMessage(Expectederror);
    }

    @Then("^I should see account creation url as \"([^\"]*)\"$")
    public void iShouldSeeAccountCreationUrlAs(String ExpectedURL) throws InterruptedException {
        S_page.AccountCreationUrl(ExpectedURL);
    }


    @Then("^I should see my account page as \"([^\"]*)\"$")
    public void iShouldSeeMyAccountPageAs(String Expected_URL) throws InterruptedException {
        S_page.AccountPageUrl(Expected_URL);
    }


    @Given("^I enter invalid Email as \"([^\"]*)\"$")
    public void iEnterInvalidEmailAs(String invalidEmail){
        A_page.InvalidEmail(invalidEmail);

    }

    @Given("^I enter Existing Email as \"([^\"]*)\"$")
    public void iEnterExistingEmailAs(String ExistingEmail)  {
        A_page.EnterExistingEmail(ExistingEmail);
    }


    @Then("^I should see signin page first error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageFirstErrorMessageAs(String ErrorMsg1)  {
        S_page.SigninPageErrorMessage(ErrorMsg1);
    }

    @And("^I should see signin page Second error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageSecondErrorMessageAs(String ErrorMsg2)  {
        S_page.SigninPageSecondErrorMessage(ErrorMsg2);
    }

    @And("^I should see signin page Sec error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageSecErrorMessageAs(String ErrorMes2)  {

    }

    @Then("^I should see signin page Third error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageThirdErrorMessageAs(String ErrorMsg3)  {

    }


    @And("^I should see signin page fourth error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageFourthErrorMessageAs(String ErrorMsg4)  {

    }

    @Then("^I should see signin page fifth error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageFifthErrorMessageAs(String ErrorMsg5)  {

    }

    @And("^I should see signin page sixth error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageSixthErrorMessageAs(String ErrorMsg6)  {

    }

    @Then("^I should see signin page Seventh error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageSeventhErrorMessageAs(String ErrorMsg7)  {

    }

    @And("^I should see signin page Eighth error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageEighthErrorMessageAs(String ErrorMsg8)  {

    }

    @And("^I should see signin page nighth error message as \"([^\"]*)\"$")
    public void iShouldSeeSigninPageNighthErrorMessageAs(String ErrorMsg9) {

    }


}

   /* id=
   customer_firstname
   customer_lastname
   email
   passwd
   days
   months
   years
   newsletter
   optin
   firstname
   lastname
   company
   address1
   address2
   city
   id_state
   postcode
   id_country
   other
   phone
   phone_mobile
   alias
   submitAccount
    */


