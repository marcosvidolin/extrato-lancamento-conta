package com.marcosvidolin.sbapi.rest;

import com.marcosvidolin.sbapi.exception.BusinessException;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import com.marcosvidolin.sbapi.rest.response.ErrorMessageResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

/**
 * General API exception handler.
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<?> getStandardErrorHandler(final HttpStatus httpStatus
            , final String message, final HttpServletRequest request) {

        ErrorMessageResponseResource errorMessage = new ErrorMessageResponseResource(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                message,
                request.getRequestURI());

        return ResponseEntity.status(httpStatus.value()).body(errorMessage);
    }

    /**
     * Handle all {@link BusinessException} exception.
     *
     * @param ex the exception
     * @param request the given request
     * @return returns a message with error
     */
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<?> handleBusiness(BusinessException ex
            , HttpServletRequest request) {
        return this.getStandardErrorHandler(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    /**
     * Handle all {@link ConstraintViolationException} exception.
     *
     * @param ex the exception
     * @param request the given request
     * @return returns a message with error
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex
            , HttpServletRequest request) {
        return this.getStandardErrorHandler(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    /**
     * Handle all Internal Service Errors (500).
     *
     * @param ex the exception
     * @param request the given request
     * @return returns a message with error
     */
    @ExceptionHandler(value = {DatasourceException.class})
    public ResponseEntity<?> handleInternalServerError(Exception ex, HttpServletRequest request) {
        return this.getStandardErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCause().getMessage(), request);
    }

}