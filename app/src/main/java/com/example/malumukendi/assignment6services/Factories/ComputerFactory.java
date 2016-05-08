package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Computer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ComputerFactory {

    public static Computer comp(String n, String c, double p){
        return new Computer.Builder()
                .code(c)
                .name(n)
                .price(p)
                .build();
    }
}
