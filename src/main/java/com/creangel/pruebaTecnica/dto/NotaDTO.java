package com.creangel.pruebaTecnica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Materia;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para transferencia de datos de Nota")

public class NotaDTO {
    @Schema(description = "Identificador único de la nota", example = "1")
    private Integer id;
    
    @Schema(description = "Valor de la nota", example = "3.00", required = true)
    private BigDecimal valor;
 
    @Schema(description = "Fecha de registro de la nota", example = "11/05/2025", required = true)
    private LocalDate fechaRegistro;
    
    @Schema(description = "Fecha de registro de la nota", example = "11/05/2025", required = true)
    private Alumno alumno;

    @Schema(description = "Fecha de registro de la nota", example = "11/05/2025", required = true)
    private Materia materia;
    // Constructors
    public NotaDTO() {}
    
    public NotaDTO(BigDecimal valor, LocalDate fechaRegistro, Alumno alumno, Materia materia) {
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
        this.alumno = alumno;
        this.materia = materia;
    }
    
    // Getters and Setters
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
    
    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", valor=" + valor +
                ", fechaRegistro=" + fechaRegistro +
                ", alumno=" + (alumno != null ? alumno.getId() : "null") +
                ", materia=" + (materia != null ? materia.getId() : "null") +
                '}';
    }
}
