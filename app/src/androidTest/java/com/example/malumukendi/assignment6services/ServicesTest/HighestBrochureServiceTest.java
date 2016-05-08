package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Service.HighestBrochurePriceService;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.HighestBrochurePriceServiceImpl;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class HighestBrochureServiceTest extends AndroidTestCase {
    public HighestBrochurePriceService brosch;
    private boolean isBound;
    public HighestBrochureServiceTest(){}
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), HighestBrochurePriceServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HighestBrochurePriceServiceImpl.ActivateServiceLocalBinder binder
                    = (HighestBrochurePriceServiceImpl.ActivateServiceLocalBinder) service;
            brosch = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public void highestBrochureServiceTest() {
        Brochure b1 = new Brochure.Builder().desc("Brochure1").price(600.88).build();
        Brochure b2 = new Brochure.Builder().desc("Brochure2").price(300.00).build();
        Brochure b3 = new Brochure.Builder().desc("Brochure3").price(700.90).build();
        List<Brochure> br = new ArrayList<>();
        br.add(b1);
        br.add(b2);
        br.add(b3);
        Assert.assertEquals(brosch.highestCost(br), b3);
    }
}

