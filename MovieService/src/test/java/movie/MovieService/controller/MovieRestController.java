package movie.MovieService.controller;


import movie.movieService.model.Movie;
import movie.movieService.service.MovieNotFoundException;
import movie.movieService.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
public class MovieRestController {

    private final MovieService movieService;


    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movieService.addMovie(movie));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> findMovie(@PathVariable Long id) throws MovieNotFoundException {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieService.deleteMovieById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/movies/return/{id}")
    public ResponseEntity<Void> isAvailable(@PathVariable Long id){
        movieService.rentMovie(true,id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Void> isNotAvailable(@PathVariable Long id){
        movieService.rentMovie(false,id);
        return ResponseEntity.ok().build();
    }

}






