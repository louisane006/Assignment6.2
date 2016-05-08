package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Cashier;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CashierFactory {
        public static Cashier cashier( String n, String snm, String t){
                return new Cashier.Builder()
                        .name(n)
                        .surname(snm)
                        .taskNum(t)
                        .build();
        }
}