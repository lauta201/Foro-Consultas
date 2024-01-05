package com.foro.consultas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Objects;


@Getter @Setter
@Entity
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate creacion;
    private String status;
    private String autor;
    private String curso;

    public Topicos() {
    }

    public Topicos(String titulo, String mensaje, String autor, String curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
    }


}
