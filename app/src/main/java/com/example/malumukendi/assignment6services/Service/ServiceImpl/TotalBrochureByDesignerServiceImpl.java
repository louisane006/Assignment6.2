package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.BrochureRepo;
import com.example.malumukendi.assignment6services.Service.TotalBrochureByDesignerService;

import java.util.Set;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class TotalBrochureByDesignerServiceImpl extends Brochure implements TotalBrochureByDesignerService {
    public int count = 0;
    public BrochureRepo repo;
    private final IBinder localBinder = new ActivateServiceLocalBinder();

    public TotalBrochureByDesignerServiceImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public TotalBrochureByDesignerServiceImpl getService() {
            return TotalBrochureByDesignerServiceImpl.this;
        }
    }
    @Override
    public int getBrochure(Designer designer) {
        Set<Brochure> brochure = repo.findAll();

        for (Brochure b : brochure) {
            if (b.getDesigner() == designer) {
                count++;
            }
        }
        return count;
    }
}
