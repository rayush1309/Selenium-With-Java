package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlings {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();//[parentwindow id, child Window id]
				/*getWindowHandles(); This method  gives us all window ID in the set data Str.which open by our automationn
				   and return type of this method is set of String.
				 * now our goal is to pull that id's from set data structure.
				 * for that: we can do using method called:  windows.iterator();
				 * this method extract id present in our set data str.
				 * usint It.next(); control will go to the 0th index and we have to do it .next() if we want to access 1st index. */

        Iterator<String> It = windows.iterator();
        String parentId = It.next();
        String childId = It.next();
        driver.switchTo().window(childId);// we have to pass string ID of the window which we want to switch
        // to extract the Text from the child window
        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());

        driver.quit();


    }
}