package com.example.estock.service;

import java.util.List;
import com.example.estock.dto.EStockDto;

public interface EStockService {

    public EStockDto addCompanyDetails(EStockDto eStockDto);

    public boolean deleteCompany(Long companyCodeID);

    public EStockDto getStockByCompanyCodeId(Long companyCodeID);

    
}
