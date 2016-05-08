package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Repos.BrochureRepo;
import com.example.malumukendi.assignment6services.Service.HighestBrochurePriceService;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class HighestBrochurePriceServiceImpl extends Brochure implements HighestBrochurePriceService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private BrochureRepo repo;


    public HighestBrochurePriceServiceImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public HighestBrochurePriceServiceImpl getService() {
            return HighestBrochurePriceServiceImpl.this;
        }
    }
    public int count;

    @Override
    public Brochure highestCost(List<Brochure> work) {
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