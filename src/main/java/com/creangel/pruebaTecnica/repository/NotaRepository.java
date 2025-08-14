package com.creangel.pruebaTecnica.repository;

import com.creangel.pruebaTecnica.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    // Obtener todas la notas generales
    List<Nota> findAll();

    // Obtener nota por estudiante
    List<Nota> findByAlumno(Integer alumnoId);

    // Crear nota para estudiante
    Nota crearNotaByAlumno(Integer alumnoId, Nota nota);

    // Eliminar nota por 
    void deleteById(Integer id);
}
