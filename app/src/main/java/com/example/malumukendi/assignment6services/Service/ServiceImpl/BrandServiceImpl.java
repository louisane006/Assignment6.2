package com.example.malumukendi.assignment6services.Service.ServiceImpl;


import com.example.malumukendi.assignment6services.Domain.Brand;
import com.example.malumukendi.assignment6services.Repos.BrandRepo;
import com.example.malumukendi.assignment6services.Service.BrandService;

import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl extends Brand implements BrandService {

    private BrandRepo repository;
    @Override
    public Brand findById(Long aLong) {
        return null;
    }

    @Override
    public Brand save(Brand entity) {
        return null;
    }

    @Override
    public Brand update(Brand entity) {
        return null;
    }

    @Override
    public void delete(Brand entity) {

    }
    @Override
    public List<Brand> findAll() {
        List<Brand> allbrand = new ArrayList<>();
        Iterable<Brand> brand = repository.findAll();
        for (Brand subject : brand) {
            allbrand.add(subject);
        }
        return allbrand;
    }
}
