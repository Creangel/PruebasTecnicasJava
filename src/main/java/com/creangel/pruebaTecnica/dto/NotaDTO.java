package com.creangel.pruebaTecnica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Materia;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para transferencia de datos de nota")
public class NotaDTO {

    @Schema(description = "Identificador único de la nota", example = "1")
    private Integer id;
    
    @Schema(description = "Valor de la nota", example = "4.3")
    private BigDecimal valor;
    
    @Schema(description = "Fecha de registro de la nota", example = "2000-05-15")
    private LocalDate fechaRegistro;
    
    @Schema(description = "Id del alumno", example = "1")
    private Alumno alumno;
    
    @Schema(description = "Id de la materia", example = "1")
    private Materia materia;

    public NotaDTO() {}

    public NotaDTO(Integer id, BigDecimal valor, LocalDate fechaRegistro, Alumno alumno, Materia materia) {
        this.id = id;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
