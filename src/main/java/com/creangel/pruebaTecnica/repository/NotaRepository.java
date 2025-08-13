package com.creangel.pruebaTecnica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creangel.pruebaTecnica.model.Materia;
import com.creangel.pruebaTecnica.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    //Verificar si existe por id
    boolean existsById(Integer id);
}
