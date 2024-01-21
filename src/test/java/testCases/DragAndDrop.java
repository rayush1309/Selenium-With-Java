package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0); //switch to Frame if it is present
        Actions ac = new Actions(driver);
        WebElement target= driver.findElement(By.xpath("//*[@id='droppable']"));
        ac.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']"))).moveToElement(target).release()
                .build().perform();


    }
}
