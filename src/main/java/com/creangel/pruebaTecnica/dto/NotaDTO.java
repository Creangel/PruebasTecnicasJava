package com.creangel.pruebaTecnica.dto;

public class NotaDTO {

    private Integer id;
    private Double valor;
    private String fecha_registro;
    private Integer id_alumno;
    private Integer id_materia;

    public NotaDTO() {
    }
    
    public NotaDTO(Integer id, Double valor, String fecha_registro, Integer id_alumno, Integer id_materia) {
        this.id = id;
        this.valor = valor;
        this.fecha_registro = fecha_registro;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    public Integer getId_alumno() {
        return id_alumno;
    }
    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }
    public Integer getId_materia() {
        return id_materia;
    }
    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }
    @Override
    public String toString() {
        return "NotaDTO [id=" + id + ", valor=" + valor + ", fecha_registro=" + fecha_registro + ", id_alumno="
                + id_alumno + ", id_materia=" + id_materia + "]";
    }

}
