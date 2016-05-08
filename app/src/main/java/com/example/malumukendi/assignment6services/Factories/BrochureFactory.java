package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrochureFactory {
    public static Brochure brochure(Customer cust, String d, String n, double p, Designer des) {
        return new Brochure.Builder()
                .designer(des)
                .desc(d)
                .customer(cust)
                .price(p)
                .build();

    }
}