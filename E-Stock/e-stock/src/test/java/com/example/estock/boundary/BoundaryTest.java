package com.example.estock.boundary;

import static com.example.estock.testutils.TestUtils.boundaryTestFile;
import static com.example.estock.testutils.TestUtils.currentTest;
import static com.example.estock.testutils.TestUtils.testReport;

import java.util.Set;
import java.util.Date;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.estock.dto.EStockDto;
import com.example.estock.dto.StockPriceDetailsDto;
import com.example.estock.testutils.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
    private static Validator validator;

    // ----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testCompanyCodeIdNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyCodeId(null);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }


    @Test
    public void testStockExchangeNameNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setStockExchangeName("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStockExchangeNameMinFive() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setStockExchangeName("Abcd");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void  testStockExchangeNameMaxFifty() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        String stockExchangeName = "";
        for (int i = 0; i < 55; i++) {
            stockExchangeName.concat("A");
        }
        eStockDto.setStockExchangeName(stockExchangeName);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyNameNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyName("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyNameMinFive() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyName("Abcd");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void  testCompanyNameMaxFifty() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        String companyName = "";
        for (int i = 0; i < 55; i++) {
            companyName.concat("A");
        }
        eStockDto.setCompanyName(companyName);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyCEONameNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyCEOName("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyCEONameMinThree() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyCEOName("Ab");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void  testCompanyCEONameMaxFifty() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        String companyCEOName = "";
        for (int i = 0; i < 55; i++) {
            companyCEOName.concat("A");
        }
        eStockDto.setCompanyCEOName(companyCEOName);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTurnoverNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setTurnover("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTurnoverPrecisionMaxTen() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        Long turnover = "";
        if {
            valueOf(turnover).replaceAll(".*\\.", "").length() <= 10;
        }
        eStockDto.setTurnover(turnover);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    @Test
    public void testTurnoverScaleMaxTwo() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        Long turnover = "";
        if {
            valueOf(turnover).replaceAll(".*\\.", "").length() <= 2;
        }
        eStockDto.setTurnover(turnover);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBoardOfDirectorsNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setBoardOfDirectors("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBoardOfDirectorsMinFive() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setBoardOfDirectors("Abcd");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void  testBoardOfDirectorsMaxTwoHundred() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        String boardOfDirectors = "";
        for (int i = 0; i < 220; i++) {
            boardOfDirectors.concat("A");
        }
        eStockDto.setBoardOfDirectors(boardOfDirectors);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyProfileNotNull() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyProfile("");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBoardOfDirectorsMinFive() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        eStockDto.setCompanyProfile("Abcd");
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void  testCompanyProfileMaxTwoHundredFiftyFive() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        String companyProfile = "";
        for (int i = 0; i < 260; i++) {
            companyProfile.concat("A");
        }
        eStockDto.setCompanyProfile(companyProfile);
        Set<ConstraintViolation<EStockDto>> violations = validator.validate(eStockDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCurrentStockPriceNotNull() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        stockPriceDetailsDto.setCurrentStockPrice("");
        Set<ConstraintViolation<EStoStockPriceDetailsDtockDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCurrentStockPricePrecisionMaxTen() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        Long currentStockPrice = "";
        if {
            valueOf(currentStockPrice).replaceAll(".*\\.", "").length() <= 10;
        }
        stockPriceDetailsDto.setCurrentStockPrice(currentStockPrice);
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    @Test
    public void testCurrentStockPriceScaleMaxTwo() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        Long currentStockPrice = "";
        if {
            valueOf(currentStockPrice).replaceAll(".*\\.", "").length() <= 2;
        }
        stockPriceDetailsDto.setCurrentStockPrice(currentStockPrice);
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStockPriceDateNotNull() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        stockPriceDetailsDto.setStockPriceDate("");
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStockPriceDateNotExceedCurrentDate() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        if {
            stockPriceDetailsDto.setStockPriceDate(stockPriceDate) >= Date();
        }
        stockPriceDetailsDto.setStockPriceDate(stockPriceDate);
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }


    @Test
    public void testStockPriceTimeNotNull() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        stockPriceDetailsDto.setStockPriceTime("");
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStockPriceTimeNotExceedCurrentDateTime() throws Exception {
        StockPriceDetailsDto stockPriceDetailsDto = MasterData.getStockPriceDetailsDto();
        if {
            stockPriceDetailsDto.setStockPriceTime(stockPriceTime) >= Date();
        }
        stockPriceDetailsDto.setStockPriceTime(stockPriceTime);
        Set<ConstraintViolation<StockPriceDetailsDto>> violations = validator.validate(stockPriceDetailsDto);
        Assert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
   
}
