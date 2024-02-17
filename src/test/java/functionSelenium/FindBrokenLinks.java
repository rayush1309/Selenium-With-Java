package functionSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindBrokenLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://edition.cnn.com/");
        driver.manage().window().maximize();

        GetLinkStatusCode linkStatusCodeChecker = new GetLinkStatusCode();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of Links: " + links.size());

        for (WebElement link : links) {
            String URL = link.getAttribute("href");
            linkStatusCodeChecker.verifyLink(URL);
            // System.out.println("link.getText() = " + link.getText());
        }

        System.out.println("Total Number of Broken Links: ");
        linkStatusCodeChecker.getInvalidLinkCount();

        driver.quit();
    }
}
