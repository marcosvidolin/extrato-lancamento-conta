package com.marcosvidolin.sbapi.exception;

/**
 * Throws a {@link BusinessException} whenever a business validation error occurs.
 */
public class BusinessException extends Throwable {
    public BusinessException(String message) {
        super(message);
    }
}