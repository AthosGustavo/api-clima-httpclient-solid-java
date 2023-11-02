package org.example.Solid_v1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //--------------------------------- metodo 1: dispara metodo GET-----------------------------------------------------
        String chave = "8d477a13299a1dc90901fac477cc83d3";
        String regiao = "Paulista";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + regiao + "&appid=" + chave;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()); //pesquisar sobre BodyHandler e ofString

        String jsonResponse = response.body(); //pesquisar sobre response.body();

        JSONObject responseObject = new JSONObject(jsonResponse);
        //-----------------------------------------------------------------------------------------------

        //------------------------------------- metodo 2 : exibeInfoClima------------------------------------------------
        String regiaoJson = responseObject.getString("name");
        String pais = responseObject.getJSONObject("sys").getString("country");
        double tempMinima = responseObject.getJSONObject("main").getInt("temp_min") - 273.15;
        double tempMaxima = responseObject.getJSONObject("main").getInt("temp_max") - 273.15;
        String tempo = responseObject.getJSONArray("weather").getJSONObject(0).getString("main");
        String descClima = responseObject.getJSONArray("weather").getJSONObject(0).getString("description");

        String mensagem = String.format("País: %s\nRegião: %s\nTemperatura mínima: %.1f\nTemperatura máxima: %.1f\nTempo: %s\nDescrição: %s",pais,regiao,tempMinima,tempMaxima,tempo,descClima);
        System.out.println("========= Informações climáticas ==========");
        System.out.println(mensagem);
        System.out.println("===========================================");
        //-----------------------------------------------------------------------------------------------


        //1-Todas as funcionalidades estão sendo executadas de maneira corrida no método main dentro da classe
        //2-fazer a conexao com HttpClient e processar a resposta
        //3-formatar e listar os dados



    }
}
