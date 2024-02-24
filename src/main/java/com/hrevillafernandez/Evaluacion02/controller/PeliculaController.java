package com.hrevillafernandez.Evaluacion02.controller;

import com.hrevillafernandez.Evaluacion02.models.Genero;
import com.hrevillafernandez.Evaluacion02.models.Pelicula;
import com.hrevillafernandez.Evaluacion02.service.IGeneroService;
import com.hrevillafernandez.Evaluacion02.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IGeneroService generoService;
    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping
    public String getAllPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.findAll();
        model.addAttribute("peliculas", peliculas);
        return "peliculaList";
    }

    @GetMapping("/register")
    public String showPliculasRegister(Model model) {
        List<Genero> generos = generoService.findAll();
        model.addAttribute("pelicula", Pelicula.builder().build());
        model.addAttribute("generos", generos);
        return "peliculasRegister";
    }

    @PostMapping("/register")
    public String createPelicula(@ModelAttribute(name = "pelicula") Pelicula pelicula) {
        pelicula.setIdPelicula(null);
        peliculaService.createPelicula(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/edit/{idPelicula}")
    public String editPelicula(@PathVariable(name = "idPelicula") Integer idPelicula, Model model){
        Optional<Pelicula> optPelicula = peliculaService.findById(idPelicula);
        if(optPelicula.isPresent()){
            final List<Genero> generos = generoService.findAll();
            model.addAttribute("pelicula", optPelicula.get());
            model.addAttribute("generos", generos);
        }
        return "peliculaEdit";
    }

    @PostMapping("/edit")
    public String updatePelicula(@ModelAttribute(name = "pelicula") Pelicula pelicula){
        peliculaService.updatePelicula(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/delete/{idPelicula}")
    public String deletePelicula(@PathVariable(name = "idPelicula") Integer idPelicula, Model model){
        peliculaService.eliminarPelicula(idPelicula);
        List<Pelicula> peliculas = peliculaService.findAll();
        model.addAttribute("peliculas", peliculas);
        return "peliculaList";
    }
}
