package com.stepdefinitions;


import com.util.services;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;

public class apiGetLocation_SD extends services {
    Response response;

    @When("^I trigger Get Request with \"([^\"]*)\" headers city \"([^\"]*)\"$")
    public void iTriggerGetRequestWithHeadersCity(String headers, String city)  {

        response=getService(city,headers);


        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeaders());
    }


    @Then("^I should see Response code as (\\d+)$")
    public void iShouldSeeResponseCodeAs(int responseCode) {
        Assert.assertEquals(responseCode,response.getStatusCode());
    }


    @Then("^i should see Response code as \"([^\"]*)\"$")
    public void iShouldSeeResponseCodeAs(String responseMsg) {
        System.out.println(response.getStatusLine());
        Assert.assertTrue(response.getStatusLine().contains(responseMsg));
    }


    @Then("^I should see Response body as \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iShouldSeeResponseBodyAsIs(String attribute, String expectedvalue)  {

        String acutalvalue=com.jayway.jsonpath.JsonPath.read(response.getBody().asString(),attribute);
        System.out.println("Response body String actual:" + acutalvalue);
        Assert.assertEquals(expectedvalue,acutalvalue);

    }

    @Then("^I should get Response body as \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iShouldGetResponseBodyAsIs(String attribute, String expectedvalue)  {
        Double acutalvalue=com.jayway.jsonpath.JsonPath.read(response.getBody().asString(),attribute);
        System.out.println("Response body Double actual:" + acutalvalue);
        Assert.assertEquals(expectedvalue,acutalvalue.toString());

    }

    @When("^I trigger post request with \"([^\"]*)\" as postbody$")
    public void iTriggerPostRequestWithAsPostbody(String JSONFile) throws IOException, ParseException {

        response=postService(JSONFile);

    }


    @Then("^I should see Response body like \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iShouldSeeResponseBodyLikeIs(String attribute, String expectedvalue) throws Throwable {
        String acutalvalue=com.jayway.jsonpath.JsonPath.read(response.getBody().asString(),attribute);
        System.out.println("Response body actual:" + acutalvalue);
        Assert.assertEquals(expectedvalue,acutalvalue);

    }
}
