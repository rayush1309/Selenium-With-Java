/*

package com.carwale.com;

import com.carwale.pages.HomePage;
import com.carwale.pages.NewCarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindNewCarTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Configure Chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        // Pass Chrome options to ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        // Initialize the class variable
        driver.get("https://www.carwale.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void findCarTest() {
        HomePage homePage = new HomePage(driver);
        homePage.findNewCar();
    }

    @Test
    public void verifyCarPage() {
        NewCarPage newCarPage = new NewCarPage(driver);
        newCarPage.goToBMW();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 */
