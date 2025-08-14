package com.creangel.pruebaTecnica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creangel.pruebaTecnica.dto.AlumnoDTO;
import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Nota;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/notas")
public class NotaController {
    
    @PostMapping
    public String postMethodName(@RequestBody NotaDTO notaDTO) {
        try {   
            Nota nota = convertirDTOaModelo(notaDTO);
            Nota notaCreada = notaService.crearAlumno(nota);
            AlumnoDTO respuesta = convertirModeloaDTO(notaCreada);        
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return entity;
    }

    private Nota convertirDTOaModelo(NotaDTO dto) {
        Nota nota = new Nota();
        nota.setId(dto.getId());
        nota.setValor(dto.getValor());
        nota.setMateria(dto.getMateria());
        nota.setAlumno(dto.getAlumno());
        nota.setFechaRegistro(dto.getFechaRegistro());
        return nota;
    }
    
}
