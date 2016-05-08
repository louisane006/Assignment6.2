package com.example.malumukendi.assignment6services.FactoriesTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.malumukendi.assignment6services.Domain.Ipad;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class IpadFactoryTest {
    Ipad ipad;
    Ipad newIpad;

    public IpadFactoryTest() {
    }
    @Test
    public void createTest(){
        ipad = new Ipad.Builder().id((long) 10201200).name("IPAD2").code("10001B").costPrice(10000).build();
        Assert.assertEquals(ipad.getName() , "IPAD2");
    }
    @Test
    public void updateTest() {
        newIpad = new Ipad.Builder().name("IPAD4s").build();
        Assert.assertEquals(newIpad.getName(), "IPAD4s");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
