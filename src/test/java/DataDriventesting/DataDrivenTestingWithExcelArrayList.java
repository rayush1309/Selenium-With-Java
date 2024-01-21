/*
package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestingWithExcelArrayList {
    public static void main(String[] args) throws IOException {
        DataDrivenTestingWithExcelArrayList dataDrivenTesting = new DataDrivenTestingWithExcelArrayList();
        // dataDrivenTesting.getData();
    }

    public ArrayList<String> getData(String TestCaseName) throws IOException {
        ArrayList<String> arr = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("/Users/aushraj/Documents/TestDataSelenium.xlsx");
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {

            int sheets = wb.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
                if (wb.getSheetName(i).equalsIgnoreCase("sheet1")) {
                    XSSFSheet sheet = wb.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                    Row firstRow = rows.next();
                    Iterator<Cell> ce = firstRow.cellIterator();
                    int k = 0;
                    int column = 0;

                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                            column = k;
                            break; // Exit the loop once you've found the column
                        }
                        k++;
                    }
                    System.out.println(column);

                    while (rows.hasNext()) {
                        Row r = rows.next();
                        if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
                            // After you grab the Purchase row, pull all the data of that row
                            Iterator<Cell> cv = r.cellIterator();
                            while (cv.hasNext()) {
                                arr.add(cv.next().getStringCellValue());
                            }
                        }

                    }
                }
            }
        }
        return arr;
    }
}
*/
