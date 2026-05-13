package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.ProfessorService;
import com.ifms.lp3spring.model.ProfessorModel;

import jakarta.validation.Valid;


@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/salvarprofessor")
    public ModelAndView getSalvar() {
        return new ModelAndView("professor/salvarprofessor", "professor", new ProfessorModel());
    }
    
    @PostMapping("/salvarprofessor")
    public String postSalvar(@Valid @ModelAttribute("professor") ProfessorModel professor, BindingResult result) {
        if (result.hasErrors()) {
            return "professor/salvarprofessor";
        }
        
        professorService.salvarEatualizar(professor);
        return "redirect:/salvarprofessor";
    }  

    @GetMapping("/manterprofessor")
    public ModelAndView buscar() {
        return new ModelAndView("professor/buscarprofessor", "professores", professorService.buscarTodos());
    }

    @GetMapping("/removerprofessor/{id}")
    public String deletar(@ModelAttribute("id") Long id) {
        professorService.remover(id);
        return "redirect:/manterprofessor";
    }

    @GetMapping("/editarprofessor/{id}")
    public ModelAndView buscarPorId(@ModelAttribute("id") Long id) {
        ProfessorModel professor = professorService.buscarPorId(id);
        if (professor==null) {
            professor = new ProfessorModel();
        }
        return new ModelAndView("/professor/editarprofessor", "professor", professor);
    }

    @PostMapping("/editarprofessor")
    public String postEditar(@Valid @ModelAttribute("professor") ProfessorModel professor, BindingResult result) {
        if (result.hasErrors()) {
            return "professor/editarprofessor";
        }
        
        professorService.salvarEatualizar(professor);
        return "redirect:/manterprofessor";
    }

    public ProfessorService getProfessorService() {
        return professorService;
    }

    public void setProfessorService(ProfessorService professorService) {
        this.professorService = professorService;
    }
}