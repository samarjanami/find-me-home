package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Media;
import com.samar.findmehome.service.model.Property;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSource;
import okio.Okio;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResoServiceTest {
    public MockWebServer mockWebServer;
    private ResoService resoService;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        String baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        resoService = new ResoService(baseUrl, "token");
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getProperties() throws InterruptedException, IOException {
            Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        enqueueResponse("properties.json",headers);

        List<Property> response = resoService.getProperties(95314,"condo" , 1, 1,2000 ,600000 );
        assert response != null;
        assertEquals(1, response.size());
        assertEquals(485425, response.get(0).getPrice());
        assertEquals("Single Family Residence", response.get(0).getPropertyType());
        assertEquals(8, response.get(0).getPictures().size());
        assertThat(response.get(0).getPictures(),
                hasItem(allOf(
                        Matchers.<Media>hasProperty("order", is(1)),
                        Matchers.<Media>hasProperty("mediaUrl", is("https://s3.amazonaws.com/retsly-importd-production/test_data/listings/29.jpg")),
                        Matchers.<Media>hasProperty("mediaCategory", is("Photo")),
                        Matchers.<Media>hasProperty("mimeType", is("image/jpeg")),
                        Matchers.<Media>hasProperty("shortDescription", is("Caecus cruciamentum corona despirmatio."))
                )));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertThat(recordedRequest.getPath(), startsWith("/Property?$filter=contains(PostalCode,'95314')"));

    }

    private void enqueueResponse(String fileName, Map<String, String> headers) throws IOException {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("api-response/" + fileName);
        assert inputStream != null;
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        for(Map.Entry<String, String> header : headers.entrySet()){
            mockResponse.addHeader(header.getKey(), header.getValue());
        }
        mockWebServer.enqueue(mockResponse.setBody(source.readString(StandardCharsets.UTF_8)));
    }
}