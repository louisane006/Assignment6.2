package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Computer;
import com.example.malumukendi.assignment6services.Repos.ComputerRepo;
import com.example.malumukendi.assignment6services.Repos.Impl.ComputerRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 3/29/2016.
 */
public class ComputerRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ComputerRepo repo = new ComputerRepoImpl(this.getContext());
        // CREATE
        Computer createEntity = new Computer.Builder()
                .name("Accer")
                .code("42350")
                .price(200)
                .build();
        Computer insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Computer> computer = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",computer.size()>0);

        //READ ENTITY
        Computer entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Computer updateEntity = new Computer.Builder()
                .name("HP")
                .build();
        repo.update(updateEntity);
        Computer newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","42350",newEntity.getName());

        // DELETE ENTITY
        repo.delete(entity);
        Computer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
