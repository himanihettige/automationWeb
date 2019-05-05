package com.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class dvlaExcel_SD extends DriverClass {

    WebDriverWait webDriverWait=new WebDriverWait(driver,60);

    ArrayList<String> RegistrationNo = new ArrayList<String>();
    ArrayList<String> model = new ArrayList<String>();
    ArrayList<String> colour = new ArrayList<String>();

    @And("^I should reading excel file Reg no as \"([^\"]*)\"$")
    public void iShouldReadingExcelFileRegNoAs(String RegNo) {

        String actualText = driver.findElement(By.xpath("/html/body/main/form/div/div/ul/li[1]/span[2]")).getText();
        Assert.assertEquals(RegNo, actualText);


    }

    @Given("^I am reading excel file DVLA \"([^\"]*)\"$")
    public void iAmReadingExcelFileDVLA(String ExcelFileName) throws IOException {

        String path = System.getProperty("user.dir");

        String testDataFileName = path + "/src/test/java/com/TestData/" + ExcelFileName;

        Workbook workbook = WorkbookFactory.create(new File(testDataFileName));

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        RegistrationNo = new ArrayList<String>();
        model = new ArrayList<String>();
        colour = new ArrayList<String>();

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
                    if (cell.getColumnIndex() == 1) {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        model.add(cellValue);
                        System.out.println(cellValue);
                    }
                    if (cell.getColumnIndex() == 2) {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        colour.add(cellValue);
                        System.out.println(cellValue);
                    }

                }
        }


    }

    @Then("^I verify vehicle infomation as Registration no,model and colour$")
    public void iVerifyVehicleInfomationAsRegistrationNoModelAndColour() throws InterruptedException {

        //click get started button
        driver.findElement(By.xpath("//*[@id=\"get-started\"]/a")).click();

        for (int i =0; i<RegistrationNo.size(); i++) {


                    driver.getCurrentUrl();
                    driver.get("https://vehicleenquiry.service.gov.uk/");
                    String Actualurl = driver.getCurrentUrl();
                    System.out.println(Actualurl);
                    String Expectedurl = "https://vehicleenquiry.service.gov.uk/";
                    Assert.assertEquals(Expectedurl, Actualurl);

                    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Vrm\"]")));

                    //enter Registration number
                    driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).sendKeys(RegistrationNo.get(i));

                    //click continue button
                    driver.findElement(By.name("Continue")).click();


                    //information page url
                    driver.getCurrentUrl();

                    //driver.get("https://vehicleenquiry.service.gov.uk/ConfirmVehicle");
                    String Actualurl1 = driver.getCurrentUrl();
                    String Expectedurl1 = "https://vehicleenquiry.service.gov.uk/ConfirmVehicle";
                    System.out.println("Actural url" + Actualurl1);
                    System.out.println("expected url" + Expectedurl1);
                    Assert.assertEquals(Expectedurl1, Actualurl1);


                    System.out.println("expected reg no is " + RegistrationNo.get(i));
                    System.out.println("expected model is " + model.get(i));
                    System.out.println("expected color is " + colour.get(i));


                    // check Registration number with actual Regno
                    String actualRegNo = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[1]/span[2]")).getText();
                    System.out.println("actual reg no is " + actualRegNo);
                    Assert.assertEquals(RegistrationNo.get(i), actualRegNo);


                    //check model with actual model
                    String actualmodel = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[2]/span[2]/strong")).getText();
                    System.out.println("actual reg no is " + actualRegNo);
                    Assert.assertEquals(model.get(i), actualmodel);

                    //check colour with actual colour
                    String actualcolor = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
                    Assert.assertEquals(colour.get(i), actualcolor);


                    // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Correct_False")));
                    driver.findElement(By.id("Correct_False")).click();


                    //continue button in info page
                    driver.findElement(By.name("Continue")).click();


        }
    }
}

