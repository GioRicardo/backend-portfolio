package com.diplomado.backendportfolio.service;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.repository.ProgramadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramadorServiceImpl implements ProgramadorService{

    @Autowired
    private ProgramadorRepository programadorRepository;


    @Override
    public Programador saveProgramador(Programador programador) {
        return programadorRepository.save(programador);
    }
}
