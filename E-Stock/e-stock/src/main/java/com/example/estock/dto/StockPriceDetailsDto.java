package com.example.estock.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Column;
import javax.validation.constraints.PastOrPresent;
import java.util.*;

public class StockPriceDetailsDto {

    @NotNull
    private Long companyCodeId;
    @NotNull
    @Column(precision = 10, scale = 2)
    private Long currentStockPrice;
    @NotNull
    @PastOrPresent 
    private Date stockPriceDate;
    @NotNull
    @PastOrPresent 
    private Int stockPriceTime;
    @NotNull
    @Size(min = 3, max = 100)
    private String stockExchangeName;
   

    public Long getCompanyCodeId() {
        return companyCodeId;
    }

    public void setCompanyCodeId(Long companyCodeId) {
        this.companyCodeId = companyCodeId;
    }

    public Long getCurrentStockPrice() {
        return currentStockPrice;
    }

    public void setCurrentStockPrice(Long currentStockPrice) {
        this.currentStockPrice = currentStockPrice;
    }

    public Date getStockPriceDate()) {
        return stockPriceDate;
    }

    public void setStockPriceDate(Date stockPriceDate) {
        this.stockPriceDate = stockPriceDate;
    }

    public Int getStockPriceTime()) {
        return stockPriceTime;
    }

    public void setStockPriceTime(Int stockPriceTime) {
        this.stockPriceTime = stockPriceTime;
    }

    public String getStockExchangeName() {
        return stockExchangeName;
    }

    public void setStockExchangeName(String stockExchangeName) {
        this.stockExchangeName = stockExchangeName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockPriceTime, stockPriceDate, currentStockPrice, stockExchangeName, companyCodeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StockPriceDetailsDto other = (StockPriceDetailsDto) obj;
        return Objects.equals(stockPriceTime, other.stockPriceTime) 
                && Objects.equals(stockPriceDate, other.stockPriceDate)
                && Objects.equals(currentStockPrice, other.currentStockPrice);
                && Objects.equals(stockExchangeName, other.stockExchangeName);
                && Objects.equals(companyCodeId, other.companyCodeId);
                
                
    }

}
