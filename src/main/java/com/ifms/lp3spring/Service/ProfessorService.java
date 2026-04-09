package com.ifms.lp3spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.lp3spring.Repository.ProfessorRepository;
import com.ifms.lp3spring.model.ProfessorModel;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public String inserir (ProfessorModel professor) {
        try {
            professorRepository.save(professor);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }
    
    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


}
