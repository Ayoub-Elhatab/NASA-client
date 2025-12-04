package com.example.nasa.api;

import com.example.nasa.dtos.response.InSightResponseDto;
import com.example.nasa.http.HttpService;
import java.util.Map;

public class InSightClient extends BaseClient<InSightResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/insight_weather/";

    public InSightClient(HttpService service) {
        super(service);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected Map<String, String> getQueryParams() {
        return Map.of(
                "api_key", "o3Lcz9kB4M0jR44Ml1Gr1w2nXWABzJ2oBqJGqOTo",
                "feedtype", "json",
                "ver", "1.0"
        );
    }

    @Override
    protected Class<InSightResponseDto> getResponseType() {
        return InSightResponseDto.class;
    }
}
