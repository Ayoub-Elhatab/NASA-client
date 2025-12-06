package com.example.nasa.api;

import com.example.nasa.dtos.response.NasaImageResponseDto;
import com.example.nasa.http.HttpService;

public class NasaImageClient extends BaseClient<NasaImageResponseDto> {

    private static final String BASE_URL = "https://images-api.nasa.gov/search";

    public NasaImageClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<NasaImageResponseDto> getResponseType() {
        return NasaImageResponseDto.class;
    }
}