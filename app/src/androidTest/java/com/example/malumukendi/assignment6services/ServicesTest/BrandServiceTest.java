package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Factories.BrandFactory;
import com.example.malumukendi.assignment6services.Service.BrandService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class BrandServiceTest extends AndroidTestCase {
    private Long id;

    private BrandService service;
    Customer cust;
    Designer des;
    public void create() throws Exception {

        Brand brand = BrandFactory.brand(cust, "0100BC", 450.00, des);
        service.save(brand);
        id = brand.getId();
        Assert.assertNotNull(brand);

    }
    public void read() throws Exception {
        Brand brand = service.findById(id);
        Assert.assertEquals("0100BC", brand.getDescription());
    }
    public void update() throws Exception {
        Brand brand = service.findById(id);
        Brand newBrand = new Brand
                .Builder()
                .copy(brand)
                .description("0100BP").build();

        service.update(newBrand);
        Brand updatedBrand = service.findById(id);
        Assert.assertEquals("Caren", updatedBrand.getDescription());

    }
    public void delete() throws Exception {
        Brand brand = service.findById(id);
        service.delete(brand);
        Brand deletebrand = service.findById(id);
        Assert.assertNull(deletebrand);
    }

}
