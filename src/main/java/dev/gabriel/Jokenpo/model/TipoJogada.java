package dev.gabriel.Jokenpo.model;

import java.util.Random;

public enum TipoJogada {
    PEDRA,
    PAPEL,
    TESOURA;

    public static TipoJogada getNovaJogada() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
