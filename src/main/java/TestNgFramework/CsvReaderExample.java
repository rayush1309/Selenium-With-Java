package TestNgFramework;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsvReaderExample {

    public static void readDataFromCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("resources/login.csv"));
        List<String[]> data = csvReader.readAll();

        for (String[] row : data) {
            // Assuming the structure is Name, Password, boolean
            String name = row[0];
            String password = row[1];
            boolean booleanValue = Boolean.parseBoolean(row[2]);

            // Now you can use the variables as needed
            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
            System.out.println("Boolean: " + booleanValue);
        }
    }

    public static void main(String[] args) {
        try {
            readDataFromCsv();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
