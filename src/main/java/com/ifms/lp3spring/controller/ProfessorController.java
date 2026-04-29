package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ifms.lp3spring.Service.ProfessorService;
import com.ifms.lp3spring.model.ProfessorModel;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("salvarprofessor")
    public String getSalvar() {
        return "professor/salvarprofessor";
    }
    
    @PostMapping("salvarprofessor")
    public String postSalvar(ProfessorModel professor) {
        professorService.inserir(professor);
        return "professor/salvarprofessor";
    }  

    public ProfessorService getProfessorService() {
        return professorService;
    }

    public void setProfessorService(ProfessorService professorService) {
        this.professorService = professorService;
    }
}