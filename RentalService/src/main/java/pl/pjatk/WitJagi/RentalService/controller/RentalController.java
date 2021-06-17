package pl.pjatk.WitJagi.RentalService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.WitJagi.RentalService.Movie;


@RestController
@RequestMapping("")
public class RentalController {

    private final Movie.RentalService rentalService;


    public RentalController(Movie.RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {

        Movie gimme = rentalService.getMovie(id);

        return ResponseEntity.ok(gimme);
    }

    @PutMapping("/movies/return/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {

        rentalService.returnMovie(id);


        return ResponseEntity.ok().build();
    }
    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {

        rentalService.rentMovie(id);


        return ResponseEntity.ok().build();


    }
}
