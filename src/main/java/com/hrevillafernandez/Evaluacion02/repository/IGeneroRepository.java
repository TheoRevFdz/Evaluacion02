package com.hrevillafernandez.Evaluacion02.repository;

import com.hrevillafernandez.Evaluacion02.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {
    Optional<Genero> findByNombre(String nombre);
}
