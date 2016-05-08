package com.example.malumukendi.assignment6services.RepoTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.VideoCamera;
import com.example.malumukendi.assignment6services.Repos.Impl.VideoCameraRepoImpl;
import com.example.malumukendi.assignment6services.Repos.VideoCameraRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class VideoCameraRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        VideoCameraRepo repo = new VideoCameraRepoImpl(this.getContext());
        // CREATE
        VideoCamera createEntity = new VideoCamera.Builder()
                .name("Accer")
                .code("MK400")
                .costPrice(5000)
                .build();
        VideoCamera insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<VideoCamera> video = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",video.size()>0);

        //READ ENTITY
        VideoCamera entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        VideoCamera updateEntity = new VideoCamera.Builder()
                .code("BD44500")
                .build();
        repo.update(updateEntity);
        VideoCamera newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","MK400",newEntity.getCode());

        // DELETE ENTITY
        repo.delete(entity);
        VideoCamera deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
