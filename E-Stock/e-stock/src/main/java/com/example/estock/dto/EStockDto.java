package com.example.estock.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Column;

public class EStockDto {

    @NotNull
    private Long companyCodeId;
    @NotNull
    @Size(min = 5, max = 50)
    private String stockExchangeName;
    @NotNull
    @Size(min = 5, max = 50)
    private String companyName;
    @NotNull
    @Size(min = 3, max = 50)
    private String companyCEOName;
    @NotNull
    @Column(precision = 10, scale = 2)
    private Long turnover;
    @NotNull
    @Size(min = 5, max = 200)
    private String boardOfDirectors;
    @NotNull
    @Size(min = 5, max = 255)
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

    @Override
    public int hashCode() {
        return Objects.hash(companyProfile, boardOfDirectors, companyCEOName, companyName, stockExchangeName, companyCodeId, turnover);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstockDto other = (EstockDto) obj;
        return Objects.equals(companyProfile, other.companyProfile) 
                && Objects.equals(boardOfDirectors, other.boardOfDirectors)
                && Objects.equals(companyCEOName, other.companyCEOName);
                && Objects.equals(companyName, other.companyName);
                && Objects.equals(stockExchangeName, other.stockExchangeName);
                && Objects.equals(companyCodeId, other.companyCodeId);
                && Objects.equals(turnover, other.turnover);
                
    }

}
