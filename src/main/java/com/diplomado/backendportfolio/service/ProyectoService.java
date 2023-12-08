package com.diplomado.backendportfolio.service;

import com.diplomado.backendportfolio.model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {

    public Proyecto saveProyecto (Proyecto proyecto);

    public List<Proyecto> getAllProyectos();

    public Optional<Proyecto> obtenerProyectoPorId(int id);

    public Proyecto actualizarProyecto(int id, Proyecto proyectoActualizado);

    public boolean eliminarProyecto(int id);

}
