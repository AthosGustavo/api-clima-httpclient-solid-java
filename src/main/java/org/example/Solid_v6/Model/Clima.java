package org.example.Solid_v6.Model;

public class Clima {

    public Clima(String regiao){
        this.regiao = regiao;
        this.apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + regiao + "&appid=" + "8d477a13299a1dc90901fac477cc83d3";
    }
    private String apiUrl;
    private String regiao;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
