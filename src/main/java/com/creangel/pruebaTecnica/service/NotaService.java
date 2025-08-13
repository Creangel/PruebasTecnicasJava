package com.creangel.pruebaTecnica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.repository.NotaRepository;


public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    //Create - Crea una nota
    public Nota crearNota( Nota nota ){
        return notaRepository.save(nota);
    }

    @Transactional(readOnly = true)
    public Optional<Nota> obtenerNotaPorId(String id){
        return notaRepository.findById(Integer.parseInt(id));
    }
}
