package nl.YESmovies.testing.service;

import nl.YESmovies.testing.model.Genre;
import nl.YESmovies.testing.persistence.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre){
        return this.genreRepository.save(genre);
    }

    public Optional<Genre> findById(Long aLong) {
        return genreRepository.findById(aLong);
    }

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public void deleteById(Long aLong) {
        genreRepository.deleteById(aLong);
    }
}
