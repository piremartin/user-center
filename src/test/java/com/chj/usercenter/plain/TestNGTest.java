package com.chj.usercenter.plain;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTest {

    @BeforeClass
    public void testBeforeClass(){
        System.out.println("testng---before class");
    }

    @Test
    public void test1(){
        System.out.println("testng---test1");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testException(){
        int i = 1/0;
    }


    @Test(enabled = false)
    public void testIgnore(){
        System.out.println("testng - do nothing");
    }

    //testng
    @Test(timeOut = 1000)
    public void testTimeout(){
        while (true);
    }


}
