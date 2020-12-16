package com.example.demo.service.country;

import com.example.demo.model.Country;
import com.example.demo.service.IService;

import java.util.concurrent.CountDownLatch;

public interface ICountryService extends IService<Country> {
    Country findByName(String name);
}
