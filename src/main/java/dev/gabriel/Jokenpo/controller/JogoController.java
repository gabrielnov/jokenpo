package dev.gabriel.Jokenpo.controller;

import dev.gabriel.Jokenpo.model.Jogada;
import dev.gabriel.Jokenpo.model.TipoJogada;
import dev.gabriel.Jokenpo.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    JogoService jogoService;


    @GetMapping("/novo")
    public String novoJogo(Model model){
        System.out.println("!!!!!!!!!!!!!!!  executando método /novo !!!!!!!!!!!!!!!!!!!!");

        model.addAttribute("jogada", new Jogada());
        return "jogo";
    }

    @PostMapping("/novaJogada")
    public String novaJogada(@ModelAttribute Jogada jogada, Model model){

        System.out.println("executando método /novaJogada ");

        Jogada jogadaResultado = jogoService.novaJogada(jogada);

        model.addAttribute("jogadaResultado", jogadaResultado);
        return "jogo";
    }



}
