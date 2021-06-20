package dev.gabriel.Jokenpo.controller;

import dev.gabriel.Jokenpo.model.Jogador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String home(Model model){
        model.addAttribute("jogador", new Jogador());
        return "home";
    }
}
