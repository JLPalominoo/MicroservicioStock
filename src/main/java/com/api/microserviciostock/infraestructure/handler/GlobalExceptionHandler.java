package com.api.microserviciostock.infraestructure.handler;

import com.api.microserviciostock.domain.Exceptions.CategoryNotFoundException;
import com.api.microserviciostock.domain.Exceptions.CategoryValidationException;
import com.api.microserviciostock.domain.Exceptions.MensajeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryValidationException.class)
    public ResponseEntity<MensajeResponse> handleCategoryValidationException(CategoryValidationException ex) {
        MensajeResponse response = new MensajeResponse();
        response.setMensaje(ex.getMessage());
        response.setObject(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<MensajeResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        MensajeResponse response = new MensajeResponse();
        response.setMensaje(ex.getMessage());
        response.setObject(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensajeResponse> handleRuntimeException(RuntimeException ex) {
        MensajeResponse response = new MensajeResponse();
        response.setMensaje("Error interno del servidor: " + ex.getMessage());
        response.setObject(null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}