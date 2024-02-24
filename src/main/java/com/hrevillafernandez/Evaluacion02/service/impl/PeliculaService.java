package com.hrevillafernandez.Evaluacion02.service.impl;

import com.hrevillafernandez.Evaluacion02.models.Pelicula;
import com.hrevillafernandez.Evaluacion02.repository.IPeliculaRepository;
import com.hrevillafernandez.Evaluacion02.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    private IPeliculaRepository repository;

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @Override
    public List<Pelicula> findAll() {
        return repository.findAll();
    }

    @Override
    public Pelicula updatePelicula(Pelicula pelicula) {
        return repository.findById(pelicula.getIdPelicula())
                .map(p -> repository.save(pelicula))
                .orElseGet(() -> null);
    }

    @Override
    public boolean eliminarPelicula(Integer idPelicula) {
        return repository.findById(idPelicula)
                .map(p -> {
                    repository.delete(p);
                    return true;
                })
                .orElseGet(() -> false);
    }

    @Override
    public Optional<Pelicula> findById(Integer id) {
        return repository.findById(id);
    }
}
