package seleniumWebDriver.checkBoxesAndDropDowns;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemoWithSelectTag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        WebElement dropDownPricingElement= driver.findElement(By.xpath("//div[@class='sort']//select"));
        Select pricingDetails= new Select(dropDownPricingElement);
        //1) selecting an Option from the DropDown
       // pricingDetails.selectByVisibleText("Highest to lowest");
        //2) select By Value
      //  pricingDetails.selectByValue("highestprice"); //use This only if Value attribute is present for option Tag
        //3) select By Index
        pricingDetails.selectByIndex(1);







    }
}
