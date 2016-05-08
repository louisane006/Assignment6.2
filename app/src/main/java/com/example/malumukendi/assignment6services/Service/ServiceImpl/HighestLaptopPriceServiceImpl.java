package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Laptop;
import com.example.malumukendi.assignment6services.Repos.LaptopRepo;
import com.example.malumukendi.assignment6services.Service.HighestLaptopPriceService;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class HighestLaptopPriceServiceImpl implements HighestLaptopPriceService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private LaptopRepo repo;


    public HighestLaptopPriceServiceImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public HighestLaptopPriceServiceImpl getService() {
            return HighestLaptopPriceServiceImpl.this;
        }
    }
    public int count;

    @Override
    public Laptop highestCost(List<Laptop> work) {
        double highest = work.get(0).getPrice();

        for (int x = 1; x < work.size(); x++) {
            if (work.get(x).getPrice() < highest) {
                highest = work.get(x).getPrice();
                count = x;
            }
        }
        return work.get(count);
    }
}
