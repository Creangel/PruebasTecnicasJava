package com.creangel.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creangel.pruebaTecnica.model.Alumno;

@Repository
public interface NotaRepository extends JpaRepository<Alumno, Integer>  {
    
}
