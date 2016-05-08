package com.example.malumukendi.assignment6services.Factories;

import com.example.malumukendi.assignment6services.Domain.Cashier;
import com.example.malumukendi.assignment6services.Domain.Invoice;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class InvoiceFactory {
    public static Invoice inv( int n, Cashier c) {
        return new Invoice.Builder()
                .invoiceNum(n)
                .cashier(c)
                .build();

    }
}
