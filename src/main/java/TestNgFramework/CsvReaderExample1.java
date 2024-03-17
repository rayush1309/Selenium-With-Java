package TestNgFramework;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderExample1 {

    public static Object[][] readDataFromCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("resources/login.csv"));
        List<String[]> data = csvReader.readAll();

        List<Object[]> dataList = new ArrayList<>();

        for (String[] row : data) {
            // Assuming the structure is Name, Password, boolean
            String name = row[0];
            String password = row[1];
            boolean booleanValue = Boolean.parseBoolean(row[2]);


            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
            System.out.println("Boolean: " + booleanValue);

            // Creating an array with the extracted data and add it to the list
            Object[] rowData = {name, password, booleanValue};
            dataList.add(rowData);
        }

        // Convering the list to a 2D array and return
        return dataList.toArray(new Object[0][0]);
    }

    public static void main(String[] args) {
        try {
            // Call the method and retrieve the data
            Object[][] csvData = readDataFromCsv();

            // You can use the csvData as needed in your test or elsewhere
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
