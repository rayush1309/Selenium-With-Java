package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class OpenLinkInSeperateTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //1. Count links in the Page
        // For links, we have anchor tags: <a>
        int countLinkinPage = driver.findElements(By.tagName("a")).size();
        System.out.println(countLinkinPage);
        //2. Get the count of links present in the footer section
        // Limit the WebDriver scope to the footer section
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        int footerlinkCounts = footerdriver.findElements(By.tagName("a")).size();
        System.out.println(footerlinkCounts);
        //3. Count links in the footer section's first column
        WebElement coloumndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstcoloumnlinkcounts = coloumndriver.findElements(By.tagName("a")).size();
        System.out.println(firstcoloumnlinkcounts);

        //4. Click on each link in the column and check if the pages are opening.
        List<WebElement> links = coloumndriver.findElements(By.tagName("a"));
        for (int i = 0; i < firstcoloumnlinkcounts; i++) {
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            WebElement link = links.get(i);
            link.sendKeys(clickonlinkTab);
            Thread.sleep(20000);

            // Switch to the new tab
            String currentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Perform actions in the new tab, if needed
            // ...

            // Close the new tab and switch back to the main tab
            driver.close();
            driver.switchTo().window(currentWindowHandle);

            // Re-locate the elements in the column to avoid StaleElementReferenceException
            coloumndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
            links = coloumndriver.findElements(By.tagName("a"));

        }


    }

}
