package com.example.malumukendi.assignment6services.FactoriesTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.malumukendi.assignment6services.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerFactoryTest {

    Customer customer;
    Customer newCustomer;
    @Test
    public void createTest(){
        customer = new Customer.Builder().identification((long) 1020300).name("Sarah").surname("Smith").build();
        Assert.assertEquals(customer.getName(), "Sarah");
    }
    @Test
    public void updateTest() {
        newCustomer = new Customer.Builder().name("Ritah").build();
        Assert.assertEquals(newCustomer.getName(), "Ritah");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
