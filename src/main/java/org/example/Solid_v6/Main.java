package org.example.Solid_v6;

import org.example.Solid_v4.Service.ClimaService;
import org.example.Solid_v6.Model.Clima;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("==================== Olá, seja bem-vindo a API do clima! ====================\n Digite o nome do município que você deseja obter as informações climáticas");
        String regiao = entrada.nextLine();

        Clima clima = new Clima(regiao);
        ClimaService climaService = new ClimaService();

        try{
            String msg = climaService.exibeInfoClima(clima.getApiUrl());
            System.out.println(msg);
        }catch(IOException exc ){
            System.out.println(exc);
        }
        catch(InterruptedException exc){
            System.out.println(exc);
        }





    }
}
