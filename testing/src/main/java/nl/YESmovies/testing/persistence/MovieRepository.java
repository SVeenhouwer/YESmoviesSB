package nl.YESmovies.testing.persistence;

import nl.YESmovies.testing.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    List<Movie> findByTitleAndReleaseYear(String title, short releaseYear);
    List<Movie> findByTitleContaining(String myText);
}
