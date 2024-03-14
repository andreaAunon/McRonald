package com.sala3.mcronald.repository;

import com.sala3.mcronald.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    void deleteById(Long id);
    Producto findById(long id);

}