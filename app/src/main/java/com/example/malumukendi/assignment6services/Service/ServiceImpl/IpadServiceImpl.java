package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Ipad;
import com.example.malumukendi.assignment6services.Repos.IpadRepo;
import com.example.malumukendi.assignment6services.Service.IPadService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class IpadServiceImpl extends Ipad implements IPadService {

    private IpadRepo repo;

    @Override
    public Ipad findById(Long aLong) {
        return null;
    }

    @Override
    public Ipad save(Ipad entity) {
        return null;
    }

    @Override
    public Ipad update(Ipad entity) {
        return null;
    }

    @Override
    public void delete(Ipad entity) {

    }

    @Override
    public List<Ipad> findAll() {
        List<Ipad> allIpad = new ArrayList<>();
        Iterable<Ipad> Ipad = repo.findAll();
        for (Ipad subject : Ipad) {
            allIpad.add(subject);
        }
        return allIpad;
    }
}