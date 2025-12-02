package com.example.nasa;

import com.example.nasa.api.ApodClient;
import com.example.nasa.api.NeoWsClient;
import com.example.nasa.http.HttpService;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpService service = new HttpService();
        ApodClient client1 = new ApodClient(service);
        NeoWsClient client2 = new NeoWsClient(service);

        String data1 = client1.getData();
        String data2 = client2.getData();

        System.out.println(data1);
        System.out.println(data2);

    }
}