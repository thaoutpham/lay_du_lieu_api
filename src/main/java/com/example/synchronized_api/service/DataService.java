package com.example.synchronized_api.service;

import com.example.synchronized_api.model.Data;
import com.example.synchronized_api.repository.DatumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataService implements IDataService<Data> {
    @Autowired
    private DatumRepository datumRepository;
    @Override
    public Iterable<Data> findAll() {
        return datumRepository.findAll();
    }

    @Override
    public Optional<Data> findById(Long id) {
        return datumRepository.findById(id);
    }

    @Override
    public Data save(Data data) {
        return datumRepository.save(data);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public Optional<Data> findByMa_phuong_xa(String maPhuongXa) {
        return datumRepository.findAllByMaphuongxa(maPhuongXa);

    }
}
