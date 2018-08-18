package spring_rest.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.Matchers.equalTo;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;

public class CategoriesControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static Properties properties;
    private static String domen;



    @BeforeClass
    public static void setup(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("ser.properties"));
            domen = properties.getProperty("domen.site");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived() throws ClientProtocolException, IOException {


       //Given
        final String name = randomAlphabetic(8);
        final HttpUriRequest request = new HttpGet(domen + "/rest/all" + name);
        System.out.println(request.toString());
        System.out.println();

        // When
        final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        System.out.println(request.toString());
        System.out.println(httpResponse);
        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));

}
    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson() throws ClientProtocolException, IOException {
        // Given
        final String jsonMimeType = "application/json";
        final HttpUriRequest request = new HttpGet(domen + "/rest/all");

        // When
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        final String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
    }

}