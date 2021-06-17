package movie.movieService.service;

import movie.movieService.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class MovieNotFoundException extends RuntimeException {
    @ExceptionHandler( MovieNotFoundException.class)
    public ResponseEntity<Object> handlerRuntimeException(MovieNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}