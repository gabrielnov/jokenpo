package dev.gabriel.Jokenpo.service;

import dev.gabriel.Jokenpo.model.Jogada;
import dev.gabriel.Jokenpo.model.Partida;
import dev.gabriel.Jokenpo.model.Resultado;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PartidaFactory {

    Partida partida = new Partida();
    int vitoriasMaquina = 0;
    int vitoriasJogador = 0;
    int empates = 0;

    public Partida criarPartida(ArrayList<Jogada> listaDeJogadas) {

        salvaResultadosJogadas(listaDeJogadas);

        if(vitoriasJogador == vitoriasMaquina){
            partida.setResultado(Resultado.EMPATE);
        }
        if(vitoriasJogador > vitoriasMaquina){
            partida.setResultado(Resultado.JOGADOR);
        }
        if(vitoriasMaquina > vitoriasJogador){
            partida.setResultado(Resultado.MAQUINA);
        }

        partida.setVitoriasJogador(vitoriasJogador);
        partida.setVitoriasMaquina(vitoriasMaquina);
        partida.setEmpates(empates);

        return partida;

    }

    private void salvaResultadosJogadas(ArrayList<Jogada> listaDeJogadas) {

        for(int i =0; i < listaDeJogadas.size(); i++){
            if(listaDeJogadas.get(i).getResultado() == Resultado.JOGADOR) {
                vitoriasJogador++;
            }
            if(listaDeJogadas.get(i).getResultado() == Resultado.MAQUINA) {
                vitoriasMaquina++;
            }
            if(listaDeJogadas.get(i).getResultado() == Resultado.EMPATE){
                empates++;
            }
        }
    }

}
