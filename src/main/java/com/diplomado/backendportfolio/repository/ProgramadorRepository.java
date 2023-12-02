package com.diplomado.backendportfolio.repository;

import com.diplomado.backendportfolio.model.Programador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorRepository extends JpaRepository<Programador,Integer> {


}
