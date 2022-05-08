package com.example.estock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EStock")
public class EStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyCodeId;
    private String stockExchangeName;
    private String companyName;
    private String companyCEOName;
    private Long turnover;
    private String boardOfDirectors;
    private String companyProfile;

    public Long getCompanyCodeId() {
        return companyCodeId;
    }

    public void setCompanyCodeId(Long companyCodeId) {
        this.companyCodeId = companyCodeId;
    }

    public String getStockExchangeName() {
        return stockExchangeName;
    }

    public void setStockExchangeName(String stockExchangeName) {
        this.stockExchangeName = stockExchangeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEOName() {
        return companyCEOName;
    }

    public void setCompanyCEOName(String companyCEOName) {
        this.companyCEOName = companyCEOName;
    }

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }


}
