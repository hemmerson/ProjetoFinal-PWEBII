package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Medico;
import br.edu.ifto.projeto_final.model.entity.Paciente;
import br.edu.ifto.projeto_final.model.entity.Usuario;
import br.edu.ifto.projeto_final.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    PacienteRepository repository;

    @GetMapping("/form")
    public ModelAndView form(Paciente paciente, ModelMap model, Usuario usuario) {
        model.addAttribute("pessoa", paciente);
        model.addAttribute("usuario", usuario);
        return new ModelAndView("/pessoa/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoa", repository.pacientes());
        return new ModelAndView("/pessoa/list", model);
    }

    @GetMapping("/consultas/{id}")
    public ModelAndView listarConsultas(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("consultas", repository.paciente(id).getConsultas());
        model.addAttribute("paciente", repository.paciente(id));
        return new ModelAndView("/consulta/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("pessoa") @Valid Paciente paciente, @ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors())
             return new ModelAndView("/pessoa/form");
        repository.save(paciente, usuario);
        return new ModelAndView("redirect:/paciente/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/paciente/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.paciente(id));
        return new ModelAndView("/pessoa/form", model);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.paciente(id));
        return new ModelAndView("/pessoa/detalhes", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("pessoa") @Valid Paciente paciente, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("/pessoa/form");
        repository.update(paciente);
        return new ModelAndView("redirect:/paciente/list");
    }
}
