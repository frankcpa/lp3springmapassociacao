package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.DisciplinaService;
import com.ifms.lp3spring.Service.ProfessorService;
import com.ifms.lp3spring.model.DisciplinaModel;
import com.ifms.lp3spring.model.ProfessorModel;

import jakarta.validation.Valid;

@Controller
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private ProfessorService professorService;

    @GetMapping("salvardisciplina")
    public String getSalvar(Model model) {
        model.addAttribute("disciplina", new DisciplinaModel());
        model.addAttribute("professores", professorService.buscarTodos());
        return "disciplina/salvardisciplina";
    }

    @PostMapping("/salvardisciplina")
    public String postSalvar(@Valid @ModelAttribute("disciplina") DisciplinaModel disciplina, BindingResult result) {
        if (result.hasErrors()) {
            return "disciplina/salvardisciplina";
        }
        
        disciplinaService.salvarEatualizar(disciplina);
        return "redirect:/salvardisciplina";
    }  

    @GetMapping("/manterdisciplina")
    public ModelAndView buscar() {
        return new ModelAndView("disciplina/buscardisciplina", "disciplinas", disciplinaService.buscarTodos());
    }

    public DisciplinaService getDisciplinaService() {
        return disciplinaService;
    }

    public void setDisciplinaService(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }
}