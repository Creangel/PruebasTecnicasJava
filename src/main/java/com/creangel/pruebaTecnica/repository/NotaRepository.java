package com.creangel.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creangel.pruebaTecnica.model.Nota;

import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    Optional<Nota> findById(Integer id);

}
