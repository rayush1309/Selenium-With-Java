package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class Listeners implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {
            // Your logic for handling test start event

        }

        @Override
        public void onTestSuccess(ITestResult result) {
            // Your logic for handling test success event

            System.out.println("I successfully executed Listener Pass test Cases");

        }

        @Override
        public void onTestFailure(ITestResult result) {

            // Your logic for handling test failure event
            //screenSHot code
            //response API if false
            System.out.println("I Fail Failed Failed Aagain Failed**************** will execute when test will fail");

        }
        @Override
        public void onTestSkipped(ITestResult result) {
            // Your logic for handling test skipped event
        }

        @Override
        public void onFinish(ITestContext context) {
            // Your logic for handling test suite finish event
        }


        // Implement other unimplemented methods if needed

    }



