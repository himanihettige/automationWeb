package com.stepdefinitions;

import com.pages.Home_page;
import com.pages.contactUsDT_page;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class contactUsDT_SD extends DriverClass{

    public Home_page H_page= PageFactory.initElements(driver,Home_page.class);
    public contactUsDT_page Cdt_page= PageFactory.initElements(driver,contactUsDT_page.class);

    @When("^I click contact us Link on Home Page$")
    public void iClickContactUsLinkOnHomePage() {
        H_page.ContactUsLink_HomePage();
    }


    @Then("^I should see below details:$")
    public void iShouldSeeBelowDetails(DataTable Table1) {

        Cdt_page.SubjectHeading(Table1.getGherkinRows().get(1).getCells().get(0));
        Cdt_page.EmailAddress(Table1.getGherkinRows().get(1).getCells().get(1));
        Cdt_page.OrderReference(Table1.getGherkinRows().get(1).getCells().get(2));
        Cdt_page.Message(Table1.getGherkinRows().get(1).getCells().get(3));


    }

    @Given("^I choose a File$")
    public void iChooseAFile() {
        Cdt_page.ChooseAFile();
    }


    @When("^I click Send Button$")
    public void iClickSendButton() {
        Cdt_page.SendButton();
    }

    @Then("^I should see url \"([^\"]*)\"$")
    public void iShouldSeeUrl(String controller_url) throws InterruptedException {
       Cdt_page.SeeUrl(controller_url);
    }

    @Then("^I should see message \"([^\"]*)\"$")
    public void iShouldSeeMessage(String message) {
        Cdt_page.SeeMessage(message);

    }

    @Then("^I should see err_msg \"([^\"]*)\"$")
    public void iShouldSeeErr_msg(String err_msg)  {
        Cdt_page.Err_msg(err_msg);
    }

    @Then("^I should see errormessage as \"([^\"]*)\"$")
    public void iShouldSeeErrormessageAs(String Error_message)  {
        Cdt_page.Err_message(Error_message);
    }

//    @Then("^I should see errormessage as:$")
//    public void iShouldSeeErrormessageAs(DataTable Table2) {
//        if (Table2.getGherkinRows().equals(0)) {
//            Cdt_page.Err_message(Table2.getGherkinRows().get(0).getCells().get(0));
//        }
//        else if (Table2.getGherkinRows().equals(1)) {
//            Cdt_page.Err_message(Table2.getGherkinRows().get(1).getCells().get(0));
//        }
//        else if (Table2.getGherkinRows().equals(2)) {
//            Cdt_page.Err_message(Table2.getGherkinRows().get(2).getCells().get(0));
//        }
//        else if (Table2.getGherkinRows().equals(3)) {
//            Cdt_page.Err_message(Table2.getGherkinRows().get(3).getCells().get(0));
//        }


 //   }

//    @Then("^I should see:$")
//    public void iShouldSee(DataTable DTable1) {
//       Cdt_page.Err_message(DTable1.getGherkinRows().get(1).getCells().get(0));
//       Cdt_page.Err_msg(DTable1.getGherkinRows().get(1).getCells().get(1));
//    }

//    @Then("^I should see err_message \"([^\"]*)\"$")
//    public void iShouldSeeErr_message(String err_message)  {
//        Cdt_page.Err_message(err_message);
//
//    }



//    @And("^I should see err_msg \"([^\"]*)\"$")
//    public void iShouldSeeErr_msg(String err_msg) {
//        Cdt_page.Err_msg(err_msg);
//    }


}
