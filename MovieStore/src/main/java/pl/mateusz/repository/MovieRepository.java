package pl.mateusz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mateusz.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value="select e from Movie e")
    List<Movie> findAllMovies();
}
