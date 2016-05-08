package com.example.malumukendi.assignment6services.FactoriesTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.malumukendi.assignment6services.Domain.Laptop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopFactoryTest {
    Laptop laptop;
    Laptop newLaptop;

    public LaptopFactoryTest() {
    }
    @Test
    public void createTest(){
        laptop = new Laptop.Builder().id((long) 2010000).name("Lenovo").code("44500").price(4500.00).build();
        Assert.assertEquals(laptop.getCode() , "44500");
    }
    @Test
    public void updateTest() {
        newLaptop = new Laptop.Builder().code("5500").build();
        Assert.assertEquals(newLaptop.getCode(), "5500");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
