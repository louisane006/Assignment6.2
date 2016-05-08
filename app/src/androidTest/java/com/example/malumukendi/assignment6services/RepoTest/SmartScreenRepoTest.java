package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.SmartScreen;
import com.example.malumukendi.assignment6services.Repos.Impl.SmartScreenRepoImpl;
import com.example.malumukendi.assignment6services.Repos.SmartScreenRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class SmartScreenRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SmartScreenRepo repo = new SmartScreenRepoImpl(this.getContext());
        // CREATE
        SmartScreen createEntity = new SmartScreen.Builder()
                .name("Samsung")
                .code("BK500")
                .costPrice(5000.00)
                .build();
        SmartScreen insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<SmartScreen> screen = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",screen.size()>0);

        //READ ENTITY
        SmartScreen entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        SmartScreen updateEntity = new SmartScreen.Builder()
                .name("Accer")
                .build();
        repo.update(updateEntity);
        SmartScreen newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","BK500",newEntity.getName());

        // DELETE ENTITY
        repo.delete(entity);
        SmartScreen deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
