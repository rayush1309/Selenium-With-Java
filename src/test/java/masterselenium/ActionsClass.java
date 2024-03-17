package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        //to move to particular element
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //moves to specific Element
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        //How we can double click: or entire string need to select: ie; double click.
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        //How we can double click: or entire string need to select: ie; double click.
        a.doubleClick().build().perform();
        //using contextClick : we can right click on the specific Element
        a.moveToElement(move).contextClick().build().perform();
        // we will learn drag and drop in frames.
    }

}
