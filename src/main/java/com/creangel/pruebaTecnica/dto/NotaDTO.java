package com.creangel.pruebaTecnica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Materia;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.ManyToOne;

public class NotaDTO {

    @Schema(description = "Identificador único de la nota", example = "1")
    private Integer id;
    
    @Schema(description = "Valor de la nota", example = "50", required = true)
    private BigDecimal valor;
   
    @Schema(description = "fecha de registro", example = "2020-12-01", required = true)
    private LocalDate fechaRegistro;


    @Schema(description = "Alumno", example = "Alumno", required = true)
    @ManyToOne
    private Alumno alumno;

    
    @Schema(description = "Alumno", example = "Alumno", required = true)
    @ManyToOne
    private Materia materia;


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

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
