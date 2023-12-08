package com.diplomado.backendportfolio.service;

import com.diplomado.backendportfolio.model.Proyecto;
import com.diplomado.backendportfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;


    @Override
    public Proyecto saveProyecto(Proyecto proyecto) {

        return proyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }



    public Optional<Proyecto> obtenerProyectoPorId(int id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto actualizarProyecto(int id, Proyecto proyectoActualizado) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if (proyecto.isPresent()) {
            Proyecto proyectoExistente = proyecto.get();
            proyectoExistente.setNombre(proyectoActualizado.getNombre());
            proyectoExistente.setDescripcion(proyectoActualizado.getDescripcion());
            proyectoExistente.setImagen(proyectoActualizado.getImagen());
            proyectoExistente.setLinkgithub(proyectoActualizado.getLinkgithub());
            proyectoExistente.setFecha(proyectoActualizado.getFecha());
            proyectoExistente.setLenguaje(proyectoActualizado.getLenguaje());

            return proyectoRepository.save(proyectoExistente);
        }
        return null;
    }

    public boolean eliminarProyecto(int id) {

        Optional<Proyecto> proyectoEncontrado = obtenerProyectoPorId(id);

        if (proyectoEncontrado.isPresent()){
            proyectoRepository.deleteById(id);
            return true;
        } else{
            return false;
        }

    }
}

