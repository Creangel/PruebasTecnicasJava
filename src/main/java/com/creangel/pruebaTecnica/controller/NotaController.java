package com.creangel.pruebaTecnica.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NotaDTO>> getNota(@RequestParam String id) {
        Optional<NotaDTO> nota = notaService.obtenerNotaPorId(id);
        if (nota.isPresent()) {
            return ResponseEntity.ok(nota);
        }
    }
    

}
