package dev.gabriel.Jokenpo.service;

import dev.gabriel.Jokenpo.model.Jogada;
import dev.gabriel.Jokenpo.model.Resultado;
import dev.gabriel.Jokenpo.model.TipoJogada;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JogoService {

    ArrayList<Jogada> listaJogadas = new ArrayList<>();

    // TODO só to usando um atributo da Jogada, talvez passar só ele?
    public Jogada novaJogada(Jogada novaJogada) {
        TipoJogada jogadaMaquina;
        TipoJogada jogadaJogador;
        Resultado resultado;

        jogadaMaquina = TipoJogada.getNovaJogada();
        jogadaJogador = novaJogada.getJogadaJogador();
        resultado = jogadorVenceu(jogadaJogador, jogadaMaquina);

        // TODO renomear essa instancia
        Jogada jogadaResultado = new Jogada(jogadaJogador, jogadaMaquina, resultado);
        listaJogadas.add(jogadaResultado);
        return jogadaResultado;
    }

    // TODO extrair para uma classe?
    public Resultado jogadorVenceu(TipoJogada jogadaJogador, TipoJogada jogadaMaquina){

        if((jogadaJogador == TipoJogada.PEDRA) && (jogadaMaquina == TipoJogada.TESOURA)){
            return Resultado.JOGADOR;
        }
        if((jogadaJogador == TipoJogada.TESOURA) && (jogadaMaquina == TipoJogada.PAPEL)){
            return Resultado.JOGADOR;
        }
        if((jogadaJogador == TipoJogada.PAPEL) && (jogadaMaquina == TipoJogada.PEDRA)){
            return Resultado.JOGADOR;
        }
        if((jogadaJogador == jogadaMaquina)){ // TODO colocar em primeiro
            return Resultado.EMPATE;
        }

        return Resultado.MAQUINA;

    }
}
