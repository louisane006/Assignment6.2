package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Manager;
import com.example.malumukendi.assignment6services.Repos.Impl.ManagerRepoImpl;
import com.example.malumukendi.assignment6services.Repos.ManagerRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ManagerRepoTest extends AndroidTestCase {
    private static final String TAG = "SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ManagerRepo repo = new ManagerRepoImpl(this.getContext());
        // CREATE
        Manager createEntity = new Manager.Builder()
                .name("Carin")
                .surname("Kirk")
                .taskNum("500")
                .build();
        Manager insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Manager> manager = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", manager.size() > 0);

        //READ ENTITY
        Manager entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Manager updateEntity = new Manager.Builder()
                .name("photos")
                .build();
        repo.update(updateEntity);
        Manager newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Kirk", newEntity.getSurname());

        // DELETE ENTITY
        repo.delete(entity);
        Manager deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}

