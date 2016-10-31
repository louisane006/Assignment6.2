package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Factories.BrochureFactory;
import com.example.malumukendi.assignment6services.Service.BrochureService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-06.
 */

public class BrochureServiceTest  extends AndroidTestCase {

    private Long id;

    private BrochureService service;
    Customer cust;
    Designer des;
    public void create() throws Exception {

        Brochure brochure = BrochureFactory.brochure(cust,"Shop Ad",200.00,des);
        service.save(brochure);
        id = brochure.getId();
        Assert.assertNotNull(brochure);

    }
    public void read() throws Exception {
        Brochure brochure = service.findById(id);
        Assert.assertEquals("Shop Ad", brochure.getDescription());
    }
    public void update() throws Exception {
        Brochure brochure = service.findById(id);
        Brochure newDes = new Brochure
                .Builder()
                .copy(brochure)
                .desc("Shop Pub").build();

        service.update(newDes);
        Brochure updatedBro = service.findById(id);
        Assert.assertEquals("Caren", updatedBro.getDescription());

    }
    public void delete() throws Exception {
        Brochure brochure = service.findById(id);
        service.delete(brochure);
        Brochure deletebro = service.findById(id);
        Assert.assertNull(deletebro);
    }
}
