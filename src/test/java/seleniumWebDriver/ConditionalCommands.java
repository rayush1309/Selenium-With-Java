package seleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
        //----> Logo Element-----<
       // WebElement logo = driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']"));
        //System.out.println(logo.isDisplayed());
        boolean status =driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']")).isDisplayed();
        System.out.println(status);
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        //isDisplayed();
        boolean displayStatus= searchBox.isDisplayed();
        //isEnabled();
        boolean searchBoxEnabledStatus= searchBox.isEnabled();
        System.out.println("Display Status: "+displayStatus);
        System.out.println("Enabled status: "+ searchBoxEnabledStatus);

        //isSelected
       WebElement male_radioBtn= driver.findElement(By.xpath("//input[@id='gender-male']"));
       WebElement female_radioBtn= driver.findElement(By.xpath("//input[@id='gender-female']"));

       //Before Selection Status of the radio Btn
        System.out.println("Before Selection+ :"+ male_radioBtn.isSelected());//false
        System.out.println("Before selection:"+ female_radioBtn.isSelected());//false

        //After selection of Male Radio Button
        System.out.println("After selection of Male Radio Button ");
        male_radioBtn.click();
        System.out.println("After :"+ male_radioBtn.isSelected());//true
        System.out.println("After: :"+ female_radioBtn.isSelected());//false
        //After selection of FeMale Radio Button
        female_radioBtn.click();
        System.out.println( male_radioBtn.isSelected());//false
        System.out.println("After selection female:"+ female_radioBtn.isSelected());//true











    }
}
