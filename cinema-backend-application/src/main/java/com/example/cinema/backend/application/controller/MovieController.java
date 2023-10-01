package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.Movies;
import com.example.cinema.backend.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/Movie")
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movies> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
    @PostMapping("/Movie")

    public Movies createMovie(@RequestBody Movies movies) {
        return movieService.createMovies(movies);
    }
    @PutMapping("/{id}")

    public Movies updateMovie(@PathVariable Long id, @RequestBody Movies movies) {
        return movieService.updateMovie(id, movies);
    }
    @DeleteMapping("/{id}")

    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

}
