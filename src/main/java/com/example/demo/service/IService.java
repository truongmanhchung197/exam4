package com.example.demo.service;

import java.util.Iterator;
import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T model);
    void delete(Long id);
}
