package com.example.malumukendi.assignment6services.Service;

import com.example.malumukendi.assignment6services.Domain.Brand;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-04.
 */
public interface HighestBrandPriceService {

    Brand highestCost(List<Brand> b);
}

