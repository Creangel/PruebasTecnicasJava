package com.creangel.pruebaTecnica.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.repository.NotaRepository;

@Service
@Transactional
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public Nota crearAlumno(Nota nota) {            
        return notaRepository.save(nota);
    }
}
