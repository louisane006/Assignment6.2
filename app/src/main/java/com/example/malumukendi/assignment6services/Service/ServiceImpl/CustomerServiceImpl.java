package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Repos.CustomerRepo;
import com.example.malumukendi.assignment6services.Service.CustomerService;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class CustomerServiceImpl extends Customer implements CustomerService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    private CustomerRepo repo;


    public CustomerServiceImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }
    public class ActivateServiceLocalBinder extends Binder {
        public CustomerServiceImpl getService() {
            return CustomerServiceImpl.this;
        }
    }
    @Override
    public double getCust(Customer customer) {
        return 0.0;
    }
}
