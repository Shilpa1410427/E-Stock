package com.example.estock.service;

import java.util.List;
import com.example.estock.dto.StockPriceDetailsDto;

public interface StockPriceDetailsService {

    public StockPriceDetailsDto addStock(StockPriceDetailsDto stockPriceDetailsDto);

    public StockPriceDetailsDto getStockPriceIndex(Long companyCodeID, Date startDate, Date endDate);

    
}
