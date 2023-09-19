package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Paciente;
import br.edu.ifto.projeto_final.model.repository.PacienteRepository;
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
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    PacienteRepository repository;

    @GetMapping("/form")
    public String form(Paciente paciente) {
        return "/paciente/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pacientes", repository.pacientes());
        return new ModelAndView("/paciente/list", model);
    }

    @GetMapping("/consultas/{id}")
    public ModelAndView listarConsultas(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("consultas", repository.paciente(id).getConsultas());
        model.addAttribute("paciente", repository.paciente(id));
        return new ModelAndView("/consulta/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Paciente paciente) {
        repository.save(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pacientes/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("paciente", repository.paciente(id));
        return new ModelAndView("/paciente/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Paciente paciente) {
        repository.update(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }
}
