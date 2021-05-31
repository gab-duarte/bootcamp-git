package com.example.helloworldspring.model;

import java.util.List;

public class Pedido {

    private static int contador = 0;

    private int id;
    private List<Prato> pratosSolicitados;

    public Pedido(List<Prato> pratosSolicitados) {
        ++contador;
        this.id = contador;
        this.pratosSolicitados = pratosSolicitados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Prato> getPratosSolicitados() {
        return pratosSolicitados;
    }

    public void setPratosSolicitados(List<Prato> pratosSolicitados) {
        this.pratosSolicitados = pratosSolicitados;
    }
}
