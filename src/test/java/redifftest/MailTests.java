package redifftest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import rediff.LandingPage;
import rediff.LoginPage;
import rediff.RediffMailPage;

public class MailTests {

    @Test
    public void writeMailTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        LandingPage landingPage= new LandingPage();
        landingPage.openBrowser();
        LoginPage loginPage=landingPage.clickSignIn();
        RediffMailPage rediffMailPage =loginPage.doLogin();




    }
}
