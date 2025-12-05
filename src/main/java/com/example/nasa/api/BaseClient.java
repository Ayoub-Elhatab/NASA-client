package com.example.nasa.api;

import com.example.nasa.dtos.error.ApiErrorDto;
import com.example.nasa.dtos.response.ApiResponse;
import com.example.nasa.exception.ApiException;
import com.example.nasa.http.HttpService;
import com.example.nasa.utils.JsonUtils;
import java.io.IOException;
import java.util.Map;

public abstract class BaseClient <T>{

    protected final HttpService service;
    private final String baseUrl;

    protected BaseClient(HttpService service, String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    protected abstract Class<T> getResponseType();

    protected T getData(String fullBaseUrl, Map<String, String> queryParams) throws IOException, InterruptedException {
        String url = service.buildUrl(fullBaseUrl, queryParams);

        ApiResponse response = service.getData(url);

        if (response.getStatusCode() != 200) {
            ApiErrorDto error = JsonUtils.toJson(response.getBody(), ApiErrorDto.class);
            throw new ApiException(response.getStatusCode(), error.getMsg());
        }
        return JsonUtils.toJson(response.getBody(), getResponseType());
    }

    public T getData(Map<String, String> queryParams) throws IOException, InterruptedException {
        return getData(baseUrl, queryParams);
    }
}
