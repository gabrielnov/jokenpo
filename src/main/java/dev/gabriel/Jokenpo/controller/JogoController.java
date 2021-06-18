package dev.gabriel.Jokenpo.controller;

import dev.gabriel.Jokenpo.model.Jogada;
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
        System.out.print("!!!!!!!!!!!!!!!  executando método /novo !!!!!!!!!!!!!!!!!!!!\n");

        model.addAttribute("jogada", new Jogada());
        return "jogo";
    }

    @PostMapping("/novaJogada")
    public String novaJogada(@ModelAttribute Jogada jogada, Model model){

        System.out.print("executando método /novaJogada \n");
        jogoService.novaJogada(jogada);

        model.addAttribute("jogada", jogada);
        return "jogo";
    }



}
