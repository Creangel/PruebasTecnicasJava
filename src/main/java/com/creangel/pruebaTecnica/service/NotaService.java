package com.creangel.pruebaTecnica.service;

import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.repository.NotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;
    
    @Transactional(readOnly = true)
    public Optional<Nota> obtenerNotaPorId(Integer id) {
        return notaRepository.findById(id);
    }
    
}
