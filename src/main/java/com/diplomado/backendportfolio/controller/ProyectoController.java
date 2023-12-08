package com.diplomado.backendportfolio.controller;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.model.Proyecto;
import com.diplomado.backendportfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @PostMapping("/add")
    public String add(@RequestBody Proyecto proyecto){
        proyectoService.saveProyecto(proyecto);
        return  "Nuevo Proyecto agregado!";
    }

    @GetMapping("/getAll")
    public List<Proyecto> getAllProyectoes(){
        return proyectoService.getAllProyectos();
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarProyectoPorId(@PathVariable int id) {
        Optional<Proyecto> proyectoOptional = proyectoService.obtenerProyectoPorId(id);

        if (proyectoOptional.isPresent()) {
            Proyecto proyectoEncontrado = proyectoOptional.get();
            return new ResponseEntity<>(proyectoEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró un proyecto con ese ID", HttpStatus.NOT_FOUND);
        }
    }



    // Actualizar un proyecto por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProyecto(@PathVariable int id, @RequestBody Proyecto proyectoActualizado) {
        Proyecto proyectoEncontrado = proyectoService.actualizarProyecto(id, proyectoActualizado);
        return proyectoEncontrado != null ?
                new ResponseEntity<>(proyectoEncontrado, HttpStatus.OK) :
                new ResponseEntity<>("no existe ese id",HttpStatus.NOT_FOUND);
    }

    // Eliminar un proyecto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable int id) {

        boolean validacion = proyectoService.eliminarProyecto(id);

        if (validacion) {
            return new ResponseEntity<>("Se elimino el proyecto con exito",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe ese id",HttpStatus.NOT_FOUND);
        }
    }

}
