package com.example.nasa.api;

import com.example.nasa.dtos.response.ApodResponseDto;
import com.example.nasa.http.HttpService;

public class ApodClient extends BaseClient<ApodResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";

    public ApodClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<ApodResponseDto> getResponseType() {
        return ApodResponseDto.class;
    }
}
