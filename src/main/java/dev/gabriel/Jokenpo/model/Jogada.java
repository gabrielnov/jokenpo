package dev.gabriel.Jokenpo.model;

public class Jogada {

    private TipoJogada jogadaJogador;
    private TipoJogada jogadaMaquina;
    private Resultado resultado;
    private Jogador jogador;

    public Jogada(TipoJogada jogadaJogador, TipoJogada jogadaMaquina, Resultado resultado) {
        this.jogadaJogador = jogadaJogador;
        this.jogadaMaquina = jogadaMaquina;
        this.resultado = resultado;
    }

    public Jogada(){}

    public TipoJogada getJogadaJogador() {
        return jogadaJogador;
    }

    public void setJogadaJogador(TipoJogada jogadaJogador) {
        this.jogadaJogador = jogadaJogador;
    }

    public TipoJogada getJogadaMaquina() {
        return jogadaMaquina;
    }

    public void setJogadaMaquina(TipoJogada jogadaMaquina) {
        this.jogadaMaquina = jogadaMaquina;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
