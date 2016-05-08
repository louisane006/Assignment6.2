package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerFactory {
    public static Customer cust(String num, String name, String surname){
        return new Customer.Builder()
                .custNum(num)
                .name(name)
                .surname(surname)
                .build();
    }
}
