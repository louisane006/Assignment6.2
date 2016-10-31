package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Manager;
import com.example.malumukendi.assignment6services.Repos.ManagerRepo;
import com.example.malumukendi.assignment6services.Service.ManagerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class ManagerServiceImpl extends Manager implements ManagerService {

    public ManagerRepo repo;

    @Override
    public Manager findById(Long aLong) {
        return null;
    }

    @Override
    public Manager save(Manager entity) {
        return null;
    }

    @Override
    public Manager update(Manager entity) {
        return null;
    }

    @Override
    public void delete(Manager entity) {

    }

    @Override
    public List<Manager> findAll() {
        List<Manager> allman = new ArrayList<>();
        Iterable<Manager> man = repo.findAll();
        for (Manager manager : man) {
            allman.add(manager);
        }
        return allman;
    }
}
