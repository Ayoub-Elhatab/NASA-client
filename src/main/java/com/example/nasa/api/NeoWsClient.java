package com.example.nasa.api;

import com.example.nasa.dtos.response.NeoWsResponseDto;
import com.example.nasa.http.HttpService;
import java.util.Map;

public class NeoWsClient extends BaseClient<NeoWsResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";

    public NeoWsClient(HttpService service) {
        super(service);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected Map<String, String> getQueryParams() {
        return Map.of(
                "start_date", "2025-01-01",
                "end_date", "2025-01-08",
                "api_key", "o3Lcz9kB4M0jR44Ml1Gr1w2nXWABzJ2oBqJGqOTo"
        );
    }

    @Override
    protected Class<NeoWsResponseDto> getResponseType() {
        return NeoWsResponseDto.class;
    }
}
