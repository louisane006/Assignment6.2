package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.BrandRepo;
import com.example.malumukendi.assignment6services.Service.TotalBrandByDesignerService;

import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class TotalBrandByDesignerServiceImpl extends Brand implements TotalBrandByDesignerService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private BrandRepo repo;
    Customer cust;
    Designer des;

    public TotalBrandByDesignerServiceImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public TotalBrandByDesignerServiceImpl getService() {
            return TotalBrandByDesignerServiceImpl.this;
        }
    }
    public int count = 0;

    @Override
    public int getBrand(Designer designer) {
        Set<Brand> brand = repo.findAll();

        for (Brand b : brand) {
            if (b.getDesigner() == designer) {
                count++;
            }
        }
        return count;
    }
}