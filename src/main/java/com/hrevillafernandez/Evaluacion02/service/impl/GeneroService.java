package com.hrevillafernandez.Evaluacion02.service.impl;

import com.hrevillafernandez.Evaluacion02.models.Genero;
import com.hrevillafernandez.Evaluacion02.repository.IGeneroRepository;
import com.hrevillafernandez.Evaluacion02.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService implements IGeneroService {
    @Autowired
    private IGeneroRepository repository;

    @Override
    public Genero createGenero(Genero genero) {
        return repository.save(genero);
    }

    @Override
    public Genero updateGenero(Genero genero) {
        return repository.findById(genero.getIdGenero())
                .map(g -> repository.save(genero))
                .orElseGet(() -> null);
    }

    @Override
    public Optional<Genero> findById(Integer idGenero) {
        return repository.findById(idGenero);
    }

    @Override
    public Optional<Genero> findByName(String name) {
        return repository.findByNombre(name);
    }

    @Override
    public List<Genero> findAll() {
        return repository.findAll();
    }
}
