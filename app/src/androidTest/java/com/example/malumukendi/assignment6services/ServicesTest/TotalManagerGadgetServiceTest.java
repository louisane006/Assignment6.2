package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Manager;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.TotalManagerGadgetServiceImpl;
import com.example.malumukendi.assignment6services.Service.TotalManagerGadgetService;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class TotalManagerGadgetServiceTest extends AndroidTestCase {
    public TotalManagerGadgetService t;
    private boolean isBound;
    public TotalManagerGadgetServiceTest() {
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), TotalManagerGadgetServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TotalManagerGadgetServiceImpl.ActivateServiceLocalBinder binder
                    = (TotalManagerGadgetServiceImpl.ActivateServiceLocalBinder) service;
            t = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };


    @Test
    public void totalGagets(){

        Customer cust = new Customer.Builder().custNum("44500").name("Sarah").build();
        Manager manager = new Manager.Builder("12433").customer(cust).build();

        Assert.assertEquals(t.totalCost(manager), "44500");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

}
