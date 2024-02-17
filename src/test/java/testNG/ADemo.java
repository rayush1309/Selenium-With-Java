package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ADemo {
    @AfterSuite
    public void lastExecution() {
        System.out.println("I am the 1 from last");
    }

    @Test
    public void demo() {
        System.out.println("hello");
    }
    @Test
    public void demo2() {
        System.out.println("Hello2");

    }
    @Test(dataProvider="getData")
    public void MultipleDataCombination(String userName, String Password) {
        System.out.println("Validating mutiple comibantion with diffrent userName and password");
        System.out.println(userName);
        System.out.println(Password);
    }
    @DataProvider
    public Object[][] getData() {
        // 1st combination ; username and Password , with good credit History
        // 2nd: userName , pwd, no credit history
        // fraudlent credit History
        // so for this defined a multi dimensionalm Array
        //it means each row : How Many Combinations and coloumn:  we have values and each coloumn .

        Object [][] data = new Object [3][2];
        // 1st data set:
        data[0][0] = "firstSetUsername";
        data[0][1] = "Password1";
        // coloumn is nothing but val;ues for that particular combination(rows}'
        // 2nd set
        data [1][0] ="2nd Set User name";
        data [1][1] = " 2nd Password";
        // 3rd set
        data [2][0] ="3rd Set UserName";
        data [2][1] = "Password3";
        return data;


    }

}
