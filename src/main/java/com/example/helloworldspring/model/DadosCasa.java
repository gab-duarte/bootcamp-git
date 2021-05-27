package com.example.helloworldspring.model;

import java.util.Map;

public class DadosCasa {
    private String nomeCasa;
    private double totalMetrosQuadrados;
    private double valorCasa;
    private Comodo maiorComodo;
    private Map<String, Double> metrosQuadradosPorComodo;

    public DadosCasa(String nomeCasa, double totalMetrosQuadrados, double valorCasa, Comodo maiorComodo, Map<String, Double> metrosQuadradosPorComodo) {
        this.nomeCasa = nomeCasa;
        this.totalMetrosQuadrados = totalMetrosQuadrados;
        this.valorCasa = valorCasa;
        this.maiorComodo = maiorComodo;
        this.metrosQuadradosPorComodo = metrosQuadradosPorComodo;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }

    public double getTotalMetrosQuadrados() {
        return totalMetrosQuadrados;
    }

    public void setTotalMetrosQuadrados(double totalMetrosQuadrados) {
        this.totalMetrosQuadrados = totalMetrosQuadrados;
    }

    public double getValorCasa() {
        return valorCasa;
    }

    public void setValorCasa(double valorCasa) {
        this.valorCasa = valorCasa;
    }

    public Comodo getMaiorComodo() {
        return maiorComodo;
    }

    public void setMaiorComodo(Comodo maiorComodo) {
        this.maiorComodo = maiorComodo;
    }

    public Map<String, Double> getMetrosQuadradosPorComodo() {
        return metrosQuadradosPorComodo;
    }

    public void setMetrosQuadradosPorComodo(Map<String, Double> metrosQuadradosPorComodo) {
        this.metrosQuadradosPorComodo = metrosQuadradosPorComodo;
    }
}
