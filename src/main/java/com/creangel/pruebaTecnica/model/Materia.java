package com.creangel.pruebaTecnica.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Materia")
public class Materia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "codigo", length = 20)
    private String codigo;
    
    @Column(name = "creditos")
    private Integer creditos;
    
    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nota> notas;
    
    // Constructors
    public Materia() {}
    
    public Materia(String nombre, String codigo, Integer creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    public List<Nota> getNotas() {
        return notas;
    }
    
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
