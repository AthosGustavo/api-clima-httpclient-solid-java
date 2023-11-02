package org.example.Solid_v5;
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

        //1-a chave,regiao e apiUrl ainda são declaradas no método main
        //2-Caso ouvesse mais de um metodo HTTP na classe Client,seria necessário instanciar a classe HttpClient para todos os casos.
        //Pensando nisso, criei um atributo do tipo HttpClient na classe Client,fiz um método construtor que recebe no parâmetro
        //um valor do tipo HttpClient e atribui esse valor aou atributo da classe.
        //3-Na classe ClimaService,dentro do método exibeInfoClima a classe HttpClient é instanciada e sua variável é passada dentro
        //do método construtor da instância da Classe Client.
        //4-Resumo:Caso houver um método POST ou DELETE, não será necessário instanciar a classe HttpClient várias vezs.

    }
}
