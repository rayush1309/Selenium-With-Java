package TestNgFramework;

import org.testng.annotations.Test;

public class InvocationCountDataDriven {

    @Test(invocationCount = 3)
    public void testAddition() {
        for (int i = 1; i <= 3; i++) {
            // Test data
            int operand1 = (int) (Math.random() * 1000);  // Random number between 0 and 100
            int operand2 = (int) (Math.random() * 100);

            // Perform the addition operation
            int result = addNumbers(operand1, operand2);

            // Print the result for each iteration
            System.out.println("Iteration #" + i + ": " + operand1 + " + " + operand2 + " = " + result);
        }
    }

    private int addNumbers(int a, int b) {
        return a + b;
    }
}
