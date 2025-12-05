package com.example.nasa.api;

import com.example.nasa.dtos.response.OsdrResponseDto;
import com.example.nasa.http.HttpService;
import java.io.IOException;
import java.util.Map;

public class OsdrClient extends BaseClient<OsdrResponseDto> {

    private static final String BASE_URL = "https://osdr.nasa.gov/osdr/data/osd/files/";

    public OsdrClient(HttpService service) {
        super(service, BASE_URL);
    }

    @Override
    protected Class<OsdrResponseDto> getResponseType() {
        return OsdrResponseDto.class;
    }

    public OsdrResponseDto getData(int studyAccessionNumber, Map<String, String> queryParams) throws IOException, InterruptedException {
        return getData(BASE_URL + studyAccessionNumber, queryParams);
    }
}


