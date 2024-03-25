package seleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebDriverGetAndBrowserMethods {
    public static void main(String[] args) {
        /*
        get(url)
        getTitle()
        getCurrentUrL()
        getPageSource()
        getWindowHandle()
        getWindowHandles()
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println("Title of the page: "+ title);
        String currentURL= driver.getCurrentUrl();
        System.out.println(currentURL);
        String pageSource= driver.getPageSource();
        //System.out.println(pageSource);
        boolean isPresent=pageSource.contains("html");
        System.out.println(isPresent);
        String windowId=driver.getWindowHandle();
        System.out.println(windowId);//9CEE2A07FE37AB8DB84CE7447F28D854
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //open new Browser Window
        driver.getWindowHandles();
        Set<String> windowIDs=driver.getWindowHandles();
        for (String winId:windowIDs) {
            System.out.println("WindowID: "+winId);

        }



    }
}
