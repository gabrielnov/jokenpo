package dev.gabriel.Jokenpo.controller;

import dev.gabriel.Jokenpo.model.Jogada;
import dev.gabriel.Jokenpo.model.Jogador;
import dev.gabriel.Jokenpo.model.Partida;
import dev.gabriel.Jokenpo.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class JogoController {

    @Autowired
    JogoService jogoService;

    @PostMapping("/novo")
    public String novoJogo(@Valid Jogador jogador, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "home";
        }

        jogoService.novoJogo(jogador);
        model.addAttribute("jogada", new Jogada());
        return "jogo";
    }

    @PostMapping("/novaJogada")
    public String novaJogada(@ModelAttribute Jogada jogada, Model model, RedirectAttributes redirectAttributes){

        if(jogoService.temProximaJogada()) {
            Jogada jogadaResultado = jogoService.novaJogada(jogada.getJogadaJogador());
            model.addAttribute("jogadaResultado", jogadaResultado);
            return "jogo";
        }

        Partida partida = jogoService.getResultadoPartida();

        redirectAttributes.addFlashAttribute("partida", partida);
        return "redirect:/resultado";
    }

    @GetMapping("/resultado")
    public String resultado(@ModelAttribute Partida partida, Model model){

        model.addAttribute("partida", partida);
        return "resultado";
    }




}
