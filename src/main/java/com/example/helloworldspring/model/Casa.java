package com.example.helloworldspring.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Casa {

    private static final double  valorM2 = 800.0;//7592.0;

    private String nome;
    private String endereco;
    private List<Comodo> comodos = new ArrayList<>();

    public Casa(String nome, String endereco, List<Comodo> comodos) {
        this.nome = nome;
        this.endereco = endereco;
        this.comodos = comodos;
    }

    public double totalMetrosQuadrados(){
        return comodos.stream()
                .mapToDouble(c-> (c.getComprimento()*c.getLargura()))
                .sum();
    }

    public double valorDaCasa(){
        return totalMetrosQuadrados()*valorM2;
    }

    public Comodo maiorComodo(){
        Comodo maiorComodo = null;
        double maior = 0;
        for (Comodo c: comodos){
            if(c.metrosQuadrados() > maior){
                maior = c.metrosQuadrados();
                maiorComodo = c;
            }
        }

        return maiorComodo;
    }

    public Map<String, Double> metrosQuadradosPorComodo(){
        Map<String, Double> m2PorComodo = new HashMap<>();
        for (Comodo c: comodos){
            m2PorComodo.put(c.getNome(), c.metrosQuadrados());
        }
        return m2PorComodo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}
