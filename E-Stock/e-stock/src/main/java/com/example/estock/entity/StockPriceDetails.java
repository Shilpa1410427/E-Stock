package com.example.estock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockPriceDetails")
public class StockPriceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyCodeId;
    private Long currentStockPrice;
    private Date stockPriceDate;
    private Int stockPriceTime;
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
}