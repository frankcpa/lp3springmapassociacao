package com.ifms.lp3spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifms.lp3spring.Repository.DisciplinaRepository;
import com.ifms.lp3spring.model.DisciplinaModel;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public String salvarEatualizar (DisciplinaModel disciplina) {
        try {
            disciplinaRepository.save(disciplina);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }

    public List<DisciplinaModel> buscarTodos() {
        return disciplinaRepository.findAll();
    }
    
    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }


}
