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
    @JsonIgnoreProperties("receivedYesRatings")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
