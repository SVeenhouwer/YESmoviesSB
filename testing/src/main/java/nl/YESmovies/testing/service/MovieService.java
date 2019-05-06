package nl.YESmovies.testing.service;

import nl.YESmovies.testing.model.Movie;
import nl.YESmovies.testing.persistence.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public Optional<Movie> findById(Long aLong) {
        return movieRepository.findById(aLong);
    }

    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    public void deleteById(Long aLong) {
        movieRepository.deleteById(aLong);
    }
}
