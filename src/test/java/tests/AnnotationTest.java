package tests;

import org.testng.annotations.*;

public class AnnotationTest {
    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before method");
    }

    @Test
    void test() {
        System.out.println("Test");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After method");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    void afterClass() {
        System.out.println("After class");
    }

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After suite");
    }
}
