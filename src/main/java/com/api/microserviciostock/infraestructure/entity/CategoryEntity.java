package com.api.microserviciostock.infraestructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class CategoryEntity implements Serializable {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    @Column(name = "nombre_categoria", nullable = false)
    private String nombre_categoria;
    @Column(name = "descripcion_categoria", nullable = false)
    private String descripcion_categoria;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public CategoryEntity(int id_categoria, String nombre_categoria, String descripcion_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }

    public CategoryEntity() {
    }
}