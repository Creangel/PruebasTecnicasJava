package com.creangel.pruebaTecnica.repository;

import com.creangel.pruebaTecnica.model.Nota;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> { 
    
   // Nota Notasave(Nota nota); 

    Optional<Nota> findById(Integer id);

    void deleteById(Integer id);

    List<Nota> findAll();

    boolean existsById(Integer id);
    
}
