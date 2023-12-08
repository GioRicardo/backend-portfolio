package com.diplomado.backendportfolio.service;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.model.Proyecto;
import com.diplomado.backendportfolio.repository.ProgramadorRepository;
import com.diplomado.backendportfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProgramadorServiceImpl implements ProgramadorService{

    @Autowired
    private ProgramadorRepository programadorRepository;
    @Autowired
    private ProyectoRepository proyectoRepository;


    @Override
    public Programador saveProgramador(Programador programador, Set<Integer> proyectoIds) {

            Set<Proyecto> proyectos = programador.getProyectos();
            programador.setProyectos(null); // Evita bucles infinitos en la serialización
            Programador nuevoProgramador = programadorRepository.save(programador);

            if (proyectoIds != null) {
                for (Integer proyectoId : proyectoIds) {
                    // Buscar el proyecto por ID recibido como int.
                    Optional<Proyecto> proyectoExistente = proyectoRepository.findById(proyectoId);

                    if (proyectoExistente.isPresent()) {
                        // Asociar el nuevo programador al proyecto existente
                        proyectoExistente.get().getProgramadores().add(nuevoProgramador);
                        proyectoRepository.save(proyectoExistente.get());
                    }
                }
            }
        return nuevoProgramador;
    }

    @Override
    public List<Programador> getAllProgramadores() {
        return programadorRepository.findAll();
    }



    public Optional<Programador> obtenerProgramadorPorId(int id) {
        return programadorRepository.findById(id);
    }

    public Programador actualizarProgramador(int id, Programador programadorActualizado) {
        Optional<Programador> programador = programadorRepository.findById(id);
        if (programador.isPresent()) {
            Programador programadorExistente = programador.get();
            programadorExistente.setNombre(programadorActualizado.getNombre());
            programadorExistente.setEmail(programadorActualizado.getEmail());
            programadorExistente.setTelefono(programadorActualizado.getTelefono());
            programadorExistente.setDescripcion(programadorActualizado.getDescripcion());
            programadorExistente.setImagen(programadorActualizado.getImagen());

            return programadorRepository.save(programadorExistente);
        }
        return null;
    }

    public boolean eliminarProgramador(int id) {

        Optional<Programador> programadorEncontrado = obtenerProgramadorPorId(id);

        if (programadorEncontrado.isPresent()){
            programadorRepository.deleteById(id);
            return true;
        } else{
            return false;
        }

    }
}

