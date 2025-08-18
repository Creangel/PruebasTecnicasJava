package com.creangel.pruebaTecnica.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;


@RestController
@RequestMapping("/api/notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> getNota(@PathVariable String id) {
        Optional<Nota> nota = notaService.obtenerNotaPorId(id);
        if (nota.isPresent()) {
            NotaDTO respuesta = convertirModeloaDTO(nota.get());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    private NotaDTO convertirModeloaDTO(Nota nota) {
        return new NotaDTO(
            nota.getId(),
            nota.getValor().doubleValue(),
            nota.getFechaRegistro().toString(),
            nota.getAlumno().getId(),
            nota.getMateria().getId()
        );
    }
}
