package com.parabank.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
        public static Object[][] getSheetData(String sheetName) {
            Object[][] data = null;
            // Use a relative path to your "test data" folder
            String path = System.getProperty("user.dir") + "/src/test/resources/testdata/ParabankTestData.xlsx";


            try (FileInputStream fis = new FileInputStream(path);
                 Workbook workbook = WorkbookFactory.create(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                int rows = sheet.getLastRowNum();
                int cols = sheet.getRow(0).getLastCellNum();
                data = new Object[rows][cols];

                for (int i = 0; i < rows; i++) {
                    Row row = sheet.getRow(i + 1); // Skip header row
                    for (int j = 0; j < cols; j++) {
                        data[i][j] = row.getCell(j).toString();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }

