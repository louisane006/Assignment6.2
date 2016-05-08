package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Ipad;
import com.example.malumukendi.assignment6services.Repos.IpadRepo;
import com.example.malumukendi.assignment6services.Service.HighestIPadPriceService;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class HighestIPadPriceServiceImpl extends Ipad implements HighestIPadPriceService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private IpadRepo repo;


    public HighestIPadPriceServiceImpl() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public HighestIPadPriceServiceImpl getService() {
            return HighestIPadPriceServiceImpl.this;
        }
    }
    public int count;

    @Override
    public Ipad highestCost(List<Ipad> work) {
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
