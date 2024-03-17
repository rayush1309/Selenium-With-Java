package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDropDown {
    WebDriver driver = null;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        // Remove implicit wait, use WebDriverWait for specific elements
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void closeBrowser() {
        // Close the browser or perform any cleanup if needed
        driver.quit();
    }

    @Test
    public void selectDob() {
        // Wait for the "Create new account" button to be clickable
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='u_0_2_tP']/child::div/a[@id='u_0_0_xd']")));
        createAccountButton.click();

        // Rest of your test logic...
        WebElement monthName = driver.findElement(By.name("birthday_day"));
        Select select = new Select(monthName);
        select.selectByIndex(5);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
