package com.example.estock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estock.dto.EStockDto;
import com.example.estock.entity.EStock;
import com.example.estock.exceptions.EStockNotFoundException;
import com.example.estock.repository.EStockRepository;
import com.example.estock.service.EStockService;

@Service
public class EStockServiceImpl implements EStockService {

    @Autowired
    private EStockRepository eStockRepository;

    @Override
    public EStockDto addCompanyDetails(EStockDto eStockDto) {
        EStock eStock = new EStock();
        BeanUtils.copyProperties(eStockDto, eStock);
        eStockRepository.save(eStock);
        return eStockDto;
    }

    @Override
    public boolean deleteCompany(Long companyCodeID) {
        EStockDto eStockDto = getStockByCompanyCodeId(companyCodeID);
        EStock eStock = new EStock();
        BeanUtils.copyProperties(eStockDto, eStock)
        eStockRepository.delete(eStock);
        return false;
    }

    @Override
    public EStockDto getStockByCompanyCodeId(Long companyCodeID) {
        Optional<EStock> eStock = eStockRepository.findById(companyCodeID);
        if (!eStock.isPresent()) {
            EStockDto eStockDto = getStockByCompanyCodeId(companyCodeID);
            BeanUtils.copyProperties(eStock.get(), eStockDto);
            return eStockDto;
        } else {
            throw new EStockNotFoundException("Party with Id " + companyCodeID + " not found");
        }
    }

}

