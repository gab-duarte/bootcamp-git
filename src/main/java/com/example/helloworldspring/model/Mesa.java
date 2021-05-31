package com.example.helloworldspring.model;

import java.util.List;

public class Mesa {

    private String id;
    private List<Pedido> pedidos;
    private double totalConsumido = 0.0;

    public Mesa(String id, List<Pedido> pedidos, double totalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.totalConsumido = totalConsumido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(double totalConsumido) {
        this.totalConsumido = totalConsumido;
    }
}
