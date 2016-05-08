package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrandFactory {
    public static Brand brand(Customer cust, String d, double p, Designer des) {
        return new Brand.Builder()
                .designer(des)
                .description(d)
                .customer(cust)
                .price(p)
                .build();
    }
}