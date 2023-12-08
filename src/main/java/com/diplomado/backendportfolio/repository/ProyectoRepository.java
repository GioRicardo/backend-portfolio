package com.diplomado.backendportfolio.repository;

import com.diplomado.backendportfolio.model.Programador;
import com.diplomado.backendportfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {


}
