package com.example.nasa.api;

import com.example.nasa.http.HttpService;
import java.io.IOException;

public class ApodClient {

    final String BASE_URL = "https://api.nasa.gov/planetary/apod?api_key=o3Lcz9kB4M0jR44Ml1Gr1w2nXWABzJ2oBqJGqOTo";

    private final HttpService service;

    public ApodClient(HttpService service) {
        this.service = service;
    }

    public String getData() throws IOException, InterruptedException {
        return service.getData(BASE_URL);
    }
}
