package com.marcosvidolin.sbapi.service;

import com.google.common.base.Preconditions;
import com.marcosvidolin.sbapi.data.entity.LancamentoContaEntity;
import com.marcosvidolin.sbapi.data.repository.LancamentoContaRepository;
import com.marcosvidolin.sbapi.exception.BusinessException;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import com.marcosvidolin.sbapi.mapper.ExtratoDeLancamentoEmContaMapper;
import com.marcosvidolin.sbapi.model.ExtratoDeLancamentoEmConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link ExtratoDeLancamentoEmConta} service layer.
 */
@Service
public class ExtratoDeLancamentoEmContaService {

    private LancamentoContaRepository repository;
    private ExtratoDeLancamentoEmContaMapper mapper;

    @Autowired
    public ExtratoDeLancamentoEmContaService(LancamentoContaRepository repository,
                                             ExtratoDeLancamentoEmContaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Gets all {@link LancamentoContaEntity} from the database according the pagination.
     *
     * @param page int
     *             the page number
     * @param items int
     *             items per page
     * @return LancamentoConta
     * @throws DatasourceException
     */
    public ExtratoDeLancamentoEmConta findAllByPagination(int page, int items)
            throws DatasourceException, BusinessException {
        this.validatePagination(page, items);
        LancamentoContaEntity lancamentoContaEntity = this.repository.findAllByPagination(page, items);
        return this.mapper.map(lancamentoContaEntity);
    }

    private void validatePagination(int page, int items) throws DatasourceException, BusinessException {
        Preconditions.checkArgument(page > 0, "The 'page' value must be greater than zero.");
        Preconditions.checkArgument(items > 0, "The 'items' value must be greater than zero.");

        int totalItems = repository.getTotalLancamentos();
        int totalItemsRequested = page * items;
        boolean isFirstPage = page == 1;

        if (!isFirstPage && totalItemsRequested > totalItems) {
            throw new BusinessException("Invalid pagination values. The total available items are: " + totalItems);
        }
    }
}
