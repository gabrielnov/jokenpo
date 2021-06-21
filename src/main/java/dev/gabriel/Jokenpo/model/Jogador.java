package dev.gabriel.Jokenpo.model;

import javax.validation.constraints.NotEmpty;

public class Jogador {

    @NotEmpty
    private String nomeJogador;

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
}
