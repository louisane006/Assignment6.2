package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Ipad;
import com.example.malumukendi.assignment6services.Repos.Impl.IpadRepoImpl;
import com.example.malumukendi.assignment6services.Repos.IpadRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class IpadRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        IpadRepo repo = new IpadRepoImpl(this.getContext());
        // CREATE
        Ipad createEntity = new Ipad.Builder()
                .name("IpadeI600")
                .code("BK500")
                .costPrice(95000)
                .build();
        Ipad insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Ipad> ipdad = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",ipdad.size()>0);

        //READ ENTITY
        Ipad entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Ipad updateEntity = new Ipad.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        Ipad newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","BK500",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(entity);
        Ipad deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
