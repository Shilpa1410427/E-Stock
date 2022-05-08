package com.example.estock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estock.dto.StockPriceDetailsDto;
import com.example.estock.entity.StockPriceDetails;
import com.example.estock.exceptions.EStockNotFoundException;
import com.example.estock.repository.StockPriceDetailsRepository;
import com.example.estock.service.StockPriceDetailsService;

@Service
public class StockPriceDetailsServiceImpl implements StockPriceDetailsService {

    @Autowired
    private StockPriceDetailsRepository stockPriceDetailsRepository;

    @Override
    public StockPriceDetailsDto addStock(StockPriceDetailsDto stockPriceDetailsDto) {
        StockPriceDetails stockPriceDetails = new StockPriceDetails();
        BeanUtils.copyProperties(stockPriceDetailsDto, stockPriceDetails);
        stockPriceDetailsRepository.save(stockPriceDetails);
        return stockPriceDetailsDto;
    }

    @Override
    public StockPriceDetailsDto getStockPriceIndex(Long companyCodeID, Date startDate, Date endDate) {
        Optional<StockPriceDetails> stockPriceDetails = stockPriceDetailsRepository.findById(companyCodeID);
        if (!stockPriceDetails.isPresent()) {
            StockPriceDetailsDto stockDetailsDto = getStockPriceIndex(companyCodeID, startDate, endDate);
            BeanUtils.copyProperties(stockPriceDetails.get(), stockDetailsDto);
            return stockDetailsDto;
        } else {
            throw new EStockNotFoundException("Party with Id " + companyCodeID + " not found");
        }
    }

}