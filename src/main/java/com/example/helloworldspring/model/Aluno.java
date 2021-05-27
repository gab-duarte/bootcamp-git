package com.example.helloworldspring.model;

import java.util.List;
import java.util.OptionalDouble;

public class Aluno {

    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public double mediaAluno(){
        return disciplinas.stream()
                .mapToDouble(Disciplina::getNota)
                .average()
                .orElse(0.0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
