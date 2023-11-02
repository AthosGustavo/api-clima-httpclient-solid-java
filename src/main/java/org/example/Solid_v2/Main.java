package org.example.Solid_v2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;



public class Main {

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

    public static void main(String[] args) throws IOException, InterruptedException {

        Main app = new Main();

        String chave = "8d477a13299a1dc90901fac477cc83d3";
        String regiao = "Paulista";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + regiao + "&appid=" + chave;

        String responseJson = app.disparaGet(apiUrl);
        String msg = app.exibeInfoClima(responseJson);
        System.out.println(msg);

    }
    //1-A chave,regiao e apiUrl são declarados no método main
    //2-Métodos foram criados para evitar o ´codigo corrido´
    //3-O metodo disparaGet recebe o link da api como parâmetro, faz a requisição e devolve a response
    //4-exibeInfoClima, em seu parametro, recebe a variavel que recebe a response e detro do metodo converte o valor para JSONObject
}
