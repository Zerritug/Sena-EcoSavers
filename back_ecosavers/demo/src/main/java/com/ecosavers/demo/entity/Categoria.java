package com.ecosavers.demo.entity;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String descripcion;

    //constructor para jpa
    public Categoria(){}

    //constructor con parametros
    public Categoria(String name){
        this.name = name;}

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}



}
