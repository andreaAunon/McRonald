package com.sala3.mcronald.repository;

import com.sala3.mcronald.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Menu, Long> {
}
