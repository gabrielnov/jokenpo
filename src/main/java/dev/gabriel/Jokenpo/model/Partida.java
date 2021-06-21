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
    private int vitoriasJogador;
    private int vitoriasMaquina;
    private int empates;

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

    public int getVitoriasJogador() {
        return vitoriasJogador;
    }

    public void setVitoriasJogador(int vitoriasJogador) {
        this.vitoriasJogador = vitoriasJogador;
    }

    public int getVitoriasMaquina() {
        return vitoriasMaquina;
    }

    public void setVitoriasMaquina(int vitoriasMaquina) {
        this.vitoriasMaquina = vitoriasMaquina;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
}
