package com.hrevillafernandez.Evaluacion02.service;

import com.hrevillafernandez.Evaluacion02.models.Pelicula;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {
    Pelicula createPelicula(Pelicula pelicula);
    List<Pelicula> findAll();
    Pelicula updatePelicula(Pelicula pelicula);
    boolean eliminarPelicula(Integer idPelicula);

    Optional<Pelicula> findById(Integer id);
}
