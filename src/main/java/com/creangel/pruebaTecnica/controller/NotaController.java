package com.creangel.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creangel.pruebaTecnica.dto.MateriaDTO;
import com.creangel.pruebaTecnica.model.Materia;
import com.creangel.pruebaTecnica.repository.NotaRepository;
import com.creangel.pruebaTecnica.service.MateriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/notas")
@CrossOrigin(origins = "*")
@Tag(name = "Notas", description = "API para gestión de notas")
public class NotaController {

    @Autowired
    private NotaService notaService;
    
    @Operation(summary = "Crear una nueva nota", description = "Crea una nueva nota en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Nota creada exitosamente",
                    content = @Content(schema = @Schema(implementation = NotaDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<MateriaDTO> crearMateria(@RequestBody NotaDTO notaDTO) {
        try {
            Nota nota = convertirDTOaModelo(notaDTO);
            Nota nota = notaService.crearNota(nota);
            NotaDTO respuesta = convertirModeloaDTO(notaCreada);
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
