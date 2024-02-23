package com.hrevillafernandez.Evaluacion02.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula")
    private Integer idPelicula;
    private String nombre;
    private String director;
    private LocalDate fechaStreno ;
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;
}
