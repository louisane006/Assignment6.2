package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Laptop;
import com.example.malumukendi.assignment6services.Service.HighestLaptopPriceService;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.HighestLaptopPriceServiceImpl;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class HighestLaptopServiceTest extends AndroidTestCase {
    private HighestLaptopPriceServiceImpl activateService ;
    private boolean isBound;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), HighestLaptopPriceServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HighestLaptopPriceServiceImpl.ActivateServiceLocalBinder binder
                    = (HighestLaptopPriceServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public HighestLaptopPriceService laptop;
    public HighestLaptopServiceTest(){}

    public void highestLaptopServiceTest() {
        Laptop l1 = new Laptop.Builder().code("BK500").price(6000.88).build();
        Laptop l2 = new Laptop.Builder().code("MK200").price(7000.00).build();
        Laptop l3 = new Laptop.Builder().code("KM300").price(8000.90).build();

        List<Laptop> lt = new ArrayList<>();
        lt.add(l1);
        lt.add(l2);
        lt.add(l3);

        Assert.assertEquals(laptop.highestCost(lt), l3);
    }
}
