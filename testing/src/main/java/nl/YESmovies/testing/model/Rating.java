package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import sun.java2d.cmm.Profile;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float yesRating;

    @ManyToOne
    @JsonIgnoreProperties("receivedYesRatings")
    private Movie movie;

    @ManyToOne
    @JsonIgnoreProperties("ratedMovies")
    private YesProfile yesProfile;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
