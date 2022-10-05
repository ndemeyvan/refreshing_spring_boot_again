package com.dcbspring.dcbspring.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dcbspring.dcbspring.entities.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departementException(DepartmentNotFoundException departmentNotFoundException,WebRequest webRequest){
        ErrorMessage errors = new ErrorMessage(HttpStatus.NOT_FOUND,departmentNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

}