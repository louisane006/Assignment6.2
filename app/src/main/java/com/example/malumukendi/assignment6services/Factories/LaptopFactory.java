package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Laptop;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopFactory {
    public static Laptop l(String n, String c, double p){
        return new Laptop.Builder()
                .name(n)
                .code(c)
                .price(p)
                .build();
    }
}
