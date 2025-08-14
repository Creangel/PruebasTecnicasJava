package com.creangel.pruebaTecnica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Materia;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.repository.AlumnoRepository;
import com.creangel.pruebaTecnica.repository.MateriaRepository;
import com.creangel.pruebaTecnica.repository.NotaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotaService {
    
    @Autowired NotaRepository notaRepository;


    // DELETE - Eliminar una nota para alumno
    public void eliminarNotaById(Integer id) {
        if (!notaRepository.existsById(id)) {
            throw new RuntimeException("No se encontró el la nota con ID: " + id);
        }
        notaRepository.deleteById(id);
    }
}
