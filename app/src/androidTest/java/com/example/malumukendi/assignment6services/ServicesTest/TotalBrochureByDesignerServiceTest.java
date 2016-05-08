package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.BrochureRepo;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.TotalBrochureByDesignerServiceImpl;
import com.example.malumukendi.assignment6services.Service.TotalBrochureByDesignerService;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class TotalBrochureByDesignerServiceTest extends AndroidTestCase{
    public static Designer des1;
    public static Designer des2;
    public BrochureRepo repo;
    public TotalBrochureByDesignerService totalBrandingByDesigner;

    private boolean isBound;
    Designer des;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), TotalBrochureByDesignerServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TotalBrochureByDesignerServiceImpl.ActivateServiceLocalBinder binder
                    = (TotalBrochureByDesignerServiceImpl.ActivateServiceLocalBinder) service;
            totalBrandingByDesigner = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public TotalBrochureByDesignerServiceTest() {
    }

    @Test
    public void test1(){


        Brochure b1 = new Brochure.Builder().desc("City ads").designer(des1).build();
        Brochure b2 = new Brochure.Builder().desc("cput ads").designer(des2).build();
        Brochure b3 = new Brochure.Builder().desc("checkers ads").designer(des1).build();

        repo.save(b1);
        repo.save(b2);
        repo.save(b3);

        Assert.assertEquals(totalBrandingByDesigner.getBrochure(des1), 2);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        des1 = new Designer.Builder().name("Louise").surname("Malu").build();
        des2 = new Designer.Builder().name("Sarah").surname("Smith").build();
    }


    @AfterClass
    public static void tearDownClass() throws Exception {
    }

}
