package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Manager;
import com.example.malumukendi.assignment6services.Repos.ManagerRepo;
import com.example.malumukendi.assignment6services.Service.TotalManagerGadgetService;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class TotalManagerGadgetServiceImpl extends Manager implements TotalManagerGadgetService {

    public ManagerRepo manager;
    private final IBinder localBinder = new ActivateServiceLocalBinder();

    public TotalManagerGadgetServiceImpl(){
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public TotalManagerGadgetServiceImpl getService() {
            return TotalManagerGadgetServiceImpl.this;
        }
    }
    @Override
    public double totalCost(Manager manager) {
        return manager.getScreen().getPrice() + manager.getLaptop().getPrice();

    }
}
