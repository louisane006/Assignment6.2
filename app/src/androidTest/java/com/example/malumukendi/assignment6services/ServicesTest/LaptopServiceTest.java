package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Laptop;
import com.example.malumukendi.assignment6services.Factories.LaptopFactory;
import com.example.malumukendi.assignment6services.Service.LaptopService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class LaptopServiceTest extends AndroidTestCase {
    private Long id;

    private LaptopService service;
    public void create() throws Exception {

        Laptop laptop = LaptopFactory.l("Accer", "BC2010", 5000.00);
        service.save(laptop);
        id = laptop.getId();
        Assert.assertNotNull(laptop);

    }
    public void read() throws Exception {
        Laptop laptop = service.findById(id);
        Assert.assertEquals(5000.00, laptop.getPrice());
    }
    public void update() throws Exception {
        Laptop laptop = service.findById(id);
        Laptop newLaptop = new Laptop
                .Builder()
                .copy(laptop)
                .price(6000.00).build();

        service.update(newLaptop);
        Laptop updatedLaptop = service.findById(id);
        Assert.assertEquals(6000.00, updatedLaptop.getPrice());

    }
    public void delete() throws Exception {
        Laptop laptop = service.findById(id);
        service.delete(laptop);
        Laptop deleteLaptop = service.findById(id);
        Assert.assertNull(deleteLaptop);
    }

}
