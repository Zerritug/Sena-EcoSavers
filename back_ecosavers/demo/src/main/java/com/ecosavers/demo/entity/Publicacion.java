package com.ecosavers.demo.entity;
import jakarta.persistence.*;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.entity.Categoria;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fecha;

    //dependencia de categoria
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "Categoria",nullable = false)
    private Categoria categoria;
    //dependencia de usuario

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Usuario", nullable = false)
    private Usuario usuario;




    public  Publicacion(){}

    public Long getId(){return id;}
    public void setId (Long id) {this.id = id;}

    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}

    public String getContenido(){return contenido;}
    public void setContenido(String contenido){this.contenido = contenido;}

    public LocalDateTime getFecha(){return fecha;}
    public void setFecha (LocalDateTime fecha){this.fecha = fecha;}

    public Usuario usuario(){return usuario;}
    public void setUsuario(Usuario usuarios){this.usuario = usuarios;}

    public Categoria categoria(){return categoria;}
    public void setCategoria(Categoria categorias){this.categoria = categoria;}
}
