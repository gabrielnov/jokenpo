package dev.gabriel.Jokenpo.controller;

import dev.gabriel.Jokenpo.model.Jogada;
import dev.gabriel.Jokenpo.model.Jogador;
import dev.gabriel.Jokenpo.model.TipoJogada;
import dev.gabriel.Jokenpo.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class JogoController {

    @Autowired
    JogoService jogoService;

    @GetMapping("/novo")
    public String novoJogo(Model model, Jogador jogador){
        jogoService.novoJogo(jogador);
        model.addAttribute("jogada", new Jogada());
        return "jogo";
    }

    @PostMapping("/novaJogada")
    public String novaJogada(@ModelAttribute Jogada jogada, Model model){

         for(int i = 0; i<=10; i++) {
             Jogada jogadaResultado = jogoService.novaJogada(jogada.getJogadaJogador());
             System.out.println("Nova jogada");
             model.addAttribute("jogadaResultado", jogadaResultado);
         }


        //model.addAttribute("resultadoPartida", resultadoPartida);
        return "jogo";
    }




}
