package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Manager;
import com.example.malumukendi.assignment6services.Factories.ManagerFactory;
import com.example.malumukendi.assignment6services.Service.ManagerService;

import org.junit.Assert;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class ManagerServiceTest extends AndroidTestCase {
    private Long id;

    private ManagerService service;
    public void create() throws Exception {

        Manager manager = ManagerFactory.man("Eric", "Smith", "M200");
        service.save(manager);
        id = manager.getId();
        Assert.assertNotNull(manager);

    }
    public void read() throws Exception {
        Manager manager = service.findById(id);
        Assert.assertEquals("Smith", manager.getSurname());
    }
    public void update() throws Exception {
        Manager manager = service.findById(id);
        Manager newMan = new Manager
                .Builder()
                .copy(manager)
                .surname("Eddy").build();

        service.update(newMan);
        Manager updatedMan = service.findById(id);
        Assert.assertEquals("Eddy", updatedMan.getSurname());

    }
    public void delete() throws Exception {
        Manager manager = service.findById(id);
        service.delete(manager);
        Manager deleteMan = service.findById(id);
        Assert.assertNull(deleteMan);
    }

}
