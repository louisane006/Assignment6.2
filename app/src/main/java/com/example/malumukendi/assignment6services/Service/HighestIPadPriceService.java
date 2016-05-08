package com.example.malumukendi.assignment6services.Service;

import android.content.Intent;
import android.os.IBinder;

import com.example.malumukendi.assignment6services.Domain.Ipad;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public interface HighestIPadPriceService {
    IBinder onBind(Intent intent);

    Ipad highestCost(List<Ipad> work);
}
