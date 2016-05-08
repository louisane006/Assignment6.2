package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class DesignerFactory {
    public static Designer des(String n, String snm, String t){
        return new Designer.Builder()
                .name(n)
                .surname(snm)
                .taskNumber(t)
                .build();
    }
}
