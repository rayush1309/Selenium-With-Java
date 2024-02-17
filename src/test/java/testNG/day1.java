package testNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class day1 {
        @Test
        public void webLogin() {
            System.out.println("Web Login Test");

        }
        @Test(groups= {"smoke"})
        public void MobileLogin() {
            System.out.println("Mobile Login Test");

        }
        @Parameters({"URL", "Key"})
        @Test
        public void APILogin(String urlName, String keyName) {
            System.out.println("API Login Test");
            System.out.println(urlName);
            System.out.println(keyName);


        }
        @Test(groups= {"smoke"})
        public void MobileSingnIn() {
            System.out.println("Mobile SingIN sucessfully done");

        }

        @Test
        public void WebLogin() {
            System.out.println(" Web LogiN sucessfully done");

        }
        @Test(groups= {"smoke"})
        public void WebBrowser() {
            System.out.println(" Web browser sucessfully started");

        }

    }
