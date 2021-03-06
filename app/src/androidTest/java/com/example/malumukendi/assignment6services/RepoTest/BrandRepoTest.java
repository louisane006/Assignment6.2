package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Repos.BrandRepo;
import com.example.malumukendi.assignment6services.Repos.Impl.BrandRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrandRepoTest extends AndroidTestCase {
    private static final String TAG = "Brand TEST";
    private Long id;
    private BrandRepo repo;

    public void testCreateReadUpdateDelete() throws Exception {
        BrandRepo repo = new BrandRepoImpl(this.getContext());
        // CREATE
        Brand createEntity = new Brand.Builder()
                .description("BK700")
                .price(800.00)
                .build();
        Brand insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Brand> brand = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", brand.size() > 0);

        //READ ENTITY
        Brand entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //UPDATE ENTITY
        Brand updateEntity = new Brand.Builder()
                .price(1000.00)
                .build();
        repo.update(updateEntity);
        Brand newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", 800.00, newEntity.getPrice());

        // DELETE ENTITY
        repo.delete(entity);
        Brand deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}

