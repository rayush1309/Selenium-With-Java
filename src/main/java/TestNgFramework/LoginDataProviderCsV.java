package TestNgFramework;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginDataProviderCsV {

    @Test

    public void readDataFromCsv() throws IOException, CsvException {
    CSVReader csvReader= new CSVReader(new FileReader("resources/login.csv"));
    List<String[]>data= csvReader.readAll();
    for (String[] row:data){
        System.out.println(Arrays.toString(row));


    }






    }

}
