package movie.movieService;

import movie.movieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select title from Movie ")
    List<Movie> findAll();

    Movie save(Movie movie);

    @Modifying
    @Query("update Movie m set m.isAvailable=:isAvailable where m.id=:id")
    @Transactional
    void updateMovieAvailability(boolean isAvailable, long id);


    @Query("select u from Movie u where u.id = ?1")
    Optional<Movie> findById(Long id);

    @Query("delete from Movie m where m.id= ?1")
    void deleteById(Long id);

}
