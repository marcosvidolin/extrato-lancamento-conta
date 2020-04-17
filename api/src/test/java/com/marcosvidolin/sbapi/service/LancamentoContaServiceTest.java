package com.marcosvidolin.sbapi.service;

import com.marcosvidolin.sbapi.data.entity.LancamentoContaEntity;
import com.marcosvidolin.sbapi.data.repository.LancamentoContaRepository;
import com.marcosvidolin.sbapi.exception.BusinessException;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import com.marcosvidolin.sbapi.model.ExtratoDeLancamentoEmConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class LancamentoContaServiceTest {

    @MockBean
    private LancamentoContaRepository repository;

    @Autowired
    private ExtratoDeLancamentoEmContaService service;

    @Test
    public void findAllByPagination_whenPageIsOutOfRange_mustThrowBusinessException()
            throws DatasourceException {

        given(repository.getTotalLancamentos()).willReturn(50);

        Assertions.assertThrows(BusinessException.class, () -> {
            service.findAllByPagination(3, 20);
        });
    }

    @Test
    public void findAllByPagination_whenGiveValidPagination_mustReturn()
            throws DatasourceException, BusinessException {

        int page = 3;
        int items = 10;

        given(repository.getTotalLancamentos()).willReturn(50);
        given(repository.findAllByPagination(page, items)).willReturn(new LancamentoContaEntity());

        ExtratoDeLancamentoEmConta lancamentoConta = service.findAllByPagination(page, items);

        Assertions.assertNotNull(lancamentoConta);
    }

}
