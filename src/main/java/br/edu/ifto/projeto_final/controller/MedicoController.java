package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Pessoa;
import br.edu.ifto.projeto_final.model.repository.MedicoRepository;
import br.edu.ifto.projeto_final.model.entity.Medico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Transactional
@Controller
@RequestMapping("medico")
public class MedicoController {
    @Autowired
    MedicoRepository repository;

    @GetMapping("/form")
    public ModelAndView form(Medico medico, ModelMap model) {
        model.addAttribute("pessoa", medico);
        return new ModelAndView("/pessoa/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoa", repository.medicos());
        return new ModelAndView("/pessoa/list", model);
    }

    @GetMapping("/consultas/{id}")
    public ModelAndView listarConsultas(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("consultas", repository.medico(id).getConsultas());
        model.addAttribute("medico", repository.medico(id));
        return new ModelAndView("/consulta/list", model);
    }

    @GetMapping("/consultas")
    public ModelAndView listarConsultasPaciente(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("consultas", repository.medico(auth.getName()).getConsultas());
        model.addAttribute("medico", repository.medico(auth.getName()));
        return new ModelAndView("/consulta/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("pessoa") @Valid Medico medico, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("/pessoa/form");
        repository.save(medico);
        return new ModelAndView("redirect:/medico/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/medico/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.medico(id));
        return new ModelAndView("/pessoa/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("pessoa") @Valid Medico medico,BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("/pessoa/form");
        repository.update(medico);
        return new ModelAndView("redirect:/medico/list");
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.medico(id));
        return new ModelAndView("/pessoa/detalhes", model);
    }

    @GetMapping("/details")
    public ModelAndView details(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("pessoa", repository.medico(auth.getName()));
        return new ModelAndView("/pessoa/detalhes", model);
    }
}
