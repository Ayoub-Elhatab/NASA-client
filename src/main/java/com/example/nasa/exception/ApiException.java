package com.example.nasa.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final int statusCode;
    private final String errorMessage;

    public ApiException(int statusCode, String errorMessage) {
        super("API Error (" + statusCode + "): " + errorMessage);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }
}