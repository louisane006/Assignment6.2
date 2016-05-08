package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Credit;
import com.example.malumukendi.assignment6services.Repos.CreditRepo;
import com.example.malumukendi.assignment6services.Repos.Impl.CreditRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CreditRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    long id;
    public void testCreateReadUpdateDelete() throws Exception {
        CreditRepo repo = new CreditRepoImpl(this.getContext());
        // CREATE
        Credit createEntity = new Credit.Builder()
                .name("cash")
                .amount(5000.00)
                .build();
        Credit insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Credit> credit = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",credit.size()>0);

        //READ ENTITY
        Credit entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Credit updateEntity = new Credit.Builder()
                .amount(7000.00)
                .build();
        repo.update(updateEntity);
        Credit newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",5000.00,newEntity.getAmount());

        // DELETE ENTITY
        repo.delete(entity);
        Credit deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
