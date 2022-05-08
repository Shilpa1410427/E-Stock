package com.example.estock.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estock.entity.StockPriceDetails;

@Repository
public interface StockPriceDetailsRepository extends JpaRepository<StockPriceDetails, Long> {
    List<StockPriceDetails> findByCompanyCodeId(Long companyCodeId);
}
