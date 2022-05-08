package com.example.estock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estock.entity.EStock;

@Repository
public interface EStockRepository extends JpaRepository<EStock, Long> {
}
