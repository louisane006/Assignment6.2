package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Laptop;
import com.example.malumukendi.assignment6services.Repos.LaptopRepo;
import com.example.malumukendi.assignment6services.Service.LaptopService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class LaptopServiceImpl extends Laptop implements LaptopService {

    private LaptopRepo repo;

    private LaptopServiceImpl(Builder b) {
        super(b);
    }

    @Override
    public Laptop findById(Long aLong) {
        return null;
    }

    @Override
    public Laptop save(Laptop entity) {
        return null;
    }

    @Override
    public Laptop update(Laptop entity) {
        return null;
    }

    @Override
    public void delete(Laptop entity) {

    }

    @Override
    public List<Laptop> findAll() {
        List<Laptop> alllaptop = new ArrayList<>();
        Iterable<Laptop> lap = repo.findAll();
        for (Laptop laptop : lap) {
            alllaptop.add(laptop);
        }
        return alllaptop;
    }
}
