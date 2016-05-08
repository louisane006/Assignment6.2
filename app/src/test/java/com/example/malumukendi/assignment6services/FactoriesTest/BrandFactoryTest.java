package com.example.malumukendi.assignment6services.FactoriesTest;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by louisane Malu on 4/23/2016.
 */
public class BrandFactoryTest {
    Brand frame;
    Brand newFrame;
    Designer designer;
    Customer customer;

    @Test
    public void createTest(){
        frame = new Brand.Builder().designer(designer).description("CI1000").customer(customer).build();
        junit.framework.Assert.assertEquals(frame.getCustomer() , customer);
    }
    @Test
    public void updateTest() {
        newFrame = new Brand.Builder().customer(customer).build();
        junit.framework.Assert.assertEquals(newFrame.getCustomer(), customer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
