package dev.gabriel.Jokenpo.service;

import dev.gabriel.Jokenpo.model.*;
import dev.gabriel.Jokenpo.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JogoService {

    Jogador jogador = new Jogador();
    public void novoJogo(Jogador jogadorRecebido) {
        jogador.setNomeJogador(jogadorRecebido.getNomeJogador());
    }

    ArrayList<Jogada> listaDeJogadas = new ArrayList<>();

    public Jogada novaJogada(TipoJogada jogadaJogador) {

        TipoJogada jogadaMaquina = TipoJogada.getNovaJogada();
        Resultado resultado = Resultado.quemVenceu(jogadaJogador, jogadaMaquina);

        Jogada jogadaResultado = new Jogada(jogadaJogador, jogadaMaquina, resultado);
        listaDeJogadas.add(jogadaResultado);

        return jogadaResultado;
    }

    @Autowired
    PartidaRepository partidaRepository;

    public void salvarJogo(Resultado resultado, Jogador jogador){
        String nomeJogador = jogador.getNomeJogador();
        Partida partida = new Partida(resultado, nomeJogador);
        partidaRepository.save(partida);
    }
}
