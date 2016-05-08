package com.example.malumukendi.assignment6services.RepoTest;
import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Laptop;
import com.example.malumukendi.assignment6services.Repos.Impl.LaptopRepoImpl;
import com.example.malumukendi.assignment6services.Repos.LaptopRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class LaptopRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        LaptopRepo repo = new LaptopRepoImpl(this.getContext());
        // CREATE
        Laptop createEntity = new Laptop.Builder()
                .name("Lenovo")
                .code("44500")
                .price(500)
                .build();
        Laptop insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Laptop> laptop = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",laptop.size()>0);

        //READ ENTITY
        Laptop entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Laptop updateEntity = new Laptop.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        Laptop newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","44500",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(entity);
        Laptop deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}

