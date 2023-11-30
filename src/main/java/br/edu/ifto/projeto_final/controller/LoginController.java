package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Medico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}


