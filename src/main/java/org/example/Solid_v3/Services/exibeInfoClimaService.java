package org.example.Solid_v3.Services;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;



public class exibeInfoClimaService {

    public String disparaGet(String apiUrl) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()); //pesquisar sobre BodyHandler e ofString

        return response.body();

    }

    public String exibeInfoClima(String responseJson){
        JSONObject responseObject = new JSONObject(responseJson);
        String regiaoJson = responseObject.getString("name");
        String pais = responseObject.getJSONObject("sys").getString("country");
        double tempMinima = responseObject.getJSONObject("main").getInt("temp_min") - 273.15;
        double tempMaxima = responseObject.getJSONObject("main").getInt("temp_max") - 273.15;
        String tempo = responseObject.getJSONArray("weather").getJSONObject(0).getString("main");
        String descClima = responseObject.getJSONArray("weather").getJSONObject(0).getString("description");

        return String.format("========= Informações climáticas ==========\nPaís: %s\nRegião: %s\nTemperatura mínima: %.1f\nTemperatura máxima: %.1f\nTempo: %s\nDescrição: %s\n===========================================",pais,regiaoJson,tempMinima,tempMaxima,tempo,descClima);
    }

}
