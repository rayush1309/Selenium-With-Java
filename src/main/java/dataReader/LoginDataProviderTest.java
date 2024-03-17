package dataReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginDataProviderTest {

    @Test(dataProvider = "user-Ids-csv-passwords-csv-data-provider")
    public void loginTest(String userName, String password, boolean isLoginExpected) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost:8080/login");
            driver.manage().window().maximize();
            driver.findElement(By.id("j_username")).sendKeys(userName);
            driver.findElement(By.id("j_password")).sendKeys(password);
            WebElement submit = driver.findElement(By.name("Submit"));
            submit.click();

            // Replace Thread.sleep with WebDriverWait or other explicit waits

            if (isLoginExpected) {
                String name = driver.findElement(By.xpath("//div/a/img[@id='jenkins-name-icon']")).getAttribute("alt");
                System.out.println("text is: " + name);
            } else {
                String errorMessage = driver.findElement(By.cssSelector(".app-sign-in-register__error")).getText();
                System.out.println("text is: " + errorMessage);
            }
        } finally {
            // Ensure that the WebDriver is closed
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void testReadingDataFromCSV() throws IOException, CsvException {
        CSVReader reader = readFromCSVFile("resources/login.csv");
        List<String[]> data = reader.readAll();
        for (String[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }

    private CSVReader readFromCSVFile(String csvFilePath) {
        try {
            return new CSVReader(new FileReader(csvFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading CSV file: " + csvFilePath, e);
        }
    }

    @DataProvider(name = "user-Ids-csv-passwords-csv-data-provider")
    public Object[][] userIdAndPasswordData() throws IOException, CsvException {
        List<String[]> userData = readFromCSVFile("resources/login.csv").readAll();
        Object[][] dataArray = new Object[userData.size()][3];

        for (int i = 0; i < userData.size(); i++) {
            dataArray[i] = new Object[]{userData.get(i)[0], userData.get(i)[1], Boolean.parseBoolean(userData.get(i)[2])};
        }

        return dataArray;
    }
}
