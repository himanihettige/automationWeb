package com.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import java.io.IOException;

public class hooks {

    DriverClass driverCls = new DriverClass();

    @Before
    public void browser() throws IOException {
        driverCls.openBrowser();

    }





    @After
    public void close()  {
       //driverCls.closeBrowser();

    }

}
