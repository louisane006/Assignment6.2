package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Parts;
import com.example.malumukendi.assignment6services.Domain.Shop;

import java.util.List;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopFactory {
    public static Shop shop(double n, String a, List<Parts> part){
        return new Shop.Builder()
                .size(n)
                .address(a)
                .part(part)
                .build();
    }
}
