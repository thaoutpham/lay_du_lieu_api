package com.example.synchronized_api.repository;

import com.example.synchronized_api.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatumRepository extends JpaRepository<Data,Long> {
     Optional<Data> findAllByMaphuongxa(String cap);
}
