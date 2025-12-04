package com.example.nasa.dtos.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorDto {
    private int code;
    private String msg;
}