package com.diplomado.backendportfolio.service;

import com.diplomado.backendportfolio.model.Programador;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProgramadorService {

    public Programador saveProgramador (Programador programador, Set<Integer> proyectoIds);

    public List<Programador> getAllProgramadores();

    public Optional<Programador> obtenerProgramadorPorId(int id);

    public Programador actualizarProgramador(int id, Programador programadorActualizado);

    public boolean eliminarProgramador(int id);

}
