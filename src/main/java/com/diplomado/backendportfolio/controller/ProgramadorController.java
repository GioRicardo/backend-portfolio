package com.diplomado.backendportfolio.controller;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.service.ProgramadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programador")
public class ProgramadorController {
    @Autowired
    private ProgramadorService programadorService;

    @PostMapping("/add")
    public String add(@RequestBody Programador programador){
        programadorService.saveProgramador(programador);
        return  "Nuevo Programador agregado!";
    }

}
