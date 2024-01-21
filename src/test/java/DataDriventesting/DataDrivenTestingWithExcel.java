/*
package DataDriventesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestingWithExcel {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("/Users/aushraj/Documents/TestDataSelenium.xlsx");

        // Load the Excel file from the FileInputStream
        XSSFWorkbook wb = new XSSFWorkbook(fis);

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

                while(rows.hasNext()){
                   Row r= rows.next();
                   if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")){
                       //after you grab Purchase row _= pull all the data of that row
                     Iterator<Cell> cv =r.cellIterator();
                     while (cv.hasNext()){
                        String cellValue= cv.next().getStringCellValue();
                         System.out.println(cellValue);
                     }
                   }
                }
            }
        }

        // Close the FileInputStream and workbook when done
        fis.close();
        wb.close();
    }
}
*/
