package com.creangel.pruebaTecnica.controller;

import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
@Tag(name = "Notas", description = "API para gestión de notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotaById(@PathVariable Integer id) {
        try {
            notaService.eliminarNotaById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Métodos de conversión    
    private Nota convertirDTOaModelo(NotaDTO dto) {
        Nota Nota = new Nota();
        return Nota;
    }
    
    private NotaDTO convertirModeloaDTO(Nota nota) {
        return new NotaDTO(
            nota.getId(),
            nota.getValor(),
            nota.getAlumno(),
            nota.getMateria()
        );
    }

}
