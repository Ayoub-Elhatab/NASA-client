package com.example.nasa.dtos.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDto {
    private int code;
    private String msg;
    private String message;

    public String getMsg() {
        return msg != null ? msg : message;
    }
}