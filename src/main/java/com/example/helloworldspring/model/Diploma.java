package com.example.helloworldspring.model;

public class Diploma {

    private String nomeAluno;
    private String mensagem;
    private double media;

    public Diploma(String nomeAluno, String mensagem, double media) {
        this.nomeAluno = nomeAluno;
        this.mensagem = mensagem;
        this.media = media;
    }

    public String getAluno() {
        return nomeAluno;
    }

    public void setAluno(String aluno) {
        this.nomeAluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
