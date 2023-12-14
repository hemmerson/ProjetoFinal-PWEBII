package br.edu.ifto.projeto_final.controller;

import br.edu.ifto.projeto_final.model.entity.Agendamento;
import br.edu.ifto.projeto_final.model.entity.Consulta;
import br.edu.ifto.projeto_final.model.entity.Horario;
import br.edu.ifto.projeto_final.model.entity.Medico;
import br.edu.ifto.projeto_final.model.repository.AgendamentoRepository;
import br.edu.ifto.projeto_final.model.repository.ConsultaRepository;
import br.edu.ifto.projeto_final.model.repository.MedicoRepository;
import br.edu.ifto.projeto_final.model.repository.PacienteRepository;
import br.edu.ifto.projeto_final.model.validation.groups.Insert;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Transactional
@Controller
@RequestMapping("agendamento")
public class AgendamentoController {
    @Autowired
    AgendamentoRepository repository;

    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/disponibilidade")
    public ModelAndView form(Agendamento agendamento, ModelMap model) {
        model.addAttribute("horarios", agendamento.getHorarios());
        model.addAttribute("agendamento", agendamento);
        return new ModelAndView("/agendamento/disponibilidade", model);
    }

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@RequestParam("dataSeleciona") String dataSelecionada,
                             @RequestParam("horariosSelecionados")List<String> horariosSelecionados) {
        List<Horario> horarios = new ArrayList<>();
        for (String horario : horariosSelecionados){
            Horario h = new Horario();
            h.setHorario(LocalTime.parse(horario));
            horarios.add(h);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Medico m = medicoRepository.medico(auth.getName());

        Agendamento agendamento = new Agendamento();
        agendamento.setData(LocalDate.parse(dataSelecionada));
        agendamento.setHorarios(horarios);
        agendamento.setMedico(m);
        repository.save(agendamento);
        return new ModelAndView("redirect:/consultas/list");
    }

//    /**
//     * @param id
//     * @return
//     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
//     */
//    @GetMapping("/remove/{id}")
//    public ModelAndView remove(@PathVariable("id") Long id) {
//        repository.remove(id);
//        return new ModelAndView("redirect:/consultas/list");
//    }
//
//    /**
//     * @param id
//     * @return
//     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
//     */
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
//        model.addAttribute("pacientes", repository.consulta(id).getPaciente());
//        model.addAttribute("medicos", repository.consulta(id).getMedico());
//        model.addAttribute("consulta", repository.consulta(id));
//        return new ModelAndView("/consulta/form", model);
//    }
//
//    @GetMapping("/details/{id}")
//    public ModelAndView details(@PathVariable("id") Long id, ModelMap model) {
//        model.addAttribute("consulta", repository.consulta(id));
//        return new ModelAndView("/consulta/details", model);
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(@Validated(Insert.class) Consulta consulta, BindingResult result, ModelMap model) {
//        if (result.hasErrors()){
//            model.addAttribute("pacientes", pacienteRepository.pacientes());
//            model.addAttribute("medicos", medicoRepository.medicos());
//            return new ModelAndView("/consulta/form", model);
//        }
//        repository.update(consulta);
//        return new ModelAndView("redirect:/consultas/list");
//    }
}
