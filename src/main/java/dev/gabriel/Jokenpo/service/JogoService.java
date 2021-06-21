package dev.gabriel.Jokenpo.service;

import dev.gabriel.Jokenpo.model.*;
import dev.gabriel.Jokenpo.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JogoService {

    Jogador jogador = new Jogador();
    int contador;

    public void novoJogo(Jogador jogadorRecebido) {
        contador = 0;
        jogador.setNomeJogador(jogadorRecebido.getNomeJogador());
    }

    ArrayList<Jogada> listaDeJogadas = new ArrayList<>();

    public Jogada novaJogada(TipoJogada jogadaJogador) {
        TipoJogada jogadaMaquina = TipoJogada.getNovaJogada();
        Resultado resultado = Resultado.quemVenceu(jogadaJogador, jogadaMaquina);

        Jogada jogadaResultado = new Jogada(jogadaJogador, jogadaMaquina, resultado);
        listaDeJogadas.add(jogadaResultado);

        contador++;
        return jogadaResultado;
    }

    public boolean temProximaJogada() {
        if(contador==10){
            salvarPartida(jogador.getNomeJogador());
            return false;
        }
        return true;
    }

    @Autowired
    PartidaRepository partidaRepository;

    @Autowired
    PartidaFactory partidaFactory;

    Partida partida = new Partida();

    private void salvarPartida(String nomeJogador){
        Partida partidaCriada = partidaFactory.criarPartida(listaDeJogadas);

        partida.setVitoriasJogador(partidaCriada.getVitoriasJogador());
        partida.setVitoriasMaquina(partidaCriada.getVitoriasMaquina());
        partida.setEmpates(partidaCriada.getEmpates());
        partida.setResultado(partidaCriada.getResultado());
        partida.setNomeJogador(nomeJogador);

        partidaRepository.save(partida);

        System.out.println("Salvando partida...");
    }

    public Partida getResultadoPartida(){
        return partida;
    }


}
