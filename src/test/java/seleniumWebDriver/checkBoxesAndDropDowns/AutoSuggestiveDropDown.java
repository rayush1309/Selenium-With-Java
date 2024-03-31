package seleniumWebDriver.checkBoxesAndDropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropDown  {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
        Thread.sleep(3000);
        List<WebElement> suggestedOptions= driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
        System.out.println(suggestedOptions.size());
        for (WebElement option:suggestedOptions){
            String textValue=option.getText();
           // System.out.println(textValue);
            if (textValue.equals("selenium tutorial")){
                option.click();
                break;
            }
        }





    }
}
