package dev.gabriel.Jokenpo.service;

import dev.gabriel.Jokenpo.model.Jogada;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    public void iniciarJogo(String jogador) {
        System.out.println(jogador);
    }

    public void novaJogada(Jogada jogada) {
        System.out.println(jogada.getTipoJogada());
    }
}
