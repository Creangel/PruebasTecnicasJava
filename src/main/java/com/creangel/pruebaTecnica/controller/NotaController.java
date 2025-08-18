package com.creangel.pruebaTecnica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creangel.pruebaTecnica.dto.AlumnoDTO;
import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    NotaService notaService;
    
    @Operation(summary = "Crear una nueva nota", description = "Crea una nueva nota en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Nota creada exitosamente",
                    content = @Content(schema = @Schema(implementation = NotaDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<NotaDTO> postMethodName(@RequestBody NotaDTO notaDTO) {
        try {   
            Nota nota = convertirDTOaModelo(notaDTO);
            Nota notaCreada = notaService.crearAlumno(nota);
            NotaDTO respuesta = convertirModeloaDTO(notaCreada);        
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    
    private NotaDTO convertirModeloaDTO(Nota nota) {
        return new NotaDTO(
            nota.getId(),
            nota.getValor(),
            nota.getFechaRegistro(),
            nota.getAlumno(),
            nota.getMateria()
        );
    }
}
