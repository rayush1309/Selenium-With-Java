package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day3 {

    @BeforeClass
    public void BC() {
        System.out.println(" I will execute before executing other method in this Class");

    }

    @AfterClass
    public void AC() {
        System.out.println(" I will execute at the End after executing other method in this Class");

    }

    @Test
    public void MobileSingnUp() {
        System.out.println("Mobile Singup sucessfully done");

    }

    @Test
    public void MobileSingnIn() {
        System.out.println("Mobile SingIN sucessfully done");

    }

    @Test(groups = {"smoke"})
    public void MobileLogin() {
        System.out.println("Moblie LogiN sucessfully done");

    }

    @Test
    public void WebLogin() {
        System.out.println(" Web LogiN sucessfully done");

    }

    @Test
    public void WebBrowser() {
        System.out.println(" Web browser sucessfully started");

    }
}