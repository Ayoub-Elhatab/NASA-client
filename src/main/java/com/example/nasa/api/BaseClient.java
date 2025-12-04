package com.example.nasa.api;

import com.example.nasa.dtos.error.ApiErrorDto;
import com.example.nasa.dtos.response.HttpResponse;
import com.example.nasa.exception.ApiException;
import com.example.nasa.http.HttpService;
import com.example.nasa.utils.JsonUtils;
import java.io.IOException;
import java.util.Map;

public abstract class BaseClient <T>{

    protected final HttpService service;

    protected BaseClient(HttpService service) {
        this.service = service;
    }

    protected abstract String getBaseUrl();
    protected abstract Map<String, String> getQueryParams();
    protected abstract Class<T> getResponseType();

    public T getData() throws IOException, InterruptedException {
        String url = service.buildUrl(getBaseUrl(), getQueryParams());

        HttpResponse response = service.getData(url);

        if (response.getStatusCode() != 200) {
            ApiErrorDto error = JsonUtils.toJson(response.getBody(), ApiErrorDto.class);
            throw new ApiException(response.getStatusCode(), error.getMsg());
        }

        return JsonUtils.toJson(response.getBody(), getResponseType());
    }
}
