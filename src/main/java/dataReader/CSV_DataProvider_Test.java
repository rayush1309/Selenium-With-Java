package dataReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSV_DataProvider_Test {

    @Test
    public void readDataFromCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("resources/login.csv"));
        List<String[]> data = csvReader.readAll();
        for (String[] row : data) {
            for (String s:row) {
                System.out.println(s);
            }

        }

    }
}