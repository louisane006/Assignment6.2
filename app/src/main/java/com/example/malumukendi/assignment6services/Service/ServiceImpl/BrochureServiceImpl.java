package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Brochure;
import com.example.malumukendi.assignment6services.Repos.BrochureRepo;
import com.example.malumukendi.assignment6services.Service.BrochureService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class BrochureServiceImpl extends Brochure implements BrochureService {

    private BrochureRepo repository;

    @Override
    public Brochure findById(Long aLong) {
        return null;
    }

    @Override
    public Brochure save(Brochure entity) {
        return null;
    }

    @Override
    public Brochure update(Brochure entity) {
        return null;
    }

    @Override
    public void delete(Brochure entity) {

    }

    @Override
    public List<Brochure> findAll() {
        List<Brochure> allcust = new ArrayList<>();
        Iterable<Brochure> cust = repository.findAll();
        for (Brochure subject : cust) {
            allcust.add(subject);
        }
        return allcust;
    }
}