package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        int countIframe=driver.findElements(By.tagName("iframe")).size();
        System.out.println(countIframe);
        //iframe using index
        driver.switchTo().frame(0);//it will move to 1st frame index start from:0
        //iframe(WebElement
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        //driver.findElement(By.id("draggable")).click();
        //for drag and drop action : we need to use action class and .dragAnddrop method
        Actions a=new Actions(driver);
        //in dragAndDrop argument we need to pass source and target web Element
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        // if we done with this work if we want to perform any action outside of this frame WebDriver will not switch Automatically
        // we have to ask WebDriver to come default content
        //syntax:
        driver.switchTo().defaultContent(); // it will comes to the normal window.
    }
}
