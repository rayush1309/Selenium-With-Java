package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option:options) {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }

        }
    }
}
