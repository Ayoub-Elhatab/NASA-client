package com.example.nasa.api;

import com.example.nasa.http.HttpService;
import java.io.IOException;

public class NeoWsClient {

    final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2025-01-01&end_date=2025-01-08&api_key=o3Lcz9kB4M0jR44Ml1Gr1w2nXWABzJ2oBqJGqOTo";

    private final HttpService service;

    public NeoWsClient(HttpService service) {
        this.service = service;
    }


    public String getData() throws IOException, InterruptedException {
        return service.getData(BASE_URL);
    }
}
