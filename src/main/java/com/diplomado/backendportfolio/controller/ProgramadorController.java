package com.diplomado.backendportfolio.controller;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.service.ProgramadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/programador")
public class ProgramadorController {
    @Autowired
    private ProgramadorService programadorService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Programador programador, @RequestParam Set<Integer> proyectoIds ){
        Programador programadorCreado = programadorService.saveProgramador(programador,proyectoIds);

        if (programadorCreado != null){
            return new ResponseEntity<>(programadorCreado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se pudo crear el programador",HttpStatus.NOT_FOUND);
        }
    }

    //Obtener todos los programadores
    @GetMapping("/getAll")
    public List<Programador> getAllProgramadores(){
        return programadorService.getAllProgramadores();
    }


    //Obtener programador por Id
    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarProgramadorPorId(@PathVariable int id) {
        Optional<Programador> programadorOptional = programadorService.obtenerProgramadorPorId(id);

        if (programadorOptional.isPresent()) {
            Programador programadorEncontrado = programadorOptional.get();
            return new ResponseEntity<>(programadorEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró un programador con el ID", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un programador por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProgramador(@PathVariable int id, @RequestBody Programador programadorActualizado) {
        Programador programadorEncontrado = programadorService.actualizarProgramador(id, programadorActualizado);

        if (programadorEncontrado != null){
            return new ResponseEntity<>(programadorEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No existe ese id",HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un programador por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProgramador(@PathVariable int id) {

        boolean validacion = programadorService.eliminarProgramador(id);

        if (validacion) {
            return new ResponseEntity<>("Se elimino el programador con exito",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe ese id",HttpStatus.NOT_FOUND);
        }
    }

}
