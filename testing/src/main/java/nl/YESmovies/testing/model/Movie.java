package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "moviesWithGenre", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("moviesWithGenre")
    private Set<Genre> genresOfMovie = new HashSet<>();

    public void addGenre(Genre genre){
        this.genresOfMovie.add(genre);
        genre.getMoviesWithGenre().add(this);
    }

    @OneToMany(mappedBy = "movie")
    private Set<Rating> receivedYesRatings = new HashSet<>();

    public Set<Rating> getReceivedYesRatings() {
        return this.receivedYesRatings;
    }

    public void addRating(Rating rating) {
        this.receivedYesRatings.add(rating);
        rating.setMovie(this);
    }

    private String title;
    private short releaseYear;
    private float yesRating;
    private int nrRatings;
    private float imdbRating;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(short releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getYesRating() {
        return yesRating;
    }

    public void setYesRating(float yesRating) {
        this.yesRating = yesRating;
    }

    public int getNrRatings() {
        return nrRatings;
    }

    public void setNrRatings(int nrRatings) {
        this.nrRatings = nrRatings;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Set<Genre> getGenresOfMovie() {
        return genresOfMovie;
    }

    public void setGenresOfMovie(Set<Genre> genresOfMovie) {
        this.genresOfMovie = genresOfMovie;
    }
}
