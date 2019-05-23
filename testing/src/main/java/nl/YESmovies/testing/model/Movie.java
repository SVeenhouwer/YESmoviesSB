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
    @JsonIgnoreProperties({"moviesWithGenre","profilesPreferringGenre"})
    private Set<Genre> genresOfMovie = new HashSet<>();

    public void addGenre(Genre genre){
        this.genresOfMovie.add(genre);
        genre.getMoviesWithGenre().add(this);
    }

    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties({"ratedBy","ratingFor"})
    private Set<Rating> receivedYesRatings = new HashSet<>();

    public Set<Rating> getReceivedYesRatings() {
        return this.receivedYesRatings;
    }

    public void addRating(Rating rating) {
        this.receivedYesRatings.add(rating);
        rating.setMovie(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"watchedMovies","ratedMovies","preferredGenres"})
    private Set<YesProfile> watchedBy = new HashSet<>();

    public void addWatchedBy(YesProfile yesProfile){
        this.watchedBy.add(yesProfile);
    }

    private String title;
    private short releaseYear;
    private double meanYesRating;
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

    public double getMeanYesRating() {
        return meanYesRating;
    }

    public void setMeanYesRating() {
        double total = 0;
        for(Rating rating: receivedYesRatings){
            total += rating.getYesRating();
        }
        double mean = total/receivedYesRatings.size();
        this.meanYesRating =Math.round(mean*10.0)/10.0;
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

    public Set<YesProfile> getWatchedBy() {
        return watchedBy;
    }

    public void setWatchedBy(Set<YesProfile> watchedBy) {
        this.watchedBy = watchedBy;
    }
}
