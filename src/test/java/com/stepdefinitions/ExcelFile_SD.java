package com.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelFile_SD {
    @Given("^I am reading excel file \"([^\"]*)\"$")
    public void iAmReadingExcelFile(String ExcelFileName) throws IOException {
        String path = System.getProperty("user.dir");
        String testDataFileName = path + "/src/test/java/com/TestData/" + ExcelFileName;
        Workbook workbook= WorkbookFactory.create(new File(testDataFileName));
        Sheet sheet=workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();
        ArrayList<String> emailid = new ArrayList<String>();
        for (Row row : sheet) {
            //  System.out.println(new CellValue(String.valueOf(cell)));
            for (Cell cell : row)
                if (row.getRowNum() == 0) {

                } else {
                    if (cell.getColumnIndex() == 1) {
                        String cellValue=dataFormatter.formatCellValue(cell);
                        emailid.add(cellValue);

                        System.out.println(cellValue);
                    }
                }
        }


    }
}
