package pl.mateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.model.Movie;
import pl.mateusz.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public void save(String name, int rate) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setRate(rate);

        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
       List<Movie> allMovies = movieRepository.findAllMovies();

        return allMovies;
    }
}
