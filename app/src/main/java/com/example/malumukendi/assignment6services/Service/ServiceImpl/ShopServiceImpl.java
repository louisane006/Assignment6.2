package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Shop;
import com.example.malumukendi.assignment6services.Repos.ShopRepo;
import com.example.malumukendi.assignment6services.Service.ShopService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class ShopServiceImpl extends Shop implements ShopService {

    private ShopRepo repository;

    private ShopServiceImpl(Builder b) {
        super(b);
    }

    @Override
    public Shop findById(Long aLong) {
        return null;
    }

    @Override
    public Shop save(Shop entity) {
        return null;
    }

    @Override
    public Shop update(Shop entity) {
        return null;
    }

    @Override
    public void delete(Shop entity) {

    }

    @Override
    public List<Shop> findAll() {
        List<Shop> allshop = new ArrayList<>();
        Iterable<Shop> shop = repository.findAll();
        for (Shop shops : shop) {
            allshop.add(shops);
        }
        return allshop;
    }
}
