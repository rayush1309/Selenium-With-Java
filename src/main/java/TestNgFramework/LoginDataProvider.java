package TestNgFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProvider {

    @Test(dataProvider = "userIdAndPwd")
    public void loginTest(String userName,String password, boolean isLoginExpected
    ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("j_username")).sendKeys(userName);
        driver.findElement(By.id("j_password")).sendKeys(password);
        WebElement submit = driver.findElement(By.name("Submit"));
        submit.click();

        Thread.sleep(10000);
        if (isLoginExpected) {
            // Get the 'alt' attribute value from the 'img' element
            String name = driver.findElement(By.xpath("//div/a/img[@id='jenkins-name-icon']")).getAttribute("alt");
            System.out.println("text is: " + name);
        }else {
            String errorMessage = driver.findElement(By.cssSelector(".app-sign-in-register__error")).getText();
            System.out.println("text is: " + errorMessage);
        }
        driver.quit();


    }
    @Test
    public void InavlidloginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("j_username")).sendKeys("ayush-raj");
        driver.findElement(By.id("j_password")).sendKeys("Ateyeyu");
        WebElement submit = driver.findElement(By.name("Submit"));
        submit.click();
        Thread.sleep(10000);
        // Get the 'alt' attribute value from the 'img' element
        String errorMessage= driver.findElement(By.cssSelector(".app-sign-in-register__error")).getText();
        System.out.println("text is: " + errorMessage);
    }
    @DataProvider(name = "userIdAndPwd")
    public Object[][] userIdAndPasswordData(){
        return new Object[][]{
                {"ayush-raj", "Ateyeyu",false},
                {"ay-raj", "A@1sh",false},
                {"ay-raj", "A@1h",false},
                {"ayush-raj","Atedt",false}
            };


    }
}
