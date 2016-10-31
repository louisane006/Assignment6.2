package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Cashier;
import com.example.malumukendi.assignment6services.Factories.CashierFactory;
import com.example.malumukendi.assignment6services.Service.CashierService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class CashierServiceTest extends AndroidTestCase {
    private Long id;

    private CashierService service;
    public void create() throws Exception {

        Cashier cashier = CashierFactory.cashier("Louise", "Malu", "0012B");
        service.save(cashier);
        id = cashier.getIdentification();
        Assert.assertNotNull(cashier);

    }
    public void read() throws Exception {
        Cashier cashier = service.findById(id);
        Assert.assertEquals("Louise", cashier.getName());
    }
    public void update() throws Exception {
        Cashier cashier = service.findById(id);
        Cashier newcashier = new Cashier
                .Builder()
                .copy(cashier)
                .name("Erin").build();

        service.update(newcashier);
        Cashier updatedCashier = service.findById(id);
        Assert.assertEquals("Caren", updatedCashier.getName());

    }
    public void delete() throws Exception {
        Cashier cashier = service.findById(id);
        service.delete(cashier);
        Cashier deleteCashier = service.findById(id);
        Assert.assertNull(deleteCashier);
    }

}

