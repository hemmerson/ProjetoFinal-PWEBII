package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.repository.MedicoRepository;
import br.edu.ifto.projeto_final.model.entity.Medico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Transactional
@Controller
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    MedicoRepository repository;

    @GetMapping("/form")
    public String form(Medico medico) {
        return "/medico/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("medicos", repository.medicos());
        return new ModelAndView("/medico/list", model);
    }

    @GetMapping("/consultas/{id}")
    public ModelAndView listarConsultas(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("consultas", repository.medico(id).getConsultas());
        model.addAttribute("medico", repository.medico(id));
        return new ModelAndView("/consulta/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Medico medico) {
        repository.save(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/medicos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("medico", repository.medico(id));
        return new ModelAndView("/medico/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Medico medico) {
        repository.update(medico);
        return new ModelAndView("redirect:/medicos/list");
    }
}
