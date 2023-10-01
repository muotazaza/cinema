package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.Theater;
import com.example.cinema.backend.application.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheater(){
        return theaterRepository
                .findAll();
    }
    public Optional<Theater> getTheaterById(Long id) {

        return theaterRepository.findById(id);
    }
    public Theater createTheater(Theater theater) {

        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long id, Theater theater) {
        if (
                theaterRepository.existsById(id)) {
            theater.setId(id);
            return theaterRepository.save(theater);
        }
        return null;
    }
    public void deleteTheater(Long id) {


        theaterRepository.deleteById(id);
    }

}
