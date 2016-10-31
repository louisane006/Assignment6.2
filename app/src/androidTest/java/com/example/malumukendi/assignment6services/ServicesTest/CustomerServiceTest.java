package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Factories.CustomerFactory;
import com.example.malumukendi.assignment6services.Service.CustomerService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class CustomerServiceTest extends AndroidTestCase{

    private Long id;

    private CustomerService service;

    public void create() throws Exception {

        Customer customer = CustomerFactory.cust("20", "Louise", "Malu");
        service.save(customer);
        id = customer.getIdentification();
        Assert.assertNotNull(customer);

    }
    public void read() throws Exception {
        Customer customer = service.findById(id);
        Assert.assertEquals("20", customer.getCustNum());
    }
    public void update() throws Exception {
        Customer customer = service.findById(id);
        Customer newCust = new Customer
                .Builder()
                .copy(customer)
                .name("Louise").build();

        service.update(newCust);
        Customer updatedcust = service.findById(id);
        Assert.assertEquals("Caren", updatedcust.getName());

    }
    public void delete() throws Exception {
        Customer customer = service.findById(id);
        service.delete(customer);
        Customer deletecust = service.findById(id);
        Assert.assertNull(deletecust);
    }
}
