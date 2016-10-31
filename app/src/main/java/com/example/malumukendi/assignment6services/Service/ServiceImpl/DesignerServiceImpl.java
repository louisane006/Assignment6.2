package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Designer;
import com.example.malumukendi.assignment6services.Repos.DesignerRepo;
import com.example.malumukendi.assignment6services.Service.DesignerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class DesignerServiceImpl extends Designer implements DesignerService {

    private DesignerRepo repo;

    @Override
    public Designer findById(Long aLong) {
        return null;
    }

    @Override
    public Designer save(Designer entity) {
        return null;
    }

    @Override
    public Designer update(Designer entity) {
        return null;
    }

    @Override
    public void delete(Designer entity) {

    }

    @Override
    public List<Designer> findAll() {
        List<Designer> alldes = new ArrayList<>();
        Iterable<Designer> designers = repo.findAll();
        for (Designer des : designers) {
            alldes.add(des);
        }
        return alldes;
    }
}