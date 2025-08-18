package com.creangel.pruebaTecnica.service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.repository.NotaRepository;

import org.springframework.stereotype.Service;




@Service
@Transactional
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Optional<Nota> obtenerNotaPorId(String id){
        return notaRepository.findById(Integer.valueOf(id));
    }
    
}
