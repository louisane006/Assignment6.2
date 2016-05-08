package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Ipad;
import com.example.malumukendi.assignment6services.Service.HighestIPadPriceService;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.HighestIPadPriceServiceImpl;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class HighestIPadServiceTest extends AndroidTestCase {
    public HighestIPadPriceService ipad;
    public HighestIPadServiceTest(){}
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), HighestIPadPriceServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HighestIPadPriceServiceImpl.ActivateServiceLocalBinder binder
                    = (HighestIPadPriceServiceImpl.ActivateServiceLocalBinder) service;
            ipad = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public void highestBrochureServiceTest() {
        Ipad i1 = new Ipad.Builder().code("BK500").costPrice(6000.88).build();
        Ipad i2 = new Ipad.Builder().code("MK200").costPrice(4000.00).build();
        Ipad i3 = new Ipad.Builder().code("KM300").costPrice(3000.90).build();

        List<Ipad> ip = new ArrayList<Ipad>();
        ip.add(i1);
        ip.add(i2);
        ip.add(i3);
        Assert.assertEquals(ipad.highestCost(ip), i1);
    }
}
