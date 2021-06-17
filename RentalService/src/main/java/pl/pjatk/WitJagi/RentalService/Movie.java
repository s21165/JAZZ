package pl.pjatk.WitJagi.RentalService;

import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.WitJagi.RentalService.exceptions.RestTemplateErrors;


public class Movie {

    private Long id;

    private String title;

    private Category category;

    private boolean isAvailable = false;

    public Movie(Long id, String title, Category category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;

        this.isAvailable = isAvailable;
    }


    public Movie() {

    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }


    public void setTitle(String name) {
        this.title = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(boolean b) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Service
    public static class RentalService {

        private final RestTemplate restTemplate;
        private final String fooResourceUrl = "http://localhost:8080/movies/";


        public RentalService(RestTemplate restTemplate) {

            this.restTemplate = restTemplate;

        }

        public Movie getMovie(Long id) {


            try {
                restTemplate.setErrorHandler(new RestTemplateErrors());
                return restTemplate.getForObject(fooResourceUrl + id, Movie.class);
            } catch (ResourceAccessException ex) {
                throw new GatewayTimeoutException();
            }

        }

        public void returnMovie(Long id) {


            try {
                restTemplate.setErrorHandler(new RestTemplateErrors());
                restTemplate.put(fooResourceUrl + "/return/" + id, Movie.class);
            } catch (ResourceAccessException ex) {
                throw new GatewayTimeoutException();
            }
        }

        public void rentMovie(Long id) {

            try {
                restTemplate.setErrorHandler(new RestTemplateErrors());
                restTemplate.put(fooResourceUrl + "/rent/" + id, Movie.class);
            } catch (ResourceAccessException ex) {
                throw new GatewayTimeoutException();
            }

        }


    }

    @RestControllerAdvice
    public static class GatewayTimeoutException extends RuntimeException {
        @ExceptionHandler(GatewayTimeoutException.class)
        public ResponseEntity<Object> handlerRuntimeException(GatewayTimeoutException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}