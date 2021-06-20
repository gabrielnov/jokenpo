package dev.gabriel.Jokenpo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partida {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Resultado resultado;
    private String nomeJogador;

    public Partida(Resultado resultado, String nomeJogador) {
        this.resultado = resultado;
        this.nomeJogador = nomeJogador;
    }

    public Long getId() {
        return id;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
}
