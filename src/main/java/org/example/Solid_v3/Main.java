package org.example.Solid_v3;

import org.example.Solid_v3.Services.exibeInfoClimaService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        exibeInfoClimaService app = new exibeInfoClimaService();

        String chave = "8d477a13299a1dc90901fac477cc83d3";
        String regiao = "Paulista";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + regiao + "&appid=" + chave;

        String responseJson = app.disparaGet(apiUrl);
        String msg = app.exibeInfoClima(responseJson);
        System.out.println(msg);

    }

    //1-A chave,regiao,apiUrl ainda são declaradas no metodo main
    //2-Os métodos disparaGet e exibeInfoClima são declarados dentro da classe exibeInfoClimaService
    //3-A classe exibeInforClimaService possui duas responsabilidades:fazer a conexão e listar o resultado

}
