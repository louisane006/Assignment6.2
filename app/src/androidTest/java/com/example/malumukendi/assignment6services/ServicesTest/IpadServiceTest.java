package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Ipad;
import com.example.malumukendi.assignment6services.Factories.IpadFactory;
import com.example.malumukendi.assignment6services.Service.IPadService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class IPadServiceTest extends AndroidTestCase {
    private Long id;

    private IPadService service;
    public void create() throws Exception {

        Ipad ipad = IpadFactory.i("Samsung","SAM200", 2500.00);
        service.save(ipad);
        id = ipad.getIdentification();
        Assert.assertNotNull(ipad);

    }
    public void read() throws Exception {
        Ipad ipad = service.findById(id);
        Assert.assertEquals("SAM200", ipad.getCode());
    }
    public void update() throws Exception {
        Ipad ipad = service.findById(id);
        Ipad newIpad = new Ipad
                .Builder()
                .copy(ipad)
                .code("Samsung200").build();

        service.update(newIpad);
        Ipad updatedIpad = service.findById(id);
        Assert.assertEquals("Caren", updatedIpad.getCode());

    }
    public void delete() throws Exception {
        Ipad ipad = service.findById(id);
        service.delete(ipad);
        Ipad deleteIpad = service.findById(id);
        Assert.assertNull(deleteIpad);
    }

}
