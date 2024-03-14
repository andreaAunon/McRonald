package com.sala3.mcronald.repository;

import com.sala3.mcronald.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {


}