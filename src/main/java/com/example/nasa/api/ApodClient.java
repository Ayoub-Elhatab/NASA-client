package com.example.nasa.api;

import com.example.nasa.dtos.response.ApodResponseDto;
import com.example.nasa.http.HttpService;
import java.util.Map;

public class ApodClient extends BaseClient<ApodResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";

    public ApodClient(HttpService service) {
        super(service);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected Map<String, String> getQueryParams() {
        return Map.of(
                "api_key", "o3Lcz9kB4M0jR44Ml1Gr1w2nXWABzJ2oBqJGqOTo"
        );
    }

    @Override
    protected Class<ApodResponseDto> getResponseType() {
        return ApodResponseDto.class;
    }
}
