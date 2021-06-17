package pl.pjatk.WitJagi.MovieService.src.main.java.movie.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.WitJagi.MovieService.src.main.java.movie.MovieService.MovieRepository;
import pl.pjatk.WitJagi.MovieService.src.main.java.movie.MovieService.model.Movie;

import java.util.List;


@Service

public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id) {

        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        var movieToUpdate = findById(id);
        if (movie.getTitle() != null) {
            movieToUpdate.setTitle((movie.getTitle()));
        }
        if (movie.getCategory() != null) {
            movieToUpdate.setCategory(movie.getCategory());
        }

        return addMovie(movieToUpdate);
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            movieRepository.deleteById(id);
        }

    }

    public void rentMovie(boolean x, Long id) {
        movieRepository.updateMovieAvailability(x, id);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


}







