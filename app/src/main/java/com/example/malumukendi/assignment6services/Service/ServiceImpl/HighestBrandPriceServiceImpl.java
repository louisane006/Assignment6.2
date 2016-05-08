package com.example.malumukendi.assignment6services.Service.ServiceImpl;


import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.BrandRepo;
import com.example.malumukendi.assignment6services.Service.HighestBrandPriceService;

import java.util.List;

public class HighestBrandPriceServiceImpl extends Brand implements HighestBrandPriceService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private BrandRepo repo;
    Customer cust;
    Designer des;

    public HighestBrandPriceServiceImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public HighestBrandPriceServiceImpl getService() {
            return HighestBrandPriceServiceImpl.this;
        }
    }
    public int count;
   @Override
    public Brand highestCost(List<Brand> b) {
        double highest = b.get(0).getPrice();

        for(int x = 1; x < b.size(); x++){
            if(b.get(x).getPrice() < highest){
                highest = b.get(x).getPrice();
                count = x;
            }
        }
        return b.get(count);
    }
}
