package dev.gabriel.Jokenpo.model;

public enum Resultado {
    JOGADOR,
    MAQUINA,
    EMPATE;

    public static Resultado quemVenceu(TipoJogada jogadaJogador, TipoJogada jogadaMaquina){

        if((jogadaJogador == jogadaMaquina)){
            return Resultado.EMPATE;
        }
        if((jogadaJogador == TipoJogada.PEDRA) && (jogadaMaquina == TipoJogada.TESOURA)){
            return Resultado.JOGADOR;
        }
        if((jogadaJogador == TipoJogada.TESOURA) && (jogadaMaquina == TipoJogada.PAPEL)){
            return Resultado.JOGADOR;
        }
        if((jogadaJogador == TipoJogada.PAPEL) && (jogadaMaquina == TipoJogada.PEDRA)){
            return Resultado.JOGADOR;
        }

        return Resultado.MAQUINA;
    }


}
