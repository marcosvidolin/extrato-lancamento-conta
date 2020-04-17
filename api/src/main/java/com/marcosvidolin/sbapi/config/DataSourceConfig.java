package com.marcosvidolin.sbapi.config;

import com.marcosvidolin.sbapi.data.repository.LancamentoContaRepository;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

/**
 * This class is responsible for the Data Source configuration details.
 */
public final class DataSourceConfig {

    private static final Logger log = Logger.getLogger(LancamentoContaRepository.class.getName());

    private static DataSourceConfig instance;

    private static File dataSource;

    private DataSourceConfig() {
    }

    /**
     * Returns the DataSouceConfig instance.
     *
     * @param dataSourcePath String path to the data source file
     * @return DataSourceConfig instance
     * @throws DatasourceException
     */
    public static DataSourceConfig getInstance(String dataSourcePath) throws DatasourceException {
        if (instance == null) {
            dataSource = createDatasource(dataSourcePath);
            instance = new DataSourceConfig();
        }
        return instance;
    }

    /**
     * Gets the data source file.
     *
     * @return File data source
     */
    public File getDataSource() {
        return dataSource;
    }

    private static File createDatasource(String dataSourcePath) throws DatasourceException {
        try {
           return ResourceUtils.getFile(dataSourcePath);
        } catch (FileNotFoundException e) {
            log.severe("Data source not found at: " + dataSourcePath);
            throw new DatasourceException(e.getMessage());
        }
    }
}
