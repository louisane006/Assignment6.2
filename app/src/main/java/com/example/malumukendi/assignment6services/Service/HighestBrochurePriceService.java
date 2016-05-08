package com.example.malumukendi.assignment6services.Service;

import com.example.malumukendi.assignment6services.Domain.Brochure;

import java.util.List;

/**
 * Created by Malu.Mukendi on 2016-05-07.
 */
public interface HighestBrochurePriceService {

    Brochure highestCost(List<Brochure> works);
}
