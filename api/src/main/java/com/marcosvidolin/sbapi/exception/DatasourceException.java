package com.marcosvidolin.sbapi.exception;

/**
 * Throws a {@link DatasourceException} when a error to access the data source occurs.
 */
public class DatasourceException extends Throwable {
    public DatasourceException(String message) {
        super(message);
    }
}
