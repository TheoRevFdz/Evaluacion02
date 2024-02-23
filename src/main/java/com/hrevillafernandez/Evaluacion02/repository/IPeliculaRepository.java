package com.hrevillafernandez.Evaluacion02.repository;

import com.hrevillafernandez.Evaluacion02.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
