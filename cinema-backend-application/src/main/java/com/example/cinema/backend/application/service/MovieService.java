package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.Movies;
import com.example.cinema.backend.application.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movies> getAllMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movies> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    public Movies createMovies(Movies movies) {
        return movieRepository.save(movies);
    }

    public Movies updateMovie(Long id, Movies movie) {
        if (movieRepository.existsById(id)) {
            movie.setId(id);
            return movieRepository.save(movie);
        }
        return null;
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
