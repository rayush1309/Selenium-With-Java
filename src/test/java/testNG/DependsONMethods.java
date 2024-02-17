package testNG;

import org.testng.annotations.Test;

public class DependsONMethods {

    @Test(dependsOnMethods={"Tc3","Tc4"})
    public void Tc1() {
        System.out.println("execute TC1");

    }
    @Test(enabled=false)
    public void Tc2() {
        System.out.println("execute TC2");

    }
    @Test
    public void Tc3() {
        System.out.println("execute TC3");

    }
    @Test
    public void Tc4() {
        System.out.println("execute TC4");

    }
}
