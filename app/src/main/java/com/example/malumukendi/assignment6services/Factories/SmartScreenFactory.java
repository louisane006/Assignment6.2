package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.SmartScreen;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenFactory {
    public static SmartScreen s(String n, String c, double p){
        return new SmartScreen.Builder()
                .name(n)
                .code(c)
                .costPrice(p)
                .build();
    }
}
