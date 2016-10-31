package com.example.malumukendi.assignment6services.Service.ServiceImpl;

import com.example.malumukendi.assignment6services.Domain.Customer;
import com.example.malumukendi.assignment6services.Repos.CustomerRepo;
import com.example.malumukendi.assignment6services.Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public class CustomerServiceImpl extends Customer implements CustomerService {

    private CustomerRepo repository;
    @Override
    public Customer findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);

    }
    @Override
    public List<Customer> findAll() {
        List<Customer> allcust = new ArrayList<>();
        Iterable<Customer> cust = repository.findAll();
        for (Customer subject : cust) {
            allcust.add(subject);
        }
        return allcust;
    }
}
