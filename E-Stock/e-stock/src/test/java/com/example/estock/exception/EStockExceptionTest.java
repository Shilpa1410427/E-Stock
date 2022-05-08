package com.example.estock.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.estock.testutils.TestUtils.currentTest;
import static com.example.estock.testutils.TestUtils.exceptionTestFile;
import static com.example.estock.testutils.TestUtils.testReport;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.estock.controller.EStockController;
import com.example.estock.dto.EStockDto;
import com.example.estock.exceptions.EStockNotFoundException;
import com.example.estock.model.exception.ExceptionResponse;
import com.example.estock.service.EStockService;
import com.example.estock.testutils.MasterData;

@SpringBootTest
@WebMvcTest(EStockController.class)
@AutoConfigureMockMvc
public class EStockExceptionTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EStockService eStockService;

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testCreateEStockInvalidDataException() throws Exception {
        EStockDto eStockDto = MasterData.getEStockDto();
        EStockDto savedEStockDto = MasterData.getEStockDto();
        savedEStockDto.setCompanyCodeID(1L);

        eStockDto.setStockExchangeName("Ab");

        when(this.eStockService.addCompanyDetails(eStockDto)).thenReturn(savedEStockDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/eStock")
                .content(MasterData.asJsonString(eStockDto)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert(currentTest(),
                (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
                exceptionTestFile);

    }

    @Test
    public void testDeleteEStockNotFoundException() throws Exception {
        ExceptionResponse exResponse = new ExceptionResponse("Company with Id - 2 not Found!",
                System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

        when(this.eStockService.deleteCompany(2L))
                .thenThrow(new EStockNotFoundException("Company with Id - 2 not Found!"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/eStock/2")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
     	Assert(currentTest(),
                (result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
                exceptionTestFile);

    }
    
    @Test
    public void testGetStockByCompanyCodeIdNotFoundException() throws Exception {
        ExceptionResponse exResponse = new ExceptionResponse("Company with Id - 2 not Found!",
                System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
        
        when(this.eStockService.getStockByCompanyCodeId(2L))
        .thenThrow(new EStockNotFoundException("Company with Id - 2 not Found!"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/eStock/2")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert(currentTest(),
                (result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
                exceptionTestFile);
        
    }

    

}

