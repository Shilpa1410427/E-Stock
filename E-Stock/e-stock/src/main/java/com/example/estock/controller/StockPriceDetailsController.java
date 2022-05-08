package com.example.estock.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.estock.dto.StockPriceDetailsDto;
import com.example.estock.exceptions.InvalidDataException;
import com.example.estock.service.StockPriceDetailsService;

@RestController
@RequestMapping("/stockPriceDetails")
public class StockPriceDetailsController {

    @Autowired
    private StockPriceDetailsService stockPriceDetailsService;

    @PostMapping
    public ResponseEntity<?> addStock(@Valid @RequestBody StockPriceDetailsDto stockPriceDetailsDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidDataException("Company Code is not Valid");
        }
        stockPriceDetailsService.addStock(stockPriceDetailsDto);
        return ResponseEntity.ok(stockPriceDetailsDto);

    }

    @GetMapping("/{companyCodeID}/{startDate}/{endDate}")
    public ResponseEntity<StockPriceDetailsDto> getStockPriceIndex(@PathVariable Long companyCodeID, Date startDate, Date endDate) {
        StockPriceDetailsDto stockPriceDetailsDto = stockPriceDetailsService.getStockPriceIndex(companyCodeID, startDate, endDate);
        return ResponseEntity.ok(stockPriceDetailsDto);
    }
}