package com.api.microserviciostock.domain.Exceptions;

public class CategoryValidationException extends RuntimeException {
    public CategoryValidationException(String message) {
        super(message);
    }
}
