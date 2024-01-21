package com.testNg;

import org.testng.annotations.*;

public class TestNGDemo {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Chrome - Setup System Property");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Open Chrome");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Open Test Application");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Sign In");
    }

    @Test
    public void searchCustomer() {
        System.out.println("Search for a Customer");
    }

    @Test
    public void searchProduct() {
        System.out.println("Search for a Product");
    }

    @AfterMethod
    public void signOut() {
        System.out.println("Sign Out");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Close Test Application");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Close Chrome");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Chrome - Clean up all system cookies");
    }
}
