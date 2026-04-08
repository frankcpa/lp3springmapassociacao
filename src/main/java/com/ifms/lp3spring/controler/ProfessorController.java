package com.ifms.lp3spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

    @GetMapping("salvarprofessor")
    public String getSalvar() {
        return "professor/salvarprofessor";
    }
   
}