package com.example.nasa;

import com.example.nasa.api.ApodClient;
import com.example.nasa.api.NeoWsClient;
import com.example.nasa.http.HttpService;
import com.example.nasa.utils.JsonUtils;

public class Main {

    public static void main(String[] args) {

        HttpService service = new HttpService();

        ApodClient apodClient = new ApodClient(service);
        NeoWsClient neoClient = new NeoWsClient(service);


        JsonUtils.print(apodClient);
        JsonUtils.print(neoClient);

    }
}