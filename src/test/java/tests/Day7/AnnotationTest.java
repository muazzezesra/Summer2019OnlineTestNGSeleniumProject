package tests.Day7;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class!");
    }


    @BeforeMethod
    public void setup(){
        // some code that will be running before  every test. like: test1, test2, test3..
        //we can use method with @BeforeMethod annotation
        System.out.println("Before Method!");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After Method!");
    }


    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }

    @Test
    public void test2(){
        System.out.println("Test 2!");
    }

    @Test
    public void test3(){
        System.out.println("Test 3!");
    }
}
