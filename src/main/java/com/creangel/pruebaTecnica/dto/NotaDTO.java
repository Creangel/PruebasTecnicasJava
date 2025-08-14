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
    
    @Schema(description = "Valor de la nota", example = "3.4", required = true)
    private BigDecimal valor;
    
    @Schema(description = "Fecha de registro de la nota", required = true)
    private LocalDate fechaRegistro;
    
    @Schema(description = "Id del alumno de la nota", example = "1", required = true)
    private Integer alumno;
    
    @Schema(description = "Id de la máteria de la nota", example = "4", required = true)
    private Integer materia;

    
    // Constructors
    public NotaDTO(Integer integer, BigDecimal bigDecimal, Alumno alumno, Materia materia) {}
    
    public NotaDTO(Integer id, BigDecimal valor, LocalDate fechaRegistro, Integer alumno, Integer materia) {
        this.id = id;
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

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }

    public Integer getMateria() {
        return materia;
    }

    public void setMateria(Integer materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "NotaDTO{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", alumno='" + alumno + '\'' +
                ", materia=" + materia +
                '}';
    }
}
