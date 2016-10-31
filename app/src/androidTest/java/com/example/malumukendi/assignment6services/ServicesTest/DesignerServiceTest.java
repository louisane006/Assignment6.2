package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Factories.DesignerFactory;
import com.example.malumukendi.assignment6services.Service.DesignerService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class DesignerServiceTest extends AndroidTestCase {

    private Long id;

    private DesignerService service;
    public void create() throws Exception {

        Designer designer = DesignerFactory.des("Louise", "Malu", "AC500");
        service.save(designer);
        id = designer.getIdentification();
        Assert.assertNotNull(designer);

    }
    public void read() throws Exception {
        Designer designer = service.findById(id);
        Assert.assertEquals("Louise", designer.getName());
    }
    public void update() throws Exception {
        Designer designer = service.findById(id);
        Designer newDes = new Designer
                .Builder()
                .copy(designer)
                .name("Louise").build();

        service.update(newDes);
        Designer updatedBro = service.findById(id);
        Assert.assertEquals("Caren", updatedBro.getName());

    }
    public void delete() throws Exception {
        Designer designer = service.findById(id);
        service.delete(designer);
        Designer deletedes = service.findById(id);
        Assert.assertNull(deletedes);
    }
}
