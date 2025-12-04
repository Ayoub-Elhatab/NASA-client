package com.example.nasa.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {
    private int statusCode;
    private String body;
}