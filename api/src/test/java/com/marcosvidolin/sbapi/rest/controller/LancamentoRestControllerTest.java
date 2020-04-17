package com.marcosvidolin.sbapi.rest.controller;

import com.marcosvidolin.sbapi.exception.BusinessException;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import com.marcosvidolin.sbapi.model.ExtratoDeLancamentoEmConta;
import com.marcosvidolin.sbapi.service.ExtratoDeLancamentoEmContaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExtratoDeLancamentoEmContaRestController.class)
public class LancamentoRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExtratoDeLancamentoEmContaService service;

    @Test
    public void get_whenPaginationParamsWasNotInformed_mustReturnBadRequest()
            throws Exception {
        mvc.perform(get("/api/lancamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void get_whenInformAllParameters_mustReturnOk()
            throws Exception, DatasourceException, BusinessException {

        given(service.findAllByPagination(1, 20)).willReturn(new ExtratoDeLancamentoEmConta());

        mvc.perform(get("/api/lancamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .param("page", "1")
                .param("items", "20"))
                .andExpect(status().isOk());
    }

    @Test
    public void get_whenBusinessException_mustReturnBadRequest()
            throws Exception, DatasourceException, BusinessException {

        given(service.findAllByPagination(1, 60)).willThrow(BusinessException.class);

        mvc.perform(get("/api/lancamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .param("page", "1")
                .param("items", "60"))
                .andExpect(status().isBadRequest());
    }

}
