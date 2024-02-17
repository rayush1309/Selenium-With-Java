package testNG;
import org.testng.annotations.*;

public class NewTest {
    @Test
    public void f() {
        System.out.println("Raj");

    }

    @BeforeMethod
    public void BM() {
        System.out.println("I will excecute before every @test method in this New test Class");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Jay Shree Ram");
    }

    @Test
    public void afterTest() {
        System.out.println("Alexa'");

    }

    @AfterTest
    public void finish() {
        System.out.println("finished");
    }

    @BeforeSuite
    public void firstExecution() {
        System.out.println("I am no. 1 from first");

    }

    @AfterMethod
    public void AM() {
        System.out.println("I will excecute after every @test method in this New test Class");


    }
}
