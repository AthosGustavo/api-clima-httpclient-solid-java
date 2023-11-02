package org.example.Solid_v4.Service;

import org.example.Solid_v4.HttpClientConfig.Client;
import org.json.JSONObject;

import java.io.IOException;

public class ClimaService {

    public String exibeInfoClima(String apiUrl) throws IOException, InterruptedException {

        Client client = new Client();
        String responseJson = client.disparaGet(apiUrl);
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
