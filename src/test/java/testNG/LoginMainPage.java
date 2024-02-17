package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginMainPage {
    @Test
    public void webLogin() {
        System.out.println("Web Login Test");
        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods= {"webLogin"})
    public void MobileLogin() {
        System.out.println("Mobile Login Test");

    }
    @Test
    public void webAPILogin() {
        System.out.println("API Login Test");


    }

}
