package com.javaweb.controllerAdvise;

import com.javaweb.Model.ErrorResponse;
import com.javaweb.CustomException.FieldRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest re) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Interger number can not be divide to zero");
        errorResponse.setDetails(details);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequireException(FieldRequiredException ex, WebRequest re) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Name or nameofBasement is lack");
        errorResponse.setDetails(details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }
}
