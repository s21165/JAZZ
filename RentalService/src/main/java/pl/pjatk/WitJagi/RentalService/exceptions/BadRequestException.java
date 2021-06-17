package pl.pjatk.WitJagi.RentalService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadRequestException extends RuntimeException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerRuntimeException(BadRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}