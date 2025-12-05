package com.example.nasa.api;

import com.example.nasa.dtos.response.NeoWsResponseDto;
import com.example.nasa.http.HttpService;

public class NeoWsClient extends BaseClient<NeoWsResponseDto> {

    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";

    public NeoWsClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<NeoWsResponseDto> getResponseType() {
        return NeoWsResponseDto.class;
    }
}
