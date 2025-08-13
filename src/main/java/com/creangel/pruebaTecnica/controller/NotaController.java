package com.creangel.pruebaTecnica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creangel.pruebaTecnica.dto.AlumnoDTO;
import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;

import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtenerNotaPorId(@Parameter(description = "ID de la nota") @PathVariable String id) {
        Optional<Nota> nota = notaService.obtenerNotaPorId(id);
        if(nota.isPresent()){
            NotaDTO respuesta = convertirModeloaDTO(nota.get());
            return ResponseEntity.ok(respuesta);
         } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Nota convertirModeloaDTO(Nota nota) {
        return new NotaDTO(
            nota.getId(),
            nota.getValor(),
            nota.getFechaRegistro(),
            nota.getAlumno(),
            nota.getMateria()
        );
    }
    
}
