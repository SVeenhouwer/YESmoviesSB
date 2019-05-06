package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("moviesWithGenre")
    private Set<Movie> moviesWithGenre = new HashSet<>();

    public void addMovie(Movie movie){
        this.moviesWithGenre.add(movie);
        movie.getGenresOfMovie().add(this);
    }

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMoviesWithGenre() {
        return moviesWithGenre;
    }

    public void setMoviesWithGenre(Set<Movie> moviesWithGenre) {
        this.moviesWithGenre = moviesWithGenre;
    }
}
