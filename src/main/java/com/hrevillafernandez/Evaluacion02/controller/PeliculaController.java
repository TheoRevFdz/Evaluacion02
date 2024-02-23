package com.hrevillafernandez.Evaluacion02.controller;

import com.hrevillafernandez.Evaluacion02.models.Pelicula;
import com.hrevillafernandez.Evaluacion02.service.IGeneroService;
import com.hrevillafernandez.Evaluacion02.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IGeneroService generoService;
    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping("/")
    public String getAllPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.findAll();
        model.addAttribute("peliculas", peliculas);
        return "peliculaList";
    }
}
