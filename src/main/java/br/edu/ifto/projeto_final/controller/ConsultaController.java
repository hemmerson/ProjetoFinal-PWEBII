package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Consulta;
import br.edu.ifto.projeto_final.model.repository.ConsultaRepository;
import br.edu.ifto.projeto_final.model.repository.MedicoRepository;
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
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    ConsultaRepository repository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/form")
    public ModelAndView form(Consulta consulta, ModelMap model) {
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        model.addAttribute("medicos", medicoRepository.medicos());
        return new ModelAndView("/consulta/form", model);
    }

    @GetMapping("/form2")
    public ModelAndView form2(Consulta consulta, ModelMap model) {
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        model.addAttribute("medicos", medicoRepository.medicos());
        return new ModelAndView("/consulta/form2", model);
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("consultas", repository.consultas());
        model.addAttribute("totalConsultas", repository.totalConsultas());
        return new ModelAndView("/consulta/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Consulta consulta) {
        repository.save(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/consultas/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pacientes", repository.consulta(id).getPaciente());
        model.addAttribute("medicos", repository.consulta(id).getMedico());
        model.addAttribute("consulta", repository.consulta(id));
        return new ModelAndView("/consulta/form", model);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consulta", repository.consulta(id));
        return new ModelAndView("/consulta/details", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Consulta consulta) {
        repository.update(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }
}
