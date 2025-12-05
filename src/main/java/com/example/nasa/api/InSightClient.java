package com.example.nasa.api;

import com.example.nasa.dtos.response.InSightResponseDto;
import com.example.nasa.http.HttpService;

public class InSightClient extends BaseClient<InSightResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/insight_weather/";

    public InSightClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<InSightResponseDto> getResponseType() {
        return InSightResponseDto.class;
    }
}
