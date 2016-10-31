package com.example.malumukendi.assignment6services.ServicesTest;

import android.test.AndroidTestCase;

import com.example.malumukendi.assignment6services.Domain.Parts;
import com.example.malumukendi.assignment6services.Domain.Shop;
import com.example.malumukendi.assignment6services.Factories.ShopFactory;
import com.example.malumukendi.assignment6services.Service.ShopService;

import org.junit.Assert;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-08.
 */
public class ShopServiceTest extends AndroidTestCase {

    private Long id;

    private ShopService service;
    List<Parts> part;
    public void create() throws Exception {

        Shop shop = ShopFactory.shop(250.00, "Plumstead", part);
        service.save(shop);
        id = shop.getIdentification();
        Assert.assertNotNull(shop);

    }
    public void read() throws Exception {
        Shop shop = service.findById(id);
        Assert.assertEquals("Plumstead", shop.getAddress());
    }
    public void update() throws Exception {
        Shop shop = service.findById(id);
        Shop newshop = new Shop
                .Builder()
                .copy(shop)
                .address("Maitland").build();

        service.update(newshop);
        Shop updatedShop = service.findById(id);
        Assert.assertEquals("Maitland", updatedShop.getAddress());

    }
    public void delete() throws Exception {
        Shop shop = service.findById(id);
        service.delete(shop);
        Shop deleteshop = service.findById(id);
        Assert.assertNull(deleteshop);
    }
}
