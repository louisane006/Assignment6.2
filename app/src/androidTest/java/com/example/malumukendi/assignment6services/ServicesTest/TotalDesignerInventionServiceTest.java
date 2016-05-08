package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.TotalDesignerInventionServiceImpl;
import com.example.malumukendi.assignment6services.Service.TotalDesignerInventionService;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class TotalDesignerInventionServiceTest extends AndroidTestCase{

    public TotalDesignerInventionService t;
    private boolean isBound;
    public TotalDesignerInventionServiceTest() {
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), TotalDesignerInventionServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TotalDesignerInventionServiceImpl.ActivateServiceLocalBinder binder
                    = (TotalDesignerInventionServiceImpl.ActivateServiceLocalBinder) service;
            t = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    @Test
    public void totals(){

        Brochure b = new Brochure.Builder().price(35000.00).build();
        Brand f = new Brand.Builder().price(7000.00).build();

        Designer design  = new Designer.Builder("55").name("Louise").brochure(b).brand(f).build();

        Assert.assertEquals(t.totalCost(design), 42000.00);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
