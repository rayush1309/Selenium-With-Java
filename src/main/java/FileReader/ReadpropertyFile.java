package FileReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {
    static  WebDriver driver;
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        Properties prop = new Properties();
        FileInputStream fs= new FileInputStream("resources/properties/Configtest.properties");
        prop.load(fs);

        //Read the properties: using .getproperty
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));
        String browserName= prop.getProperty("browser");
        System.out.println("URL = " + prop.getProperty("URL"));
        System.out.println("BrowserName = " + browserName);
        String url=prop.getProperty("URL");
        if (browserName.equals("chrome")){
            driver= new ChromeDriver(); //launch the chrome

        }
        driver.get(url);







    }
}
