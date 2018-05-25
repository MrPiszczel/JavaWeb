package pl.mateusz.service;

import pl.mateusz.model.Movie;

import java.util.List;

public interface MovieService {

    void save(String name, int rate);

    List<Movie> findAllMovies();
}
