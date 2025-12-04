package com.example.nasa.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpResponse {
    private int statusCode;
    private String body;
}