package com.marcosvidolin.sbapi.data.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosvidolin.sbapi.config.DataSourceConfig;
import com.marcosvidolin.sbapi.data.entity.LancamentoContaEntity;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Data access class to "LancamentoConta" entity.
 */
@Data
@Repository
public class LancamentoContaRepository {

    private static final Logger log = Logger.getLogger(LancamentoContaRepository.class.getName());

    @Value("${datasource.path}")
    private String dataSourcePath;

    /**
     * Gets the total of items.
     *
     * @return int total of items
     * @throws DatasourceException
     */
    public int getTotalLancamentos() throws DatasourceException {
        LancamentoContaEntity lancamentoConta = this.getDatabaseContent();
        return lancamentoConta.getTotalElements();
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
    public LancamentoContaEntity findAllByPagination(int page, int items) throws DatasourceException {
        // fake pagination ;)
        return this.getDatabaseContent();
    }

    private LancamentoContaEntity getDatabaseContent() throws DatasourceException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File dataSource = DataSourceConfig.getInstance(dataSourcePath).getDataSource();
            return objectMapper.readValue(dataSource, LancamentoContaEntity.class);
        } catch (IOException e) {
            log.severe(e.getMessage());
            throw new DatasourceException("An error has occurred trying to read the data source.");
        }
    }

}
