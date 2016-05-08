package com.example.malumukendi.assignment6services.ServicesTest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.BrandRepo;
import com.example.malumukendi.assignment6services.Service.ServiceImpl.TotalBrandByDesignerServiceImpl;
import com.example.malumukendi.assignment6services.Service.TotalBrandByDesignerService;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class TotalBrandByDesignerServiceTest extends AndroidTestCase{
    public static Designer designer1;
    public static Designer designer2;
    public BrandRepo repo;
    public TotalBrandByDesignerService totalBrandByDesigner;

    private boolean isBound;
    Designer des;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getContext(), TotalBrandByDesignerServiceImpl.class);
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TotalBrandByDesignerServiceImpl.ActivateServiceLocalBinder binder
                    = (TotalBrandByDesignerServiceImpl.ActivateServiceLocalBinder) service;
            totalBrandByDesigner = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    public TotalBrandByDesignerServiceTest() {
    }

    @Test
    public void testing(){

        Brand b1 = new Brand.Builder().description("pick 'n Pay logo").designer(designer1).build();
        Brand b2 = new Brand.Builder().description("Exact logo").designer(designer2).build();
        Brand b3 = new Brand.Builder().description("Markham lgo").designer(designer1).build();

        repo.save(b1);
        repo.save(b2);
        repo.save(b3);

        Assert.assertEquals(totalBrandByDesigner.getBrand(designer1), 2);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        designer1 = new Designer.Builder("211").name("Emily").surname("Smith").build();
        designer2 = new Designer.Builder("127").name("Caren").surname("Mayer").build();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
