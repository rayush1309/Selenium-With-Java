package seleniumWebDriver.checkBoxesAndDropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropDownWithoutSelectTag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        //clicking on the DropDown
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
        List<WebElement>optionsDropDowns=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        //Find total Number of Optiosns
        System.out.println("Total Number of Options: "+optionsDropDowns.size());

        for (WebElement option:optionsDropDowns){
            //System.out.println(option.getText());
            String dropDownName=option.getText();
            if (dropDownName.equals("Java")||dropDownName.equals("Python")){
                option.click();
            }
        }




    }
}
