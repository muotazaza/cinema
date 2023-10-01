package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.Theater;
import com.example.cinema.backend.application.service.TheaterService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/Theater")
    public List<Theater> getAllTheater(){
        return theaterService.getAllTheater();

    }

    @GetMapping("/Theater/{id}")
    public Optional<Theater> getTheaterById(@PathVariable Long id){

        return theaterService.getTheaterById(id);
    }

    @PostMapping("/Theater")
    public Theater createTheater(@RequestBody Theater theater){

        return  theaterService.createTheater(theater);
    }

    @PutMapping("/Theater")
    public Theater updateTheater(@PathVariable Long id ,@RequestBody Theater theater){
        return theaterService.updateTheater(id,theater);

    }

    @DeleteMapping("/{id}")
    public void DeleteTheater(@PathVariable Long id){
        theaterService.deleteTheater(id);
    }
}
