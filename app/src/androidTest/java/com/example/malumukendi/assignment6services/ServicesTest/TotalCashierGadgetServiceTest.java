package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Cashier;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.TotalCashierGadgetServiceImpl;
import com.example.malumukendi.assignment6services.Service.TotalCashierGadgetService;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class TotalCashierGadgetServiceTest extends AndroidTestCase{
    public TotalCashierGadgetService t;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), TotalCashierGadgetServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TotalCashierGadgetServiceImpl.ActivateServiceLocalBinder binder
                    = (TotalCashierGadgetServiceImpl.ActivateServiceLocalBinder) service;
            t = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public TotalCashierGadgetServiceTest() {
    }
    @Test
    public void totalGagets(){

        Customer cust = new Customer.Builder().custNum("44500").name("Sarah").build();
        Cashier cashier = new Cashier.Builder("12433").customer(cust).build();

        Assert.assertEquals(t.totalCost(cashier), "44500");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
