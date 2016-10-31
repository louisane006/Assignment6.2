package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Cashier;
import com.example.malumukendi.assignment6services.Repos.CashierRepo;
import com.example.malumukendi.assignment6services.Service.CashierService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class CashierServiceImpl extends Cashier implements CashierService {

    public CashierRepo repo;

    @Override
    public Cashier findById(Long aLong) {
        return null;
    }

    @Override
    public Cashier save(Cashier entity) {
        return null;
    }

    @Override
    public Cashier update(Cashier entity) {
        return null;
    }

    @Override
    public void delete(Cashier entity) {

    }

    @Override
    public List<Cashier> findAll() {
        List<Cashier> allcas = new ArrayList<>();
        Iterable<Cashier> cas = repo.findAll();
        for (Cashier subject : cas) {
            allcas.add(subject);
        }
        return allcas;
    }
}
