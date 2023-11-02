package org.example.Solid_v5.HttpClientConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    private HttpClient client;
    public Client(HttpClient client){
        this.client = client;
    }
    public String disparaGet(String apiUrl) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString()); //pesquisar sobre BodyHandler e ofString

        return response.body();

    }
}
