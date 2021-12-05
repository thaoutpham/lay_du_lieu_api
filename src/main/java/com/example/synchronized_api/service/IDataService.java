package com.example.synchronized_api.service;

import com.example.synchronized_api.model.Data;

import java.util.Optional;

public interface IDataService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);

    Optional<Data> findByMa_phuong_xa(String maPhuongXa);
}
