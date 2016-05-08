package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.HighestBrandPriceServiceImpl;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-06.
 */

public class HighestBrandServiceTest  extends AndroidTestCase {
    private HighestBrandPriceServiceImpl activateService ;

    private boolean isBound;
    Customer cust;
    Designer des;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), HighestBrandPriceServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HighestBrandPriceServiceImpl.ActivateServiceLocalBinder binder
                    = (HighestBrandPriceServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public void highestBrandTest()  throws Exception {
        Brand b1 = new Brand.Builder().description("logo").price(350.00).build();
        Brand b2 = new Brand.Builder().description("logo 2").price(400.00).build();
        Brand b3 = new Brand.Builder().description("logo 3").price(800.00).build();
        List<Brand> b = new ArrayList<>();
        b.add(b1);
        b.add(b2);
        b.add(b3);
        Assert.assertEquals(activateService.highestCost(b), b3);
    }
}
