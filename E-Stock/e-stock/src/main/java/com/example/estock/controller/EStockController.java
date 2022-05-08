package com.example.estock.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.estock.dto.EStockDto;
import com.example.estock.exceptions.InvalidDataException;
import com.example.estock.service.EStockService;

@RestController
@RequestMapping("/estock")
public class EStockController {

    @Autowired
    private EStockService eStockService;

    @PostMapping
    public ResponseEntity<?> addCompanyDetails(@Valid @RequestBody EStockDto eStockDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidDataException("Company Code is not Valid");
        }
        eStockService.addCompanyDetails(eStockDto);
        return ResponseEntity.ok(eStockDto);

    }

    @DeleteMapping("/{companyCodeID}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyCodeID) {
        boolean result = eStockService.deleteCompany(companyCodeID);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/{companyCodeID}")
    public ResponseEntity<EStockDto> getStockByCompanyCodeId(@PathVariable Long companyCodeID) {
        EStockDto eStockDto = eStockService.getStockByCompanyCodeId(companyCodeID);
        return ResponseEntity.ok(eStockDto);
    }

}
