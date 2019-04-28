package com.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;




public class dvlaExcel_SD extends DriverClass {
    String setReg;
    @When("^I click start now Button$")
    public void iClickStartNowButton() {
        driver.findElement(By.xpath("//*[@id=\"get-started\"]/a")).click();


    }



    @Given("^I enter register number of the vehicle from reading excel file \"([^\"]*)\"$")
    public void iEnterRegisterNumberOfTheVehicleFromReadingExcelFile(String ExcelFileName) throws IOException {

        String path = System.getProperty("user.dir");

        String testDataFileName = path + "/src/test/java/com/TestData/" + ExcelFileName;
        Workbook workbook = WorkbookFactory.create(new File(testDataFileName));
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();
        ArrayList<String> RegistrationNo = new ArrayList<String>();
        for (Row row : sheet) {
            //  System.out.println(new CellValue(String.valueOf(cell)));
            for (Cell cell : row)
                if (row.getRowNum() == 0) {

                } else {
                    if (cell.getColumnIndex() == 0) {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        RegistrationNo.add(cellValue);
                        System.out.println(cellValue);

                    }
                }
// test comit 2nd time
        }

        driver.findElement(By.id("Vrm")).sendKeys(RegistrationNo.get(0));

    }



    @When("^I click continue button$")
    public void iClickContinueButton() {
        driver.findElement(By.name("Continue")).click();
    }


    @And("^I should reading excel file Reg no as \"([^\"]*)\"$")
    public void iShouldReadingExcelFileRegNoAs(String RegNo)  {

        String actualText=driver.findElement(By.xpath("/html/body/main/form/div/div/ul/li[1]/span[2]")).getText();
        Assert.assertEquals(RegNo,actualText);


    }


    @And("^I click No, search again check button$")
    public void iClickNoSearchAgainCheckButton() {
        driver.findElement(By.id("Correct_False")).click();

    }

    @When("^I click continue$")
    public void iClickContinue() {
        driver.findElement(By.name("Continue")).click();
    }
}

