package com.hrevillafernandez.Evaluacion02.service;

import com.hrevillafernandez.Evaluacion02.models.Genero;

import java.util.List;
import java.util.Optional;

public interface IGeneroService {
    Genero createGenero(Genero genero);
    Genero updateGenero(Genero genero);
    Optional<Genero> findById(Integer idGenero);
    Optional<Genero> findByName(String name);
    List<Genero> findAll();
}
