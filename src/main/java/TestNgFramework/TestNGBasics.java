package TestNgFramework;

import org.testng.annotations.*;
/*
BeforeSuite:Set Up System Property for Chrome -- 1st
BeforeTest:Launch Chrome Browser  -- 2nd
BeforeClass: Login to App  --3rd
$ 4th(Pair will be created with @Before and @After Method

BeforeMethod: enter Url --4th
Test 3: verify Google Logo test
AfterMethod: Logout from the App


BeforeMethod: enter Url
Test:1 : Google Title Test
AfterMethod: Logout from the App


BeforeMethod: enter Url
test2: Verify Search test
AfterMethod: Logout from the App


AfterClass--close Browser -- 5th
AfterTest: deleteAllCookies -- 6th
AfterSuite--generate Test Report --7th
 */
//Note: Before Method and After method will execute for both the test cases.
//If we we have 2 @Test Annotation then

/*
* @Before Method
* @Test -1
* @After Method
* @Before Method
* @Test-2
* @After Method
*
* @Before Method
 * @Test-3
 * @After Method
 */


public class TestNGBasics {
    //Prerequisite condition-starting with @Before
    @BeforeSuite //1ST
    public void setup(){
        System.out.println("BeforeSuite:Set Up System Property for Chrome");
    }
    @BeforeClass //3rd
    public void login(){
        System.out.println("BeforeClass: Login to App");
    }
    @BeforeTest// 2ND
    public void launchBrowser(){
        System.out.println("BeforeTest:Launch Chrome Browser");
    }
    @BeforeMethod//4
    public void enterUrl(){
        System.out.println("BeforeMethod: enter Url");
    }
    //Test Cases -- starting with @Test
    @Test//5
    public void googleTitleTest(){
        System.out.println("Test:1 : Google Title Test");

    }
    @Test
    public void searchTest(){
        System.out.println("test2: Verify Search test");
    }
    @Test
    public void googleLogoTest(){
        System.out.println("Test 3: verify Google Logo test");
    }
    // Post condition starting--> @After
    @AfterMethod//6
    public void logout(){
        System.out.println("AfterMethod: Logout from the App");
    }
    @AfterTest//8
    public void deleteAllCookies(){
        System.out.println("AfterTest: deleteAllCookies");
    }
    @AfterClass//7
    public void closeBrowser(){
        System.out.println("AfterClass--close Browser");
    }
    @AfterSuite//9
    public void generateReport(){
        System.out.println("AfterSuite--generate Test Report");
    }



}
