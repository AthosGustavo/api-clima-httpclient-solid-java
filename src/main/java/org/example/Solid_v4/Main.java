package org.example.Solid_v4;
import org.example.Solid_v4.Service.ClimaService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String chave = "8d477a13299a1dc90901fac477cc83d3";
        String regiao = "Paulista";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + regiao + "&appid=" + chave;


        ClimaService climaService = new ClimaService();

        String msg = climaService.exibeInfoClima(apiUrl);
        System.out.println(msg);

        //1-Ao invés do método disparaGet ser chamado no método main,agora ele é chamado dentro de ClimaService,retorna a response e lá mesmo é tratada.
        //2-Através do parâmetro de ClimaService é passado o link da api e consequentemente também é passada dentro do parâmetro de disparaGet que é chamada dentro de ClimaService.
        //3-a chave,regiao e apiUrl ainda são declaradas no método main

    }
}
