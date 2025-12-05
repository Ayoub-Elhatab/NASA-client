package com.example.nasa.api;

import com.example.nasa.dtos.response.TleResponseDto;
import com.example.nasa.http.HttpService;

public class TleClient extends BaseClient<TleResponseDto> {

    private static final String BASE_URL = "https://tle.ivanstanojevic.me/api/tle/";

    public TleClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<TleResponseDto> getResponseType() {
        return TleResponseDto.class;
    }

}
