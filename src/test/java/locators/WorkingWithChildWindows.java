package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WorkingWithChildWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();//[parentwindow id, child Window id]
        Iterator<String>It= windows.iterator();
        String parentId=It.next();
        String childId=It.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
        driver.findElement(By.cssSelector("p.im-para.red")).getText();
        String emailID= driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailID);

    }
}
