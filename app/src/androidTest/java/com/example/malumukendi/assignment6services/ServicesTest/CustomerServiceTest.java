package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Service.CustomerService;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.CustomerServiceImpl;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class CustomerServiceTest extends AndroidTestCase{

    private CustomerServiceImpl activateService ;
    private boolean isBound;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), CustomerServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CustomerServiceImpl.ActivateServiceLocalBinder binder
                    = (CustomerServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public CustomerService t;

    public CustomerServiceTest() {
    }
    @Test
    public void totalCustomerTest(){

        Customer cust = new Customer.Builder().custNum("44500").name("Sarah").surname("Smith").build();

        Assert.assertEquals(t.getCust(cust), "44500");

    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
