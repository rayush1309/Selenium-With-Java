package TestNgFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class GoogleTest {
    WebDriver driver;

    //1st//4//7
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }
//2nd
    @Test(priority = 1,groups = "regression")
    public void googleTitletest(){
        String title= driver.getTitle();
        System.out.println(title);

    }
    @Test(priority = 2,groups = "sanity")
    public void googleLogoTest(){
        Boolean b= driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();

    }
    @Test(priority = 3,groups = "smoke")
    public void mailLinkTest(){
        Boolean b= driver.findElement(By.linkText("Mail")).isDisplayed();

    }
    //3rd//6/9
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
