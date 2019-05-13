package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float yesRating;

    @ManyToOne
    @JsonIgnoreProperties({"receivedYesRatings","genresOfMovie","watchedBy"})
    private Movie movie;

    @ManyToOne
    @JsonIgnoreProperties({"ratedMovies","watchedMovies","preferredGenres"})
    private YesProfile yesProfile;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public YesProfile getYesProfile() {
        return yesProfile;
    }

    public void setYesProfile(YesProfile yesProfile) {
        this.yesProfile = yesProfile;
    }

    public long getId() {
        return id;
    }

    public float getYesRating() {
        return yesRating;
    }

    public void setYesRating(float yesRating) {
        this.yesRating = yesRating;
    }

}
